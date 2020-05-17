import SpreadSheet.SpreadSheet;
import SpreadSheet.ThisCellNotExist;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class SimpleTest extends SpreadSheet {

    @Before
    public void setUpSheet() throws ThisCellNotExist {
        put("c2", 42);
        put("a1", "c2");

    }

    @Test
    public void cell_has_value_if_it_has_value_c2__before() throws ThisCellNotExist {
        assertTrue(get("c2").hasValue());
    }

    @Test
    public void cell_has_value_if_it_has_value_a1() throws ThisCellNotExist {
        assertTrue(get("a1").hasValue());
    }

    @Test
    public void cell_has_value_if_it_has_value_c2() throws ThisCellNotExist {
        assertTrue(get("c2").hasValue());
    }

    @After
    public void clearSheet() {
        clear();
    }

}