import org.junit.Before;
import org.junit.Test;
import shopping.*;

import static org.junit.Assert.assertEquals;

public class TestBOGOF {

    ShoppingBasket basket;
    Item bananaOne;
    Item bananaTwo;
    Item bananaThree;
    Item orange;
    Item coffee;
    BOGOF bananaBOGOF;

    @Before
    public void before(){
        bananaOne = new Item( 0.20, "Banana" );
        bananaTwo = new Item( 0.20, "Banana" );
        bananaThree = new Item( 0.20, "Banana" );
        orange = new Item( 0.30, "Jaffa Orange" );
        coffee = new Item( 2.50, "Ground Colombian Coffee");
        basket = new ShoppingBasket();
        basket.addItemToBasket( bananaOne );
        basket.addItemToBasket( bananaTwo );
        basket.addItemToBasket( bananaThree );
        basket.addItemToBasket( orange );
        basket.addItemToBasket( coffee );
        bananaBOGOF = new BOGOF( "Banana", 0.20, "Two for one on bananas" );
    }

    @Test
    public void testGetNewSubtotal__ThreeBananasSoOneBananaFree(){
        Double newSubtotal = bananaBOGOF.getNewSubtotal( basket, 3.40 );
        assertEquals( 3.20, newSubtotal, 0.001 );
    }

    @Test
    public void testGetNewSubtotal__TwoBananasSoOneBananaFree(){
        basket.removeItemFromBasket( bananaThree );
        Double newSubtotal = bananaBOGOF.getNewSubtotal( basket, 3.20 );
        assertEquals( 3.00, newSubtotal, 0.001 );
    }

    @Test
    public void testGetNewSubtotal__OneBananaSoNoFreeBanana(){
        basket.removeItemFromBasket( bananaTwo );
        basket.removeItemFromBasket( bananaThree );
        Double newSubtotal = bananaBOGOF.getNewSubtotal( basket, 3.00 );
        assertEquals( 3.00, newSubtotal, 0.001 );
    }

    @Test
    public void testGetPrecedence(){
        assertEquals( 1, bananaBOGOF.getPrecedence() );
    }

}
