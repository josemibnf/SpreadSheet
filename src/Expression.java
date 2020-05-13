import java.util.Set;

public interface Expression {
    public Set<Cell> references;  // Posee el conjunto de celdas que posee
                                 // la expresion, directa o inderectamente,
                                // puede ser null.

    public default Set<Cell> getReferences() {  // No se muy bien que es lo de default.
        return null;
    }
}
