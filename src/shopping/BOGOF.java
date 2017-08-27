package shopping;

public class BOGOF implements Discount {

    String itemID;
    Double price;

    public BOGOF( String itemID, Double price ){
        this.itemID = itemID;
        this.price = price;
    }

    @Override
    public Double getTotalModifier( ShoppingBasket basket ) {
        int countDiscountedItems = 0;
        for ( Item item : basket.getBasket() ){

            if ( item.getId() == itemID ){
                countDiscountedItems++;
            }

        }

        return -1 * ( countDiscountedItems / 2 ) * this.price;
    }

}
