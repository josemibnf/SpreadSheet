package spreadsheet;

import static spreadsheet.SpreadSheet.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import spreadsheet.value.SomeValue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SpreadSheetTest {

    @Before
    public void setUpSheet() throws InvalidCell {
        put("a3", mult("a1", "a2"));
    }

    @Before
    public void cell_has_no_value_if_depends_on_empty_cells() throws InvalidCell {
        put("a1", 42);
        put("a2", 20);
        assertFalse(get("a3").hasValue());
    }

    @Test
    public void recalculation_works() throws InvalidCell {
        assertEquals(new SomeValue(840), get("a3"));
    }

    @Test
    public void recalculation_works_without_MaybeValue() throws InvalidCell {
        assertEquals(840, ((SomeValue) get("a3")).getValue());
    }

    @After
    public void clearSheet() {
        clear();
    }

}