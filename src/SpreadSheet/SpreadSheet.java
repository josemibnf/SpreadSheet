package SpreadSheet;

import Exceptions.InvalidCell;
import Expression.Mult;
import Expression.Plus;
import Value.MaybeValue;
import Value.SomeValue;

public class SpreadSheet {

    // Con esta clase seguimos el patron Fachada.

    private static int SIZE = 5;
    private static final Sheet SHEET = new Sheet(SIZE);

    public static Expression plus(Expression expr1, Expression expr2) {
        // Crea i retorna una expressió corresponent a la
        // suma de les dues subexpressions
        return new Plus(expr1, expr2);

    }

    public static Expression plus(Expression expr1, String ref2) throws NullPointerException, InvalidCell {
        // Crea i retorna una expressió corresponent a la
        // suma de expr1 i de l’expressió que representa
        // una referència a la cel·la amb nom ref2
        return new Plus(expr1, new Reference(SHEET.getCell("ref2")));
    }

    public static Expression plus(int value1, Expression expr2) {
        return new Plus(new SomeValue(value1), expr2);

    }

    public static Expression plus(int value1, int value2) {
        return new Plus(new SomeValue(value1), new SomeValue(value2));
    }

    public static Expression plus(int value1, String ref2) throws NullPointerException, InvalidCell {
        return new Plus(new SomeValue(value1), new Reference(SHEET.getCell(ref2)));

    }

    public static Expression plus(String ref1, Expression expr2) throws NullPointerException, InvalidCell {
        return new Plus(new Reference(SHEET.getCell(ref1)), expr2);

    }

    public static Expression plus(String ref1, int value2) throws NullPointerException, InvalidCell {
        return new Plus(new Reference(SHEET.getCell(ref1)), new SomeValue(value2));
    }

    public static Expression plus(String ref1, String ref2) throws NullPointerException, InvalidCell {
        return new Plus(
                new Reference(SHEET.getCell(ref1)),
                new Reference(SHEET.getCell(ref2))
        );

    }

    public static Expression mult(Expression expr1, Expression expr2) {
        // Crea i retorna una expressió corresponent a la
        // multiplicacion de les dues subexpressions
        return new Mult(expr1, expr2);

    }

    public static Expression mult(Expression expr1, String ref2) throws NullPointerException, InvalidCell {
        // Crea i retorna una expressió corresponent a la
        // multiplicacion de expr1 i de l’expressió que representa
        // una referència a la cel·la amb nom ref2
        return new Mult(expr1, new Reference(SHEET.getCell("ref2")));
    }

    public static Expression mult(int value1, Expression expr2) {
        return new Mult(new SomeValue(value1), expr2);

    }

    public static Expression mult(int value1, int value2) {
        return new Mult(new SomeValue(value1), new SomeValue(value2));
    }

    public static Expression mult(int value1, String ref2) throws NullPointerException, InvalidCell {
        return new Mult(new SomeValue(value1), new Reference(SHEET.getCell(ref2)));

    }

    public static Expression mult(String ref1, Expression expr2) throws NullPointerException, InvalidCell {
        return new Mult(new Reference(SHEET.getCell(ref1)), expr2);

    }

    public static Expression mult(String ref1, int value2) throws NullPointerException, InvalidCell {
        return new Mult(new Reference(SHEET.getCell(ref1)), new SomeValue(value2));
    }

    public static Expression mult(String ref1, String ref2) throws InvalidCell {
        return new Mult(
                new Reference(SHEET.getCell(ref1)),
                new Reference(SHEET.getCell(ref2))
        );
    }


    public static MaybeValue get(String name) throws InvalidCell {
        // Retorna el valor que potser hi ha a la cel·la
        // amb nom name.
        // Si hi ha un valor, es retorna una instància de
        // SomeValue; si no hi ha, NoValue.
        return SHEET.getCell(name).evaluate();
    }

    public static void put(String name, Expression expr) throws InvalidCell {
        // Assigna a la cel·la amb nom name l’expressió
        // expr.
        // Això provocarà l’avaluació de la cel·la (la
        // qual cosa pot propagar la avaluació a d’altres
        // cel·les)
        SHEET.getCell(name).set(expr);
    }

    public static void put(String name, int value) throws InvalidCell {
        // Assigna a la cel·la amb nom name l’expressió
        // el valor value (Òbviament caldrà construir la
        // representació d’aquest int com Expression).
        // Això pot provocar avaluacions d’aquesta o
        // d’altres cel·les
        SHEET.getCell(name).set(new SomeValue(value));
    }

    public static void put(String name, String refName) throws NullPointerException, InvalidCell {
        // Assigna a la cel·la amb nom name la referència
        // a la cel·la amb nom refName (Òbviament caldrà
        // construir la representació d’aquesta
        // referència com Expression).
        // Això pot provocar avaluacions d’aquesta o
        // d’altres cel·les
        SHEET.getCell(name).set(new Reference(SHEET.getCell(refName)));
    }

    public static void clear() {
        SHEET.clear();
    }


}