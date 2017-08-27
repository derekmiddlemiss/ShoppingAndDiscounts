package shopping;

public class TotalOverTwenty implements Discount {

    int precedence;

    public TotalOverTwenty(){
        this.precedence = 2;
    }

    public Double getNewSubtotal(ShoppingBasket basket, Double oldSubtotal) {
        if ( oldSubtotal > 20.0 ){
            return oldSubtotal * 0.9;
        } else {
            return oldSubtotal;
        }
    }

    public int getPrecedence() {
        return this.precedence;
    }

}
