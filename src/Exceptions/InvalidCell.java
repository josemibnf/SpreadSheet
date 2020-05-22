package Exceptions;

public class InvalidCell extends Exception {

    /**
     * Se lanza si la celda no existe.
     *
     */
    public InvalidCell() {
        super("Cell Out of Bounds");
    }

}