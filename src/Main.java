import ejercicios.Ejercicio1_Stack.StackMenu;
import ejercicios.Ejercicio2_Queue.QueueMenu;
import ejercicios.Ejercicio3_Set.SetMenu;
import ejercicios.Ejercicio4_HashMap.HashMapMenu;
import ejercicios.Ejercicio5_TreeMap.TreeMapMenu;
import java.util.Scanner;

/**
 * Clase principal del proyecto de Biblioteca Digital.
 * <p>
 * Permite al usuario seleccionar entre los distintos ejercicios
 * que ilustran el uso de colecciones en Java:
 * Stack, Queue, Set, HashMap y TreeMap.
 * </p>
 */

public class Main {
    /** Constante que indica las opciones totales del menú. */
    private static final String OPCIONES_MENU = "5";

    /**
     * Método principal. Muestra un menú inicial con los cinco ejercicios
     * y delega la ejecución al menú correspondiente según la opción elegida.
     *
     * @param args argumentos de línea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        flujoPrincipal(entrada);
    }

    /**
     * Controla el flujo principal del programa, mostrando el menú
     * y gestionando la selección de opciones.
     *
     * @param entrada scanner para leer la opción introducida.
     */
    private static void flujoPrincipal (Scanner entrada) {
        String opcion;

        do {
            opcion= menuPrincipal(entrada);
            switch (opcion){
                case "1":
                    StackMenu.ejecutar();
                    break;
                case "2":
                    QueueMenu.ejecutar();
                    break;
                case "3":
                    SetMenu.ejecutar();
                    break;
                case "4":
                    HashMapMenu.ejecutar();
                    break;
                case "5":
                    TreeMapMenu.ejecutar();
                    break;
                case "6":
                    System.out.println("👋 ¡Gracias por usar la Biblioteca Digital!");
                    break;
                default:
                    System.out.println("⚠️ Opción no válida ⚠️");
                    break;
            }
        }while(!opcion.equals(OPCIONES_MENU));
    }

    /**
     * Muestra el menú principal de la Biblioteca Digital y devuelve
     * la opción seleccionada por el usuario.
     *
     * @param entrada scanner para leer la opción introducida.
     * @return opción seleccionada como cadena.
     */
    private static String menuPrincipal(Scanner entrada) {
        System.out.println("\n");
        System.out.println("════════════════════════════════════════════════════");
        System.out.println("          📚✨   BIBLIOTECA DIGITAL   ✨📚       ");
        System.out.println("════════════════════════════════════════════════════");
        System.out.println(" 1️⃣  📖  Ejercicio 1 – Historial de Libros (Stack)");
        System.out.println(" 2️⃣  👥  Ejercicio 2 – Cola de Usuarios (Queue)");
        System.out.println(" 3️⃣  📚  Ejercicio 3 – Catálogo de Libros (Set)");
        System.out.println(" 4️⃣  🔑  Ejercicio 4 – Gestión de Usuarios (HashMap)");
        System.out.println(" 5️⃣  🌳  Ejercicio 5 – Descargas de Libros (TreeMap)");
        System.out.println(" 6️⃣  🚪  SALIR");
        System.out.println("════════════════════════════════════════════════════");
        System.out.print("👉 Selecciona una opción: ");
        return entrada.nextLine();
    }
}
