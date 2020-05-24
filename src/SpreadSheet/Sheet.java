package SpreadSheet;

import Exceptions.InvalidCell;
import Expression.SomeValue;

public class Sheet {
    private final int SIZE;
    private Cell[][] CELLSHEET;
    final static String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

    public Sheet(int size){
        this.SIZE = size;
        this.CELLSHEET = new Cell[size][size];
        initializeCells();
    }

    private void initializeCells() {
        int size = CELLSHEET.length;
        for (int row = 0; row < size; row++) {
            for (int column = 0; column < size; column++) {
                CELLSHEET[row][column] = new Cell();
            }
        }
    }

    /**
     * Devuelve el numero de fila correspondiente a la celda, (a1, c2 ...)
     *
     */
    private static int getRow(String reference) {
        String[] cellId = reference.split("");
        return ALPHABET.indexOf(cellId[0]) + 1;
    }

    /**
     * Devuelve el numero de columna correspondiente a la celda, (a1, c2 ...)
     *
     */
    private static int getColumn(String reference) {
        String[] cellId = reference.split("");
        return Integer.parseInt(cellId[1]);
    }

    /**
     * Devuelve la celda correspondiente a ese identificador.
     *
     */
    public Cell getCell(String reference) throws InvalidCell, NullPointerException {
        if (!isValidCell(reference)) {
            throw new InvalidCell();
        }
        return CELLSHEET[getRow(reference)][getColumn(reference)]; // Buscamos la celda con esa referencia.
    }

    /**
     * Comprueba si esa referencia entra en el rango de posibles celdas.
     *
     */
    private boolean isValidCell(String reference) {
        return getRow(reference) <= SIZE && getColumn(reference) <= SIZE;
    }

    /**
     * Borra todas las celdas.
     */
    public void clear() {
        initializeCells();
    }

    public void setCell(String reference, Expression expr) throws InvalidCell {
        if (!isValidCell(reference)) {
            throw new InvalidCell();
        }
        CELLSHEET[getRow(reference)][getColumn(reference)].insert(expr);
    }

    public void setCell(String name, int value) throws InvalidCell {
        setCell(name, new SomeValue(value));
    }
}