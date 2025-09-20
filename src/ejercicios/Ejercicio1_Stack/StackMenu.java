package ejercicios.Ejercicio1_Stack;

import datos.DatosPrueba;
import java.util.Scanner;

/**
 * Clase principal del Ejercicio 1 (Stack).
 * Contiene el menú y el flujo de interacción con el usuario
 * para gestionar la consulta de libros usando una pila (Stack).
 * * <p>Funcionalidades:</p>
 * <ul>
 *     <li>Consultar un libro de la biblioteca y añadirlo al historial.</li>
 *     <li>Mostrar el último libro consultado.</li>
 *     <li>Retroceder en el historial (ir hacia atrás en la pila).</li>
 *     <li>Mostrar el historial completo de libros consultados.</li>
 *     <li>Pregunta de teoría sobre Stack.</li>
 * </ul>
 * <p>Esta clase actúa como interfaz de usuario por consola
 * y utiliza {@link HistorialLibros} para la lógica.</p>
 */

public class StackMenu {
    /** Constante que indica las opciones totales del menú. */
    private static final String OPCIONES_MENU = "6";

    /**
     * Método público de entrada al ejercicio.
     * Inicializa los objetos necesarios (Scanner, HistorialLibros)
     * y lanza el flujo principal del programa.
     */
    public static void ejecutar(){
        //Variables
        Scanner entrada = new Scanner(System.in);
        HistorialLibros historial = new HistorialLibros();

        flujoE1Stack(historial, entrada);
    }

    /**
     * Flujo principal del ejercicio Stack.
     * Presenta un menú al usuario y gestiona las opciones seleccionadas.
     *
     * @param historial Historial de libros consultados (pila de libros).
     * @param entrada   Scanner para la lectura de opciones por consola.
     */
    private static void flujoE1Stack (HistorialLibros historial, Scanner entrada) {
        String opcion;

        do {
            opcion= menuStack(entrada); //Mostrar menú y leer opción
            switch (opcion){
                case "1":
                    historial.consultarLibro(DatosPrueba.LIBROS, entrada);
                    break;
                case "2":
                    historial.mostrarUltimoConsultado();
                    break;
                case "3":
                    historial.retrocederHistorial();
                    break;
                case "4":
                    historial.mostrarHistorialCompleto();
                    break;
                case "5":
                    System.out.println(" ");
                    System.out.println("⬇️Respuesta⬇️");
                    System.out.println("Un Stack representa una estructura de acceso LIFO (Last In, First Out). Es decir que el último elemento en entrar (push) es el primero en salir (pop).");
                    break;
                case "6":
                    System.out.println("Volviendo al menú principal... \uD83D\uDD1A");
                    break;
                default:
                    System.out.println("⚠️ Opción no válida ⚠️");
                    break;
            }
        }while(!opcion.equals(OPCIONES_MENU));
    }

    /**
     * Muestra el menú de opciones por consola y devuelve
     * la opción seleccionada por el usuario.
     *
     * @param entrada Scanner para la lectura de la opción.
     * @return String con la opción elegida por el usuario.
     */
    private static String menuStack(Scanner entrada) {
        System.out.println("\n📖 ===== HISTORIAL DE LIBROS (STACK) ===== 📖");
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
        System.out.println("1. 📚 Consultar libro.");
        System.out.println("2. 👀 Mostrar último libro consultado.");
        System.out.println("3. 🔙 Retroceder en el historial.");
        System.out.println("4. 📚 Mostrar historial completo.");
        System.out.println("5. 🤔 Pregunta: ¿Qué estructura de acceso representa un Stack (LIFO o FIFO)?");
        System.out.println("6. SALIR. 🔚");

        System.out.print("Introduce una opción: ");
        return entrada.nextLine();
    }
}