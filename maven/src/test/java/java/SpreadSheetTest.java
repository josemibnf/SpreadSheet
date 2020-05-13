package java;

import java.beans.Transient;

import org.junit.Before;
import org.junit.Test;

public class SpreadSheetTest {

    @Before
    public void setUpSheet() {
        put("a3", mult("a1", "a2"));
    }    

    @Before
    public void cell_has_no_value_if_depends_on_empty_cells() {
        assertFalse( get("a3").hasValue());
    }

    @Test
    public void recalculation_works() {
        put("a1", 42);
        put("a2", 20);
        assertEquals(new SomeValue(840), get("a3")); 
    }

    @AfterEach
    public void clearSheet() {
        clear();
    }

}