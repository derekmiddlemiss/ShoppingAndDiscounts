package shopping;

public class BOGOF implements Discount {

    String itemID;
    Double price;
    int order;

    public BOGOF( String itemID, Double price ){
        this.itemID = itemID;
        this.price = price;
        this.order = 1;
    }

    public Double getTotalModifier( ShoppingBasket basket ) {
        int countDiscountedItems = 0;
        for ( Item item : basket.getBasket() ){

            if ( item.getId() == itemID ){
                countDiscountedItems++;
            }

        }

        return -1 * ( countDiscountedItems / 2 ) * this.price;
    }

    public int getOrder(){
        return this.order;
    }

}
