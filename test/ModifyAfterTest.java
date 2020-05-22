

import static SpreadSheet.SpreadSheet.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import Exceptions.InvalidCell;
import Value.SomeValue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ModifyAfterTest {

    @Before
    public void setUpSheet() throws InvalidCell {
        put("a3", mult("a1", "a2"));
        assertFalse(get("a3").hasValue());
    }

    @Test
    public void recalculation_works() throws InvalidCell {
        put("a1", 42);
        put("a2", 20);
        SomeValue val = (SomeValue) get("a3");
        assertTrue(val.getValue()==840);
    }

    @Test
    public void has_value_works() throws InvalidCell {
        put("a1", 42);
        put("a2", 20);
        assertTrue(get("a3").hasValue());
    }

    @After
    public void clearSheet() {
        clear();
    }
}
