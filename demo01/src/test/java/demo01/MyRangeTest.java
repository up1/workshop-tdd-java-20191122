package demo01;

import static org.junit.Assert.*;

import org.junit.Test;

public class MyRangeTest {
    
    @Test(expected = InputFormatInvalidException.class) 
    public void 
    invalid_input() {
        MyRange r = new MyRange("|1,5|");
        r.validate();
    }
    
    @Test public void 
    first_number_with_exclude() {
        MyRange r = new MyRange("(1,5)");
        assertEquals(2, r.getFirstNumber());
    }
    
    @Test public void 
    first_number_with_include() {
        MyRange r = new MyRange("[1,5)");
        assertEquals(1, r.getFirstNumber());
    }
    
    @Test public void 
    end_with_exclude() {
        MyRange r = new MyRange("[1,5)");
        assertFalse(r.endWithInclude());
    }
    
    @Test public void 
    end_with_include() {
        MyRange r = new MyRange("[1,5]");
        assertTrue(r.endWithInclude());
    }
    
    @Test public void 
    start_with_exclude() {
        MyRange r = new MyRange("(1,5]");
        assertFalse(r.startWithInclude());
    }

    @Test public void 
    start_with_include() {
        MyRange r = new MyRange("[1,5]");
        assertTrue(r.startWithInclude());
    }

}
