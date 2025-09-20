package ejercicios.Ejercicio2_Queue;

import datos.DatosPrueba;
import entidades.Libro;

import java.util.Random;
import java.util.Scanner;

/**
 * Clase principal del Ejercicio 2 (Queue).
 * Contiene el menú y el flujo de interacción con el usuario
 * para simular una cola de espera de un libro popular.
 * <p>Funcionalidades del programa:</p>
 * <ul>
 *     <li>Añadir usuarios a la cola (offer).</li>
 *     <li>Atender al primer usuario de la cola (poll).</li>
 *     <li>Mostrar la cola completa.</li>
 *     <li>Pregunta de teoría sobre Queue.</li>
 * </ul>
 * <p>La clase actúa como interfaz de usuario por consola
 * y delega la lógica de la cola en la clase {@link GestionColaUsuarios}.</p>
 */

public class QueueMenu {
    /** Constante que indica las opciones totales del menú. */
    private static final String OPCIONES_MENU = "5";

    /**
     * Método público que inicializa el ejercicio.
     * <p>Selecciona un libro aleatorio de {@link DatosPrueba#LIBROS}
     * como el "libro popular", instancia la cola de usuarios y
     * lanza el flujo principal.</p>
     */
    public static void ejecutar(){
        //Variables
        Scanner entrada = new Scanner(System.in);
        GestionColaUsuarios cola = new GestionColaUsuarios();
        Libro libroPopular;

        //Libro más popular (un libro al azar de los datos de prueba)
        Random random = new Random();
        int libroAlAzar = random.nextInt(DatosPrueba.LIBROS.size());
        libroPopular = DatosPrueba.LIBROS.get(libroAlAzar);

        flujoE2Queue(cola ,libroPopular, entrada);
    }


    /**
     * Flujo principal del ejercicio Queue.
     * <p>Muestra el menú y gestiona las opciones seleccionadas
     * por el usuario hasta que se elige salir.</p>
     *
     * @param cola         la cola de usuarios gestionada en este ejercicio.
     * @param libroPopular libro al que los usuarios se ponen en cola.
     * @param entrada      scanner para la lectura de opciones por consola.
     */
    private static void flujoE2Queue(GestionColaUsuarios cola, Libro libroPopular, Scanner entrada) {
        String opcion;

        do {
            opcion= menuQueue(entrada);
            switch (opcion){
                case "1":
                    cola.agregarUsuarioACola(libroPopular, DatosPrueba.USUARIOS , entrada);
                    break;
                case "2":
                    cola.atenderUsuario(libroPopular);
                    break;
                case "3":
                    cola.mostrarColaCompleta();
                    break;
                case "4":
                    System.out.println(" ");
                    System.out.println("⬇️Respuesta⬇️");
                    System.out.println("Un Queue representa una estructura de acceso FIFO (First In, First Out). Es decir que el primer elemento en entrar (offer) es el primero en salir (poll).");
                    break;
                case "5":
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
     * @param entrada scanner para la lectura de la opción.
     * @return String con la opción elegida por el usuario.
     */
    private static String menuQueue(Scanner entrada) {
        System.out.println("\n📚👥 ===== COLA DE ESPERA (QUEUE) ===== 👥📚");
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
        System.out.println("1. ➕ Añadir usuario a la cola.");
        System.out.println("2. 📖➡️ Prestar libro al siguiente usuario.");
        System.out.println("3. 📋 Mostrar cola completa.");
        System.out.println("4. 🤔 Pregunta: ¿Qué estructura de acceso representa una Queue (LIFO o FIFO)?");
        System.out.println("5. SALIR. 🔚");
        System.out.print("Introduce una opción: ");
        return entrada.nextLine();
    }
}
