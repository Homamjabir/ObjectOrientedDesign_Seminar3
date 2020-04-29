package sv.kth.iv1350.pos.dbhandler;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ItemTest
{
    Inventory inv;
    Item item;

    @Before
    public void setUp() throws Exception
    {
        inv = new Inventory(true);
        item = new Item(inv.retrieveItem(1000L));
    }

    @After
    public void tearDown() throws Exception
    {
        inv = null;
        item = null;
    }

    @Test
    public void getQuantity()
    {
        int expectedQuantity = 1;
        Assert.assertEquals(expectedQuantity, item.getQuantity());
    }

    @Test
    public void setQuantity()
    {
        item.setQuantity(2);
        int expectedQuantity = 2;
        Assert.assertEquals(expectedQuantity, item.getQuantity());
    }
}