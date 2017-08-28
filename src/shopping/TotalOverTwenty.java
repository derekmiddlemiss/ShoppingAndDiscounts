package shopping;

public class TotalOverTwenty extends Discount {

    public TotalOverTwenty() {
        super( "Total over £20 discount" );
        this.precedence = 2;
    }

    public Double getNewSubtotal(ShoppingBasket basket, Double oldSubtotal) {
        if ( oldSubtotal > 20.0 ){
            return oldSubtotal * 0.9;
        } else {
            return oldSubtotal;
        }
    }

}
