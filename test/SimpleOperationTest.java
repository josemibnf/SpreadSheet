import Exceptions.InvalidCell;
import Expression.SomeValue;
import SpreadSheet.SpreadSheet;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SimpleOperationTest extends SpreadSheet {

    @BeforeEach
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
        assertTrue(val.getVALUE() == 840);
    }

    @AfterEach
    public void clearSheet() {
        clear();
    }

}