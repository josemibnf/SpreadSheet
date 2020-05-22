package SpreadSheet;

import Exceptions.InvalidCell;
import Value.SomeValue;

import java.util.HashMap;
import java.util.Map;

public class Sheet {
    final static String alphabet = "abcdefghijklmnopqrstuvwxyz";
    private final int size;
    private Cell[][] CellSheet;

    public Sheet(int size){
        this.size = size;
        this.CellSheet = new Cell[size][size];
        initializeCells();
    }

    private void initializeCells() {
        int size = CellSheet.length;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                CellSheet[i][j] = new Cell();
            }
        }
    }

    /**
     * Devuelve el Id correspondiente a la celda, (a1, c2 ...)
     *
     */
    private static String getId(int row, int column) {
        return alphabet.charAt(row) + Integer.toString(column);
    }

    /**
     * Devuelve la celda correspondiente a ese identificador.
     *
     */
    public Cell getCell(String reference) throws InvalidCell, NullPointerException {
        String[] cellId = reference.split("");
        int row = alphabet.indexOf(cellId[0]) + 1;
        int column = Integer.parseInt(cellId[1]);
        if (!isValidCell(reference)) {
            throw new InvalidCell();
        }
        return CellSheet[row][column]; // Buscamos la celda con esa referencia.
    }

    /**
     * Comprueba si esa referencia entra en el rango de posibles celdas.
     *
     */
    private boolean isValidCell(String reference) {
        String[] cellId = reference.split("");
        int row = alphabet.indexOf(cellId[0]) + 1;
        int column = Integer.parseInt(cellId[1]);

        return row <= size && column <= size;

    }

    /**
     * Borra todas las Celdas.
     */
    public void clear() {
        initializeCells();
    }

    public void setCell(String name, Expression expr) throws InvalidCell {
        String[] cellId = name.split("");
        int row = alphabet.indexOf(cellId[0]) + 1;
        int column = Integer.parseInt(cellId[1]);
        if (!isValidCell(name)) {
            throw new InvalidCell();
        }
        CellSheet[row][column].insert(expr);
    }

    public void setCell(String name, int value) throws InvalidCell {
        setCell(name, new SomeValue(value));
    }
}