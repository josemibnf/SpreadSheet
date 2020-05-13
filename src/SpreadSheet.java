public class SpreadSheet {
    private static int SIZE = 5;
    private static final Sheet SHEET = new Sheet(SIZE);

    public static Expression plus(Expression expr1, Expression expr2) {
        // Crea i retorna una expressió corresponent a la
        // suma de les dues subexpressions
    }

    public static Expression plus(Expression expr1, String ref2) {
        // Crea i retorna una expressió corresponent a la
        // suma de expr1 i de l’expressió que representa
        // una referència a la cel·la amb nom ref2
    }

    public static Expression plus(int value1, Expression expr2) {

    }

    public static Expression plus(int value1, Expression expr2) {

    }

    public static Expression plus(int value1, int value2) {

    }

    public static Expression plus(int value1, String ref2) {

    }

    public static Expression plus(String ref1, Expression expr2) {

    }

    public static Expression plus(String ref1, int value2) {

    }

    public static Expression plus(String ref1, String ref2) {

    }

    // El mateix per a totes les combinacions de mult

    public static MaybeValue get(String name) {
        // Retorna el valor que potser hi ha a la cel·la
        // amb nom name.
        // Si hi ha un valor, es retorna una instància de
        // SomeValue; si no hi ha, NoValue.
    }

    public static void put(String name, Expression expr) {
        // Assigna a la cel·la amb nom name l’expressió
        // expr.
        // Això provocarà l’avaluació de la cel·la (la
        // qual cosa pot propagar la avaluació a d’altres
        // cel·les)
    }

    public static void put(String name, int value) {
        // Assigna a la cel·la amb nom name l’expressió
        // el valor value (Òbviament caldrà construir la
        // representació d’aquest int com Expression).
        // Això pot provocar avaluacions d’aquesta o
        // d’altres cel·les
    }

    public static void put(String name, String refName) {
        // Assigna a la cel·la amb nom name la referència
        // a la cel·la amb nom refName (Òbviament caldrà
        // construir la representació d’aquesta
        // referència com Expression).
        // Això pot provocar avaluacions d’aquesta o
        // d’altres cel·les
    }

    public static void clear() {
        // Esborra totes les cel·les del full de càlcul.
    }

}