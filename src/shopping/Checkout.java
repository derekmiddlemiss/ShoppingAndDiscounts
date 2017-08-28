package shopping;

import java.util.ArrayList;

public class Checkout {

    ShoppingBasket basket;
    DiscountList discounts;
    Boolean basketLoaded;

    public Checkout(){
        this.basketLoaded = false;
        this.discounts = new DiscountList();
    }

    public void loadBasket( ShoppingBasket basket ){
        this.basket = basket;
        this.basketLoaded = true;
    }

    public void unloadBasket(){
        this.basket = null;
        this.basketLoaded = false;
    }

    public Boolean getBasketLoaded(){
        return this.basketLoaded;
    }

    public void addDiscount( Discount discount ){
        this.discounts.addDiscount( discount );
    }

    public void removeDiscount( Discount discount ){
        this.discounts.removeDiscount( discount );
    }

    public Double ringUpItems(){
        if ( this.basketLoaded ) {

            Double total = this.getInitialTotal();
            System.out.println( "Subtotal before discounts = £" + total.toString() );

            int numberOfDiscounts = this.discounts.getNumberOfDiscounts();
            for ( int i = 0; i < numberOfDiscounts; i++ ){
                Discount discount = this.discounts.getDiscountAtIndex( i );
                total = discount.getNewSubtotal( basket, total );
                System.out.println( "Discount: " + discount.getName() + " Subtotal = £" + total.toString() );
            }

            System.out.println( "Total = £" + total.toString() );
            return total;

        } else {

            return 0.0;

        }
    }

    private Double getInitialTotal(){
        Double total = 0.0;
        for (Item item : this.basket.getBasket() ) {
            total += item.getPrice();
        }
        return total;
    }

}
