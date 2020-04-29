package se.kth.iv1350.pos.model;

import se.kth.iv1350.pos.dbhandler.ExternalAccountingSystem;
import se.kth.iv1350.pos.dbhandler.Inventory;
import se.kth.iv1350.pos.dbhandler.ItemDTO;
import se.kth.iv1350.pos.dbhandler.Printer;
import se.kth.iv1350.pos.model.Sale;

import java.util.Scanner;

public class CashRegister
{
    private Inventory inventory;
    private Sale sale;
    private Printer printer;
    private double totalInCashRegister;
    private ExternalAccountingSystem eAS;
    private double amountPresent;
    private double amountNeeded;
    private Scanner scanner;

    /**
     * Constructor for the class CashRegister. Creates an instance with necessary initializations
     */

    public CashRegister()
    {
        inventory = new Inventory();
        sale = new Sale();
        printer = new Printer();
        scanner = new Scanner(System.in);
        eAS = new ExternalAccountingSystem();
    }

    /**
     * Searches for Item in Inventory by checking the identifiers and updated the sale price
     * @param itemIdentifier Identifier which is unique to each type of item
     * @return ItemDTO of Item with matching identifiers
     */

    public ItemDTO scanIdentifier(int itemIdentifier)
    {
        boolean isIdentifierReal = inventory.checkIdentifier(itemIdentifier);

        if(isIdentifierReal)
        {
            ItemDTO foundItem = inventory.retrieveItemInformation(itemIdentifier);
            updateAmountNeeded(foundItem.getPrice());
            return foundItem;
        }
        return null;
    }

    /**
     * @return New Sale object
     */
    public Sale createNewSale() {
        return new Sale();
    }

    /**
     * Creates a Receipt object from the saleDTO argument
     * @param saleDTO Sale information
     * @return Receipt object
     */
    public Receipt createReceipt(SaleDTO saleDTO) {
        return printer.printReceipt(saleDTO);
    }

    /**
     * Ends the given Sale
     * @param currentSale The Sale that will be ended
     * @return SaleDTO from the Sale argument
     */
    public SaleDTO endCurrentSale(Sale currentSale) {
        while(amountNeeded > amountPresent) {
            System.out.println("Amount needed: " + (amountNeeded - amountPresent));
            System.out.print("Enter customer payment: ");
            updateAmountPresent(scanner.nextDouble());
        }
        System.out.println();

        if(amountPresent > amountNeeded)
            currentSale.setChange(calculateChange());

        totalInCashRegister += amountNeeded;
        currentSale.calculateVAT();

        SaleDTO finalSaleDTO = new SaleDTO(currentSale);

        eAS.addLog(finalSaleDTO);

        return finalSaleDTO;

    }

    private void updateAmountPresent(double amount) {
        amountPresent += amount;
    }


    private void updateAmountNeeded(double amount) {
        amountNeeded += amount;
    }

    private double calculateChange() {
        return amountPresent - amountNeeded;
    }
}