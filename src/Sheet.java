import java.util.HashMap;
import java.util.Map;

public class Sheet {
    // Esta es la clase Reference ¿??

    private final Map<String, Cell> CellSheet = new HashMap<String, Cell>();

	public Sheet(int SIZE) {
        for (int i=0;i<SIZE; i++){
            for (int j=1; j<=SIZE; j++){
                CellSheet.put( Sheet.getId(i, j), new Cell());
            }
        }
    }
    
    /**
     * Devuelve el Id correspondiente a la celda, (a1, c2 ...)
     * @param i
     * @param j
     * @return id
     */
    private static String getId(int i, int j) {
        String[] alfabeto = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
        return alfabeto[i].concat(Integer.toString(j));
    }

    /**
     * Devuelve la celda correspondiente a ese identificador.
     * 
     * @param ref
     * @return
     * @throws ThisCellNotExist
     */
    public Cell getCell(String ref) throws ThisCellNotExist, NullPointerException {
        if (dontHaveThisCell(ref)){
            throw new ThisCellNotExist("La celda referenciada no existe.");
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

    /**
     * Borra todas las Celdas.
     */
    public void clear(){
        CellSheet.clear();
    }

}