import static src.spreadsheet.*;
//mas imports

import java.beans.Transient;

public class SpreadSheetTest{

    @BeforeEach
    public void setUpSheet() {
        put("a3", mult("a1", "a2"));
    }    

    @BeforeEach
    public void cell_has_no_value_if_depends_on_empty_cells() {
        assertFalse( get("a3").hasValue());
    }

    @Test
    public void recalculation_works() {
        put("a1", 42);
        put("a2", 20);
        assertEquals(new SomeValue(840), get("a3")); 
    }

    @AfterEach
    public void clearSheet() {
        clear();
    }

}