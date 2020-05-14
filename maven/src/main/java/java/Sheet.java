package java;

import java.util.HashMap;
import java.util.Map;

public class Sheet {
    // Esta es la clase Reference ¿??

    private Map<String, Cell> CellSheet = new HashMap<String, Cell>();

	public Sheet(int SIZE) {
        for (int i=0;i<SIZE; i++){
            for (int j=0; j<SIZE; j++){
                CellSheet.put(, new Cell());
            }
        }
    }
    
    public Cell getCell(String ref){
        if (dontHaveThisCell(ref)){
            throw ThisCellNotExist;
        }
        return CellSheet.get(ref); // Buscamos la celda con esa referencia.
    }

    private boolean dontHaveThisCell(String ref) {
        return false;
    }
}
