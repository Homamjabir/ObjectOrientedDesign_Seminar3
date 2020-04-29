package se.kth.iv1350.pos.startup;

import se.kth.iv1350.pos.controller.Controller;
import se.kth.iv1350.pos.dbhandler.ItemDTO;
import se.kth.iv1350.pos.model.Receipt;
import se.kth.iv1350.pos.model.Sale;
import se.kth.iv1350.pos.view.View;
import java.util.Scanner;

class Main
{
    public static void main(String[] args)
    {
        Controller contr = new Controller();
        View view = new View(contr);
        Scanner scanner = new Scanner(System.in);

        Sale currentSale = contr.startSale();

        int itemIdentifier;

        System.out.println("Enter itemID:");
        while(true) {
            itemIdentifier = scanner.nextInt();

            if(itemIdentifier == 404) { break; }

            ItemDTO newItem;

            newItem = contr.scanItem(itemIdentifier);

            currentSale.uppdateSale(newItem);
            System.out.println("\n=======================================================");

            for (ItemDTO itemDTO : currentSale.getItems())
                System.out.println(itemDTO.getName() + " - " + itemDTO.getQuantity() + "x - " + itemDTO.getPrice() * itemDTO.getQuantity() + ":-");

            System.out.println(currentSale.getRunningTotal() + " SEK");
            System.out.println("=======================================================\n");
        }

        Receipt receipt = contr.getReceipt(contr.endCurrentSale(currentSale));
        System.out.println(receipt.toString());
    }
}