package ejercicios.Ejercicio2_Queue;

import entidades.Libro;
import entidades.Usuario;
import utilidades.UtilidadesTexto;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Clase que gestiona la cola de usuarios en espera
 * para tomar en préstamo un libro popular.
 *
 * <p>Utiliza una {@link Queue} de tipo {@link String} para almacenar
 * los nombres de los usuarios.
 * De esta manera, el primer usuario que entra en la cola será
 * el primero en ser atendido.</p>
 *
 * <p>Funcionalidades:</p>
 * <ul>
 *     <li>Añadir un usuario a la cola (offer), evitando duplicados.</li>
 *     <li>Atender al primer usuario de la cola (poll).</li>
 *     <li>Mostrar todos los usuarios en la cola.</li>
 * </ul>
 */

public class GestionColaUsuarios {
    /** Cola de usuarios que esperan su turno para un libro popular. */
    private final Queue<String> cola;

    /** Constructor: inicializa la cola como una {@link LinkedList}. */
    public GestionColaUsuarios() {
       this.cola = new LinkedList<>();
    }

    /**
     * Permite seleccionar un usuario de la lista de usuarios disponibles
     * y añadirlo a la cola de espera del libro indicado.
     * <p>Si el usuario ya está en la cola, se muestra un mensaje
     * de error y no se le añade de nuevo.</p>
     *
     * @param libroPopular libro al que se asocia la cola de espera.
     * @param usuarios     lista de usuarios disponibles.
     * @param entrada      scanner para la lectura de la selección.
     */
    public void agregarUsuarioACola(Libro libroPopular, ArrayList<Usuario> usuarios, Scanner entrada) {
        //Elegir usuario
        System.out.println("\nSeleccione el usuario que desea añadir a la cola:");
        Integer numUsuario = getNumUsuario(usuarios, entrada);
        if (numUsuario == null) return;

        //Validar si el usuario ya está en la cola y normalizar nombre
        String nombreUsuarioCola = usuarios.get(numUsuario - 1).getNombre();
        String nombreUsuarioNormalizado = UtilidadesTexto.normalizarMinusculasAcentos(nombreUsuarioCola);

        if (cola.contains(nombreUsuarioNormalizado)) {
            System.out.println("\n❌El usuario "+ nombreUsuarioCola +" ya está en la cola. No se le puede añadir de nuevo.❌");
            return;
        }

        //Agregar usuario seleccionado a la cola del libro
        cola.offer(nombreUsuarioNormalizado);
        System.out.println("\n✔️El usuario "+ nombreUsuarioCola +" ha sido añadido a la cola para tomar en préstamo el libro '"+ libroPopular.getTitulo() +"'✔️");
    }

    /**
     * Muestra un listado numerado de usuarios disponibles y
     * pide al usuario que seleccione uno.
     *
     * @param usuarios lista de usuarios disponibles.
     * @param entrada  scanner para leer la selección.
     * @return número del usuario seleccionado (1..n), o {@code null} si la entrada es inválida.
     */
    public static Integer getNumUsuario(ArrayList<Usuario> usuarios, Scanner entrada) {
        int i=1;
        int numUsuario;
        String numeroUsuario;

        for (Usuario usuario : usuarios) {
            System.out.println(i+"- "+usuario.getNombre());
            i++;
        }
        System.out.print("\nSeleccione el número del usuario: ");
        numeroUsuario = entrada.nextLine();

        //Validar entrada
        try {
            numUsuario = Integer.parseInt(numeroUsuario);
        } catch (NumberFormatException e) {
            System.out.println("\n❌Entrada inválida. Debe ser un número. Operación cancelada.❌");
            return null;
        }

        if (numUsuario < 1 || numUsuario > usuarios.size()) {
            System.out.println("\n❌Número inválido. El número tiene que ser mayor que 0 y menor o igual que " + usuarios.size() + ". Operación cancelada.❌");
            return null;
        }
        return numUsuario;
    }

    /**
     * Atiende (elimina y muestra) al primer usuario en la cola
     * utilizando la operación {@code poll()}.
     *
     * @param libroPopular libro que está en préstamo.
     */
    public void atenderUsuario(Libro libroPopular) {
        String usuarioAtendido;

        if (!cola.isEmpty()) {
            usuarioAtendido = cola.poll();
            System.out.println("\n✅ Al usuario: " + usuarioAtendido + " se le ha prestado el libro "+libroPopular.getTitulo()+" . ✅");
        } else {
            System.out.println("\nℹ️ No hay usuarios en la cola. ℹ️");
        }
    }

    /**
     * Muestra todos los usuarios actualmente en la cola,
     * en el orden en que serán atendidos.
     */
    public void mostrarColaCompleta() {
        int numEnCola = 0;
        if (!cola.isEmpty()) {
            System.out.println("\nUsuarios en la cola:");
            for (String usuario : cola) {
                numEnCola++;
                System.out.println(numEnCola+ "- " + usuario);
            }
        } else {
            System.out.println("\nℹ️ No hay usuarios en la cola. ℹ️");
        }
    }
}
