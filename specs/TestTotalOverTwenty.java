import org.junit.Before;
import org.junit.Test;
import shopping.*;

import static org.junit.Assert.assertEquals;

public class TestTotalOverTwenty {

    ShoppingBasket basket;
    Item bananaOne;
    Item bananaTwo;
    Item bananaThree;
    Item orange;
    Item coffee;
    Item TV;
    TotalOverTwenty totalOverTwenty;

    @Before
    public void before(){
        bananaOne = new Item( 0.20, "Banana" );
        bananaTwo = new Item( 0.20, "Banana" );
        bananaThree = new Item( 0.20, "Banana" );
        orange = new Item( 0.30, "Jaffa Orange" );
        coffee = new Item( 2.50, "Ground Colombian Coffee" );
        TV = new Item( 200.0, "MultiJunk Flatscreen TV" );
        basket = new ShoppingBasket();
        basket.addItemToBasket( bananaOne );
        basket.addItemToBasket( bananaTwo );
        basket.addItemToBasket( bananaThree );
        basket.addItemToBasket( orange );
        basket.addItemToBasket( coffee );
        basket.addItemToBasket( TV );
        totalOverTwenty = new TotalOverTwenty();
    }

    @Test
    public void testGetNewSubtotal__OverTwenty(){
        Double newSubtotal = totalOverTwenty.getNewSubtotal( basket, 203.40 );
        assertEquals( 183.06, newSubtotal, 0.001 );
    }

    @Test
    public void testGetNewSubtotal__NotOverTwenty(){
        basket.removeItemFromBasket( TV );
        Double newSubtotal = totalOverTwenty.getNewSubtotal( basket, 3.40 );
        assertEquals( 3.40, newSubtotal, 0.001 );
    }

    @Test
    public void testGetPrecedence(){
        assertEquals( 2, totalOverTwenty.getPrecedence() );
    }

}
