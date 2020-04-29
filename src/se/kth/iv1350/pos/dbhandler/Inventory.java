package se.kth.iv1350.pos.dbhandler;

import java.util.ArrayList;

public class Inventory
{

    private ArrayList<ItemDTO> items;

    public Inventory()
    {
        items = new ArrayList<>();

        items.add(new ItemDTO("INVALID ITEM", 0,0,0,0));
        items.add(new ItemDTO("Chocolate bar",1,0.06,25,0));
        items.add(new ItemDTO("Milk",         2,0.06,10,0));
        items.add(new ItemDTO("Cheese",       3,0.12,90,0));
        items.add(new ItemDTO("Dozen eggs",   4,0.12,30,0));
        items.add(new ItemDTO("Breed loaf",   5,0.25,15,0));

    }

    public boolean checkIdentifier(int itemIdentifier)
    {
        for(ItemDTO item : items)
        {
            if(item.getIdentifier() == itemIdentifier) { return true; }
        }
        return false;
    }

    public ItemDTO retrieveItemInformation(int itemIdentifier)
    {
        for(ItemDTO item : items)
        {
            if(item.getIdentifier() == itemIdentifier)
            {
                ItemDTO newItem = new ItemDTO(item);
                newItem.quantity = 1;
                return newItem;
            }
        }
        return null;
    }
}

