import SpreadSheet.SpreadSheet;
import Exceptions.InvalidCell;

import org.junit.Test;
import Value.SomeValue;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class SpreadSheetTest extends SpreadSheet {

    @BeforeEach
    public void setUpSheet() throws InvalidCell {
        put("a3", mult("a1", "a2"));
    }

    @Test
    public void cell_has_no_value_if_depends_on_empty_cells() throws InvalidCell {
        assertFalse(get("a3").hasValue());
    }

    @Test
    public void recalculation_works() throws InvalidCell {
        put("a1", 42);
        put("a2", 20);
        assertEquals(new SomeValue(840), get("a3"));
    }

    @AfterEach
    public void clearSheet() {
        clear();
    }

}