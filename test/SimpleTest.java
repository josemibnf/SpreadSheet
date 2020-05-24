import Exceptions.InvalidCell;
import SpreadSheet.SpreadSheet;
import Expression.SomeValue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;;

public class SimpleTest extends SpreadSheet {

    @BeforeEach
    public void setUpSheet() throws InvalidCell {
        put("c2", 42);
        put("a1", "c2");
    }

    @Test
    public void cell_has_value_if_it_has_value_c2() throws InvalidCell {
        assertTrue(get("c2").hasValue());
    }

    @Test
    public void cell_has_value_if_evaluate_work_c2() throws InvalidCell {
        SomeValue val = (SomeValue) get("c2");
        assertEquals(42, val.getValue());
    }


    @Test
    public void cell_has_value_if_it_has_value_a1() throws InvalidCell {
        SomeValue val = (SomeValue) get("a1");
        if(val.getValue()==42){
            System.out.println("x");
        }
        assertTrue(get("a1").hasValue());
    }

    @Test
    public void cell_has_value_if_evaluate_work_a1() throws InvalidCell {
        SomeValue val = (SomeValue) get("a1");
        assertEquals(42, val.getValue());
    }

    @AfterEach
    public void clearSheet() {
        clear();
    }

}