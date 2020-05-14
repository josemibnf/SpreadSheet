package java;

import java.util.HashMap;
import java.util.Map;

public class Sheet {
    // Esta es la clase Reference ¿??

    private Map<String, Cell> CellSheet = new HashMap<String, Cell>();

	public Sheet(int SIZE) {
        for (int i=0;i<SIZE; i++){
            for (int j=0; j<SIZE; j++){
                CellSheet.put( getId(i, j), new Cell());
            }
        }
    }
    
    /**
     * Devuelve el Id correspondiente a la celda, (a1, c2 ...)
     * @param i
     * @param j
     * @return
     */
    private String getId(int i, int j) {
        return null;
    }

    /**
     * Devuelve la celda correspondiente a ese identificador.
     * @param ref
     * @return
     */
    public Cell getCell(String ref) {
        if (dontHaveThisCell(ref)){
            throw new ThisCellNotExist("La celda referenciada no existe.")
        }
        return CellSheet.get(ref); // Buscamos la celda con esa referencia.
    }

    /**
     * Comprueba si esa referencia entra en el rango de posibles celdas.
     * @param ref
     * @return
     */
    private boolean dontHaveThisCell(String ref) {
        return false;
    }
}