package shopping;

public interface Discount {

    Double getNewSubtotal( ShoppingBasket basket, Double oldSubtotal );

    int getPrecedence();

}
