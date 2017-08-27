package shopping;

public class Item {

    Double price;
    String id;

    public Item( Double price, String id){
        this.price = price;
        this.id = id;
    }

    public Double getPrice() {
        return this.price;
    }

    public String getId() {
        return this.id;
    }
}
