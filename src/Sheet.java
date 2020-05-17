import java.util.HashMap;
import java.util.Map;

public class Sheet {
    // Esta es la clase Reference ¿??

    private static int size;
    final static String alphabet = "abcdefghijklmnopqrstuvwxyz";
    private final Map<String, Cell> CellSheet = new HashMap<String, Cell>();

    public Sheet(int size) {
        this.size = size;
        for (int i = 0; i < size; i++) {
            for (int j = 1; j <= size; j++) {
                CellSheet.put(Sheet.getId(i, j), new Cell());
            }
        }
    }

    /**
     * Devuelve el Id correspondiente a la celda, (a1, c2 ...)
     *
     * @param row
     * @param column
     * @return id
     */
    private static String getId(int row, int column) {
        return alphabet.charAt(row) + Integer.toString(column);
    }

    /**
     * Devuelve la celda correspondiente a ese identificador.
     *
     * @param reference
     * @return
     * @throws ThisCellNotExist
     */
    public Cell getCell(String reference) throws ThisCellNotExist, NullPointerException {
        if (!isValidCell(reference)) {
            throw new ThisCellNotExist("La celda referenciada no existe.");
        }
        return CellSheet.get(reference); // Buscamos la celda con esa referencia.
    }

    /**
     * Comprueba si esa referencia entra en el rango de posibles celdas.
     *
     * @param reference
     * @return
     */
    private boolean isValidCell(String reference) {
        String[] cellId = reference.split("");
        Integer row = alphabet.indexOf(cellId[0]) + 1;
        Integer column = Integer.parseInt(cellId[1]);

        return row <= size && column <= size;

    }

    /**
     * Borra todas las Celdas.
     */
    public void clear() {
        CellSheet.clear();
    }

}