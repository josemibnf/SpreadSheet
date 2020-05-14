package java;

public class Sheet {
    // Esta es la clase Reference ¿??

	public Sheet(int SIZE) {
        for (int i=0;i<SIZE; i++){
            for (int j=0; j<SIZE; j++){
                Reference(new Cell());
            }
        }
    }
    
    public static Cell getCell(String ref){
        return (Cell) null; // Buscamos la celda con esa referencia.
    }
}
