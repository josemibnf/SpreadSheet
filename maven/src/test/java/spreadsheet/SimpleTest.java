package spreadsheet;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static spreadsheet.SpreadSheet.*;

import spreadsheet.value.SomeValue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SimpleTest {

    @Before
    public void setUpSheet() throws ThisCellNotExist {
        put("a1", 42);
    }

    @Test
    public void cell_has_value_if_it_has_value() throws ThisCellNotExist {
        assertTrue(get("a1").hasValue());
    }

    @After
    public void clearSheet() {
        clear();
    }

}