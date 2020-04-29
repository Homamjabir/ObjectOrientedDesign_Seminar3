package se.kth.iv1350.pos.dbhandler;

public class ItemDTO
{
    int identifier;
    String name;
    double VAT;
    double price;
    int quantity;

    public ItemDTO(String name, int identfier, double VAT, double price, int quantity)
    {
        this.identifier = identfier;
        this.name = name;
        this.VAT = VAT;
        this.price = price;
        this.quantity = quantity;
    }

    public ItemDTO(ItemDTO item)
    {
        this.identifier = item.identifier;
        this.name = item.name;
        this.VAT = item.VAT;
        this.price = item.price;
        this.quantity = item.quantity;
    }

    public int getIdentifier()
    {
        return identifier;
    }

    public String getName()
    {
        return name;
    }

    public double getVAT()
    {
        return VAT;
    }

    public double getPrice()
    {
        return price;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public void setQuantity(int newQuantity)
    {
        quantity = newQuantity;
    }
}
