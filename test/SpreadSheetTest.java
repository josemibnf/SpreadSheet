import Exceptions.InvalidCell;
import Expression.SomeValue;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static SpreadSheet.SpreadSheet.*;
import static org.junit.jupiter.api.Assertions.*;

public class SpreadSheetTest {

    @BeforeEach
    public void setUpSheet() throws InvalidCell {
        put("a3", mult("a1", "a2"));
    }

    @Test
    public void cell_has_no_value_if_depends_on_empty_cells() throws InvalidCell {
        System.out.println("cell_has_no_value_if_depends_on_empty_cells");

        assertFalse(get("a3").hasValue());
    }

    @Test
    public void recalculation_works() throws InvalidCell {
        System.out.println("recalculation_works");

        put("a1", 42);
        put("a2", 20);
        assertEquals(new SomeValue(840), get("a3"));
    }

    @AfterEach
    public void clearSheet() {
        System.out.println("clear");
        clear();
    }
}