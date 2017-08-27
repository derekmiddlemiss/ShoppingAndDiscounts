import org.junit.Before;
import org.junit.Test;
import shopping.*;

import static org.junit.Assert.assertEquals;

public class TestItem {

    Item banana;

    @Before
    public void before(){
        banana = new Item( 0.20, "Banana");
    }

    @Test
    public void testGetPrice(){
        assertEquals( 0.20, banana.getPrice(), 0.001 );
    }

    @Test
    public void testGetID(){
        assertEquals( "Banana", banana.getId() );
    }

}
