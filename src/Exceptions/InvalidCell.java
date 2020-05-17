package Exceptions;

public class InvalidCell extends Exception {

    private static final long serialVersionUID = 1L;

    /**
     * Se lanza si la celda no existe.
     *
     * @return
     */
    public InvalidCell() {
        super("Cell Out of Bounds");
    }

}