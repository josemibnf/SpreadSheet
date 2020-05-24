import Exceptions.InvalidCell;
import Expression.SomeValue;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static SpreadSheet.SpreadSheet.*;
import static org.junit.jupiter.api.Assertions.*;

public class ModifyAfterTest {

    @BeforeEach
    public void setUpSheet() throws InvalidCell {
        put("a3", mult("a1", "a2"));
        assertFalse(get("a3").hasValue());
    }

    @Test
    public void recalculation_works() throws InvalidCell {
        put("a1", 42);
        put("a2", 20);
        SomeValue val = (SomeValue) get("a3");
        assertEquals(840, val.getValue());
    }

    @Test
    public void has_value_works() throws InvalidCell {
        put("a1", 42);
        put("a2", 20);
        assertTrue(get("a3").hasValue());
    }

    @AfterEach
    public void clearSheet() {
        clear();
    }
}
