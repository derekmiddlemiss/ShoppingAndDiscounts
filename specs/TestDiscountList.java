import org.junit.Before;
import org.junit.Test;
import shopping.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;

public class TestDiscountList {

    BOGOF bananaBOGOF;
    BOGOF plumBOGOF;
    TotalOverTwenty totalOverTwenty;
    Loyalty loyalty;
    DiscountList list;

    @Before
    public void before(){
        bananaBOGOF = new BOGOF( "Banana", 0.20, "Two for one on bananas");
        plumBOGOF = new BOGOF( "Plum", 0.15, "Two for one on plums" );
        totalOverTwenty = new TotalOverTwenty();
        loyalty = new Loyalty();
        list = new DiscountList();
    }

    @Test
    public void testListEmptyOnCreate(){
        assertEquals( 0, list.getNumberOfDiscounts() );
    }

    @Test
    public void addADiscount(){
        list.addDiscount( bananaBOGOF );
        assertEquals( 1, list.getNumberOfDiscounts() );
    }

    @Test
    public void testGetDiscountAtIndex(){
        list.addDiscount( bananaBOGOF );
        Discount discount = list.getDiscountAtIndex( 0 );
        assertSame( bananaBOGOF, discount );
    }

    @Test
    public void addDiscountsCheckOrderedByPrecedence(){
        list.addDiscount( loyalty );
        list.addDiscount( totalOverTwenty );
        list.addDiscount( bananaBOGOF );
        Discount discount1 = list.getDiscountAtIndex(0);
        Discount discount2 = list.getDiscountAtIndex(1);
        Discount discount3 = list.getDiscountAtIndex(2);
        assertSame( bananaBOGOF, discount1 );
        assertSame( totalOverTwenty, discount2 );
        assertSame( loyalty, discount3 );
    }

    @Test
    public void removeADiscount(){
        list.addDiscount( bananaBOGOF );
        list.addDiscount( totalOverTwenty );
        assertEquals( 2, list.getNumberOfDiscounts() );
        list.removeDiscount( bananaBOGOF );
        assertEquals( 1, list.getNumberOfDiscounts() );
        Discount discount = list.getDiscountAtIndex( 0 );
        assertSame( totalOverTwenty, discount );
    }

}
