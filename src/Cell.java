

public class Cell {
    private Expression formula;

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
    public MaybeValue evaluate() {
        return formula.evaluate();
    }

    /**
     * Modifica la expresion de la celda,
     * por lo que ahora apuntaremos a otra
     * expresion distinta.
     * @param exp
     */
    public void set(Expression exp){
        this.formula=exp;
    }

    /**
     * Devuelve la expresion actual de la celda.
     * @return
     */
    public Expression getFormula() {
        return this.formula;
    }
}
