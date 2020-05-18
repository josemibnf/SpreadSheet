package spreadsheet;

import static org.junit.Assert.assertTrue;
import static spreadsheet.SpreadSheet.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import spreadsheet.value.SomeValue;

public class SimpleTest {

    @Before
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
        assertTrue(val.getValue()==42);
    }
    

    @Test
    public void cell_has_value_if_it_has_value_a1() throws InvalidCell {
        assertTrue(get("a1").hasValue());
    }

    @Test
    public void cell_has_value_if_evaluate_work_a1() throws InvalidCell {
        SomeValue val = (SomeValue) get("a1");
        assertTrue(val.getValue()==42);
    }

    @After
    public void clearSheet() {
        clear();
    }

}