package se.kth.iv1350.pos.model;

import java.util.*;
import se.kth.iv1350.pos.dbhandler.ItemDTO;


public class SaleDTO
{
    private ArrayList<ItemDTO> itemsBought;
    private double VAT;
    private double totalPrice;
    private double change;

    SaleDTO(Sale sale)
    {
        this.itemsBought = sale.getItems();
        this.VAT = sale.getVat();
        this.totalPrice = sale.getRunningTotal();
        this.change = sale.getChange();
    }

    double getTotalPrice()
    {
        return totalPrice;
    }

    ArrayList<ItemDTO> getItems()
    {
        return itemsBought;
    }

    double getVAT()
    {
        return VAT;
    }

    double getChange()
    {
        return change;
    }
}