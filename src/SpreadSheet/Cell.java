package SpreadSheet;

import Value.MaybeValue;
import Value.NoValue;

import java.util.HashSet;
import java.util.Set;

public class Cell {
    private Expression formula;

    private MaybeValue value;

    private Set<Reference> references;

    public Cell() {
        this.formula = NoValue.noValue();
        this.value = NoValue.noValue();
        this.references = new HashSet<>();
    }

    /**
     * Asigna a value el valor que posee la formula, si no lo sabemos aun será
     * java.main.NoValue.
     * <p>
     * En el PDF lo que hace es retornar el valor. ?¿?¿?
     *
     * @return
     */
    public void revaluate() {
        this.value = formula.evaluate();
    }

    public MaybeValue getValue() {
        return this.value;
    }

    /**
     * Modifica la expresion de la celda,
     * por lo que ahora apuntaremos a otra
     * expresion distinta.
     *
     * @param exp
     */
    public void set(Expression exp) {
        Set<Cell> previus_set;
        if (this.formula == NoValue.noValue()){
            previus_set = new HashSet<>();
            previus_set.add(this); // Primero se añade la propia celda, ya que es la primera
            // que debera de ejecutarse.
            this.formula=exp;
            this.formula.set_references(previus_set);
            this.notify_references(); // Todas las referencias que apuntan a la celda
            // cargan sus referencias en la nueva formula.
            this.formula.push_references(); // Se gargan las referencias añadidas a las
            // dependencias de la formula, si las tiene.
        }else{
            previus_set = this.formula.get_references();
            this.formula=exp;
            this.formula.set_references(previus_set);
            this.formula.push_references();
        }
    }

    /**
     * Devuelve la expresion actual de la celda.
     *
     * @return
     */
    public Expression getFormula() {
        return this.formula;
    }

    /**
     * Añade una referencia para el momento en el
     * que formula posea una formula !NoValue.
     *
     * Debe ser llamado solo por una referencia que apunte
     * a la celda cuando esta tenga formula NoValue.
     * @param reference
     */
    public void add_reference(Reference reference) {
        this.references.add(reference);
    }

    /**
     * Ejecutado en el momento en que añadimos una formula
     * distinta a NoValue,
     * notifica a todas las referencias de que ya pueden añadir
     * sus propias referencias.
     * Ademas resetea el Set.
     */
    private void notify_references(){
        for (Reference r : this.references){
            r.push_references();
        }
        this.references.clear();
    }

}
