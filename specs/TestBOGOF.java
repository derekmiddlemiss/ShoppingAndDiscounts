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
        bananaBOGOF = new BOGOF( "Banana", 0.20 );
    }

    @Test
    public void testGetTotalModifier(){
        Double totalModifier = bananaBOGOF.getTotalModifier( basket );
        assertEquals( -0.20, totalModifier, 0.001 );
    }


}
