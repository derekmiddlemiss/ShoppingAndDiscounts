import org.junit.Before;
import org.junit.Test;
import shopping.*;

import static org.junit.Assert.assertEquals;

public class TestLoyalty {

    ShoppingBasket basket;
    Item bananaOne;
    Item bananaTwo;
    Item bananaThree;
    Item orange;
    Item coffee;
    Loyalty loyalty;

    @Before
    public void before() {
        bananaOne = new Item(0.20, "Banana");
        bananaTwo = new Item(0.20, "Banana");
        bananaThree = new Item(0.20, "Banana");
        orange = new Item(0.30, "Jaffa Orange");
        coffee = new Item(2.50, "Ground Colombian Coffee");
        basket = new ShoppingBasket();
        basket.addItemToBasket(bananaOne);
        basket.addItemToBasket(bananaTwo);
        basket.addItemToBasket(bananaThree);
        basket.addItemToBasket(orange);
        basket.addItemToBasket(coffee);
        loyalty = new Loyalty();
    }

    @Test
    public void testGetNewSubtotal__NoLoyaltyCard(){
        Double newSubtotal = loyalty.getNewSubtotal( basket, 3.40 );
        assertEquals( 3.40, newSubtotal, 0.001 );
    }

    @Test
    public void testGetNewSubtotal__HasLoyaltyCard(){
        basket.customerHasLoyaltyCard();
        Double newSubtotal = loyalty.getNewSubtotal( basket, 3.40 );
        assertEquals( 3.33, newSubtotal, 0.01 );
    }

    @Test
    public void testGetPrecedence(){
        assertEquals( 3, loyalty.getPrecedence() );
    }

}