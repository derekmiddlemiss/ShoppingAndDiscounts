package shopping;

import java.util.ArrayList;

public class Checkout {

    ShoppingBasket basket;
    DiscountList discounts;

    public Checkout(){
    }

    public void loadBasket( ShoppingBasket basket ){
        this.basket = basket;
    }

    public void addDiscount( Discount discount ){
        this.discounts.addDiscount( discount );
    }

    public void removeDiscount( Discount discount ){
        this.discounts.removeDiscount( discount );
    }

    public Double ringUpItems(){
        if ( this.basket != null ) {
            Double total = this.getInitialTotal();
            
        }
    }

    private Double getInitialTotal(){
        Double total = 0.0;
        for (Item item : this.basket ) {
            total += item.getPrice();
        }
        return total;
    }

}
