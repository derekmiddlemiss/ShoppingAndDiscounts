package shopping;

public class BOGOF implements Discount {

    String itemID;
    Double price;
    int precedence;

    public BOGOF( String itemID, Double price ){
        this.itemID = itemID;
        this.price = price;
        this.precedence = 1;
    }

    public Double getNewSubtotal( ShoppingBasket basket, Double oldSubtotal ) {
        int countDiscountedItems = 0;
        for ( Item item : basket.getBasket() ){

            if ( item.getId() == itemID ){
                countDiscountedItems++;
            }

        }

        return oldSubtotal - ( countDiscountedItems / 2 ) * this.price;
    }

    public int getPrecedence(){
        return this.precedence;
    }

}
