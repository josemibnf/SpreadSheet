package spreadsheet;

public class ThisCellNotExist extends Exception{

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