package java;

import java.beans.Transient;

import org.junit.*;

public class ComplexSpreadSheetTest {

    @Before
    public void setUp() {
        put("c1", mult("a1", "b1")); 
        put("c2", mult("a2", "b2")); 
        put("c3", plus("c1", "c2")); 

        put("a1", 10); put("b1", 20);
        put("a2", 30); put("b2", 40);
    }

    @Test
    public void chained_expressions() {
        assertEquals( new SomeValue(1400), get("c3"));
    }

    @Test
    public void chained_propagations() {
        put("a1", "b1");
        assertEquals(new SomeValue(1600), get("c3")); 
    }

    @After
    public void tearDown(){
        clear();
    }
}