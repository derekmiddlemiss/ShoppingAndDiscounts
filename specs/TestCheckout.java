import org.junit.Before;
import org.junit.Test;
import shopping.*;

import static org.junit.Assert.*;

public class TestCheckout {

    Checkout bleepy;
    ShoppingBasket basket;
    Item bananaOne;
    Item bananaTwo;
    Item bananaThree;
    Item orange;
    Item coffee;
    Item TV;
    BOGOF bananaBOGOF;
    TotalOverTwenty totalOverTwenty;
    Loyalty loyalty;

    @Before
    public void before() {
        bananaOne = new Item(0.20, "Banana");
        bananaTwo = new Item(0.20, "Banana");
        bananaThree = new Item(0.20, "Banana");
        orange = new Item(0.30, "Jaffa Orange");
        coffee = new Item(2.50, "Ground Colombian Coffee");
        TV = new Item(200.0, "MultiJunk Flatscreen TV");
        basket = new ShoppingBasket();
        basket.addItemToBasket(bananaOne);
        basket.addItemToBasket(bananaTwo);
        basket.addItemToBasket(bananaThree);
        basket.addItemToBasket(orange);
        basket.addItemToBasket(coffee);
        basket.addItemToBasket(TV);
        bananaBOGOF = new BOGOF( "Banana", 0.20 );
        totalOverTwenty = new TotalOverTwenty();
        loyalty = new Loyalty();
        bleepy = new Checkout();
    }

    @Test
    public void testNoBasketLoadedOnCreate(){
        assertFalse( bleepy.getBasketLoaded() );
    }

    @Test
    public void testLoadBasket(){
        bleepy.loadBasket( basket );
        assertTrue( bleepy.getBasketLoaded() );
    }

    @Test
    public void testRingUpItems__NoDiscounts(){
        bleepy.loadBasket( basket );
        assertEquals( 203.40, bleepy.ringUpItems(), 0.001 );
    }

    @Test
    public void testRingUpItems__BananaBOGOF(){
        bleepy.loadBasket( basket );
        bleepy.addDiscount( bananaBOGOF );
        assertEquals( 203.20, bleepy.ringUpItems(), 0.001 );
    }

    @Test
    public void testRingUpItems_BananaBOGOFThenTotalOverTwenty(){
        bleepy.loadBasket( basket );
        bleepy.addDiscount( bananaBOGOF );
        bleepy.addDiscount( totalOverTwenty );
        assertEquals( 182.88, bleepy.ringUpItems(), 0.001 );
    }

    @Test
    public void testRingUpItems_BananaBOGOFThenTotalOverTwentyThenLoyalty__CustomerHasNoCard(){
        bleepy.loadBasket( basket );
        bleepy.addDiscount( bananaBOGOF );
        bleepy.addDiscount( totalOverTwenty );
        bleepy.addDiscount( loyalty );
        assertEquals( 182.88, bleepy.ringUpItems(), 0.001 );
    }

    @Test
    public void testRingUpItems_BananaBOGOFThenTotalOverTwentyThenLoyalty__CustomerHasCard(){
        basket.customerHasLoyaltyCard();
        bleepy.loadBasket( basket );
        bleepy.addDiscount( bananaBOGOF );
        bleepy.addDiscount( totalOverTwenty );
        bleepy.addDiscount( loyalty );
        assertEquals( 179.22, bleepy.ringUpItems(), 0.01 );
    }

}
