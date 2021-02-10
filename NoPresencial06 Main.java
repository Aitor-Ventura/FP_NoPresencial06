import es.ulpgc.eii.containers.bounded.ExtendedQueueOfInt;

/**
 * @author zenon
 * 
 */
public class Main {
    /**
     * Prueba ExtendedQueueOfInt.equals
     * @param q1 cola a comparar
     * @param name1 "nombre" de la cola a comparar
     * @param q2 cola con la que se va a comparar
     * @param name2 "nombre" de la cola con la que se va a comparar
     * @param expected resultado esperado
     */
    static void testEquals(ExtendedQueueOfInt q1, String name1,
            ExtendedQueueOfInt q2, String name2, boolean expected) {
        // Se informa del caso que se está probando
        System.out.println("probando: " + name1 + ".equals(" + name2 + ")");

        // Llamada al método a probar
        boolean result = q1.equals(q2);

        // Comprobación de los resultados
        if (result != expected) {
            System.out.print(">> Resultado erróneo, deberia ser: " + expected);
            System.out.println(" y es: " + result);
        } else {
            System.out.println(">> Resultado correcto: " + result);
        }
    }

    /**
     * Prueba ExtendedQueueOfInt.compareTo
     * @param q1 cola a comparar
     * @param name1 "nombre" de la cola a comparar
     * @param q2 cola con la que se va a comparar
     * @param name2 "nombre" de la cola con la que se va a comparar
     * @param expected resultado esperado
     */
    static void testCompareTo(ExtendedQueueOfInt q1, String name1,
            ExtendedQueueOfInt q2, String name2, int expected) {
        // Se informa del caso que se está probando
        System.out.println("probando: " + name1 + ".compareTo(" + name2 + ")");

        // Llamada al método a probar
        int result = q1.compareTo(q2);

        // Comprobación de los resultados
        if (result != expected) {
            System.out.print(">> Resultado erróneo, deberia ser: " + expected);
            System.out.println(" y es: " + result);
        } else {
            System.out.println(">> Resultado correcto: " + result);
        }
    }
    
    /**
     * Prueba ExtendedQueueOfInt.toString
     * @param q1 cola a tratar
     * @param name1 "nombre" de la cola a tratar
     * @param expected resultado esperado
     */
    static void testToString(ExtendedQueueOfInt q1, String name1, String expected) {
        // Se informa del caso que se está probando
        System.out.println("probando: " + name1 + ".toString()");

        // Llamada al método a probar
        String result = q1.toString();

        // Comprobación de los resultados
        if (!result.equals(expected)) {
            System.out.print(">> Resultado erróneo, deberia ser: \"" + expected + "\"");
            System.out.println(" y es: \"" + result + "\"");
        } else {
            System.out.println(">> Resultado correcto: \"" + result + "\"");
        }
    }    
    
    /**
     * Prueba ExtendedQueueOfInt.copy (suponiendo que toString funciona)
     * @param q1 cola a tratar
     * @param name1 "nombre" de la cola a tratar
     * @param expected resultado esperado
     */
    static void testCopy(ExtendedQueueOfInt q1, String name1, String expected) {
        // Se informa del caso que se está probando
        System.out.println("probando: " + name1 + ".copy()");

        // Llamada al método a probar
        ExtendedQueueOfInt result = q1.clone();

        // Comprobación de los resultados
        if (!result.toString().equals(expected)) {
            System.out.print(">> Resultado erróneo, deberia ser: \"" + expected + "\"");
            System.out.println(" y es: \"" + result + "\"");
        } else {
            System.out.println(">> Resultado correcto: \"" + result + "\"");
        }
        
        if (result == q1) {
            System.out.println(">> Resultado erróneo, la cola no ha sido copiada");
        }
    }  
    
    /**
     * Crea una cola con unos valores iniciales
     * 
     * @param name
     *            "nombre" de la nueva cola
     * @param bound
     *            capacidad de la nueva cola
     * @param value
     *            reperesentación de los valores a insertar en la cola
     * @return una cola rellena con los valores pasados en value
     */
    public static ExtendedQueueOfInt create(String name, int bound, String value) {

        System.out.print("Creando una cola, " + name + ", ");
        System.out.println("con los valores: " + value);

        String[] values = value.substring(1, value.length() - 1).split("-");
        ExtendedQueueOfInt q = new ExtendedQueueOfInt(bound);

        for (String v : values) {
            q.insert(Integer.parseInt(v));
        }

        return q;
    }

    /**
     * Prueba la clase ExtendedListOfInt;
     * 
     * @param args
     */
    public static void main(String[] args) {
        ExtendedQueueOfInt q1 = create("q1", 10, "<5-3-67-8<");
        ExtendedQueueOfInt q2 = create("q2", 10, "<5-3-67-8<");
        ExtendedQueueOfInt q3 = create("q3", 10, "<5-3-67<");

        testEquals(q1, "q1", q1, "q1", true);
        testEquals(q1, "q1", q2, "q2", true);
        testEquals(q1, "q1", q3, "q3", false);
        
        testCompareTo(q1, "q1", q1, "q1", 0);
        testCompareTo(q1, "q1", q2, "q2", 0);
        testCompareTo(q1, "q1", q3, "q3", -1); 
        testCompareTo(q3, "q3", q1, "q1", 1); 
     
        testCopy(q1, "q1", "<5-3-67-8<");
        testCopy(q2, "q2", "<5-3-67-8<");
        testCopy(q3, "q3", "<5-3-67<");
    }
}