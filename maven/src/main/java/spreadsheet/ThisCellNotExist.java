package spreadsheet;

public class ThisCellNotExist extends Exception{

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
    public ThisCellNotExist(String msg) {
        super(msg);
    }
    
}