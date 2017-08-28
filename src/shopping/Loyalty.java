package shopping;

public class Loyalty extends Discount {

    public Loyalty(){
        super("Loyalty discount");
        this.precedence = 3;
    }

    public Double getNewSubtotal(ShoppingBasket basket, Double oldSubtotal) {
        if ( basket.getLoyaltyCard() ){
            return oldSubtotal * 0.98;
        } else {
            return oldSubtotal;
        }

    }

}
