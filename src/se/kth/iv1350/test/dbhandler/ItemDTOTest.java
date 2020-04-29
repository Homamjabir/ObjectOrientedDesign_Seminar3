package se.kth.iv1350.test.dbhandler;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import se.kth.iv1350.pos.dbhandler.Inventory;
import se.kth.iv1350.pos.dbhandler.ItemDTO;

public class ItemDTOTest
{
    private Inventory inv;
    private ItemDTO itemDTO;

    @Before
    public void setUp() throws Exception
    {
        inv = new Inventory();
        itemDTO = inv.retrieveItemInformation(1);
    }

    @After
    public void tearDown() throws Exception
    {
        inv = null;
        itemDTO = null;
    }

    @Test
    public void getNAME()
    {
        String expectedName = "Marabou Choklad 200g";
        Assert.assertEquals(expectedName, itemDTO.getName());
    }

    @Test
    public void getPRICE()
    {
        float expectedPrice = 24.99f;
        Assert.assertEquals(expectedPrice, itemDTO.getPrice(), 0f);
    }

    @Test
    public void getIDENTIFIER()
    {
        long expectedIfentifier = 1000L;
        Assert.assertEquals(expectedIfentifier, itemDTO.getIdentifier());
    }

    @Test
    public void getVAT()
    {
        float expectedVAT = 0.12f;
        Assert.assertEquals(expectedVAT, itemDTO.getVAT(), 0f);
    }

    @Test
    public void getQUANTITY()
    {
        int expectedQuantity = 1;
        Assert.assertEquals(expectedQuantity, itemDTO.getQuantity());
    }
}