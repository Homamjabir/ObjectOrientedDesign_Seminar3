package se.kth.iv1350.pos.dbhandler;

import java.util.ArrayList;

public class Inventory
{

    private ArrayList<ItemDTO> items;

    /**
     * Constructor to create an instance of Inventory
     */
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

    /**
     * Checks if itemIdentifier in argument matches any identifier in the inventory
     * @param itemIdentifier Identifier of item to check
     * @return True if identifier is found in inventory, false otherwise
     */
    public boolean checkIdentifier(int itemIdentifier)
    {
        for(ItemDTO item : items)
        {
            if(item.getIdentifier() == itemIdentifier) { return true; }
        }
        return false;
    }

    /**
     * Looks for an item with the same identifier.
     * @param itemIdentifier Identifier to retrieve item of
     * @return return ItemDTO of given identifier
     */
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

