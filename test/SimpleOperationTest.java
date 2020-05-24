import Exceptions.InvalidCell;
import SpreadSheet.SpreadSheet;
import Expression.SomeValue;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class SimpleOperationTest extends SpreadSheet {

    @Before
    public void setUpSheet() throws InvalidCell {
        put("a1", 42);
        put("a2", 20);
        put("a3", mult("a1", "a2"));
    }

    @Test
    public void cell_has_value_if_depends_on_value_cells() throws InvalidCell {
        assertTrue(get("a3").hasValue());
    }

    @Test
    public void cell_evaluate_works_if_depends_on_value_cells() throws InvalidCell {
        SomeValue val = (SomeValue) get("a3");
        assertTrue(val.getValue()==840);
    }

    @After
    public void clearSheet() {
        clear();
    }

}