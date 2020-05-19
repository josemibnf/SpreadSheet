package spreadsheet;

import java.util.HashSet;
import java.util.Set;

import spreadsheet.value.MaybeValue;
import spreadsheet.value.NoValue;

public class Cell {

    private Expression formula;

    private MaybeValue value;

    public Cell() {
        this.formula = NoValue.noValue();
    }

    /**
     * Asigna a value el valor que posee la formula, si no lo sabemos aun será
     * NoValue.
     * 
     * En el PDF lo que hace es retornar el valor. ?¿?¿?
     *
     * @return
     */
    public void revaluate() {
       this.value = formula.evaluate();
    }

    public MaybeValue evaluate() {
        return this.value;
    }

    /**
     * Modifica la expresion de la celda,
     * por lo que ahora apuntaremos a otra
     * expresion distinta.
     * @param exp
     */
    public void set(Expression exp){
        Set<Cell> previus_set;
        if (this.formula == NoValue.noValue()){
            previus_set = new HashSet<>();
            previus_set.add(this);
        }else{
            previus_set = this.formula.get_references();
        }
        this.formula=exp;
        this.formula.set_references(previus_set);
        this.formula.push_references();
    }

    /**
     * Devuelve la expresion actual de la celda.
     * @return
     */
    public Expression getFormula() {
        return this.formula;
    }
}