package shopping;

public abstract class Discount {

    String name;
    int precedence;

    public Discount( String name ){
        this.name = name;
    }

    public abstract Double getNewSubtotal( ShoppingBasket basket, Double oldSubtotal );

    public int getPrecedence(){
        return this.precedence;
    }

    public String getName(){
        return this.name;
    }

}
