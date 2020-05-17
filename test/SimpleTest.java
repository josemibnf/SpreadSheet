import SpreadSheet.SpreadSheet;
import Exceptions.InvalidCell;

import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.Assert.assertTrue;

public class SimpleTest extends SpreadSheet {

    @BeforeEach
    public void setUpSheet() throws InvalidCell {
        put("c2", 42);
        put("a1", "c2");

    }

    @Test
    public void cell_has_value_if_it_has_value_c2__before() throws InvalidCell {
        assertTrue(get("c2").hasValue());
    }

    @Test
    public void cell_has_value_if_it_has_value_a1() throws InvalidCell {
        assertTrue(get("a1").hasValue());
    }

    @Test
    public void cell_has_value_if_it_has_value_c2() throws InvalidCell {
        assertTrue(get("c2").hasValue());
    }

    @AfterEach
    public void clearSheet() {
        clear();
    }

}