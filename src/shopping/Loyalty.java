package shopping;

public class Loyalty implements Discount {

    int precedence;

    public Loyalty(){
        this.precedence = 3;
    }

    public Double getNewSubtotal(ShoppingBasket basket, Double oldSubtotal) {
        if ( basket.getLoyaltyCard() ){
            return oldSubtotal * 0.98;
        } else {
            return oldSubtotal;
        }

    }

    public int getPrecedence() {
        return this.precedence;
    }

}
