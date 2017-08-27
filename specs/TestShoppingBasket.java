import org.junit.Test;
import shopping.*;
import org.junit.Before;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestShoppingBasket {

    Item banana;
    Item orange;
    Item onePintMilk;
    ShoppingBasket fredsBasket;

    @Before
    public void before(){
        banana = new Item( 0.20, "Banana" );
        orange = new Item( 0.25, "Orange" );
        onePintMilk = new Item( 0.40, "One pint semi-skimmed milk" );
        fredsBasket = new ShoppingBasket();
    }

    @Test
    public void testEmptyOnCreate(){
        assertEquals( 0, fredsBasket.getNumberItemsInBasket() );
    }

    @Test
    public void testNoLoyaltyCardOnCreate(){
        assertFalse( fredsBasket.getLoyaltyCard() );
    }

    @Test
    public void testAddLoyaltyCard(){
        fredsBasket.customerHasLoyaltyCard();
        assertTrue( fredsBasket.getLoyaltyCard() );
    }

}