import SpreadSheet.SpreadSheet;
import SpreadSheet.ThisCellNotExist;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import val.SomeValue;

import static org.junit.Assert.assertTrue;

public class CellHasValueTest extends SpreadSheet {

    @Before
    public void setUpSheet() throws ThisCellNotExist {
        put("a1", 42);
        put("a2", 20);
        put("a3", mult("a1", "a2"));
    }

    @Test
    public void cell_has_value_if_depends_on_value_cells() throws ThisCellNotExist {
        if (get("a3").hasValue()) {
            SomeValue val = (SomeValue) get("a3");
            System.out.println(val.getValue());
        } else {
            System.out.println("Is java.main.NoValue");
        }
        assertTrue(get("a3").hasValue());
    }

    @After
    public void clearSheet() {
        clear();
    }

}