package spreadsheet;

public class InvalidCell extends Exception{

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * 
     * Se lanza si la celda no existe.
     * 
     * @return
     *
     */
    public InvalidCell() {
        super("La celda no se encuentra en el tablero.");
    }
    
}