package se.kth.iv1350.pos.controller;

import se.kth.iv1350.pos.dbhandler.ItemDTO;
import se.kth.iv1350.pos.model.*;

public class Controller
{
    private CashRegister cashRegister;

    public Controller() {
        this.cashRegister = new CashRegister();

    }

    public Sale startSale() {
        return cashRegister.createNewSale();

    }

    public ItemDTO scanItem(int itemIdentifier) {

        return cashRegister.scanIdentifier(itemIdentifier);
    }


    public Receipt getReceipt(SaleDTO saleDTO)
    {
        return cashRegister.createReceipt(saleDTO);
    }

    public SaleDTO endCurrentSale(Sale currentSale)
    {
        return cashRegister.endCurrentSale(currentSale);
    }


}
