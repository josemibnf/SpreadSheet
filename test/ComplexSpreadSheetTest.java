import SpreadSheet.SpreadSheet;
import Exceptions.InvalidCell;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import Value.SomeValue;

public class ComplexSpreadSheetTest extends SpreadSheet {

    @Before
    public void setUp() throws InvalidCell {
        put("c1", mult("a1", "b1"));
        put("c2", mult("a2", "b2"));
        put("c3", plus("c1", "c2"));

        put("a1", 10); put("b1", 20);
        put("a2", 30); put("b2", 40);
    }

    @Test
    public void value_of_a1() throws InvalidCell {
        SomeValue val = (SomeValue) get("a1");
        assertTrue(val.getValue()==10);
    }

    @Test
    public void value_of_c1() throws InvalidCell {
        SomeValue val = (SomeValue) get("c1");
        assertTrue(val.getValue()==200);
    }

    @Test
    public void value_of_c2() throws InvalidCell {
        SomeValue val = (SomeValue) get("c2");
        assertTrue(val.getValue()==1200);
    }

    @Test
    public void chained_expressions() throws InvalidCell {
        SomeValue val = (SomeValue) get("c3");
        assertTrue(val.getValue()==1400);
    }

    @Test
    public void chained_propagations_a1() throws InvalidCell {
        put("a1", "b1");
        SomeValue val = (SomeValue) get("a1");
        assertTrue(val.getValue()==20);
    }

    @Test
    public void chained_propagations() throws InvalidCell {
        put("a1", "b1");
        SomeValue val = (SomeValue) get("c3");
        assertTrue(val.getValue()==1600);
    }

    @After
    public void tearDown(){
        clear();
    }
}