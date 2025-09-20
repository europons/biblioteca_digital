package ejercicios.Ejercicio1_Stack;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;
import entidades.Libro;

/**
 * Clase que implementa un historial de libros consultados
 * utilizando una colección {@link Stack}.
 *
 * <p>Cada vez que el usuario consulta un libro, este se añade
 * a la pila. La clase permite:</p>
 * <ul>
 *     <li>Consultar un libro de una lista y añadirlo al historial.</li>
 *     <li>Mostrar el último libro consultado (peek).</li>
 *     <li>Retroceder en el historial (pop).</li>
 *     <li>Mostrar todo el historial completo.</li>
 * </ul>
 */

public class HistorialLibros {

    /** Pila que almacena el historial de libros consultados. */
    private final Stack<Libro> historial;

    /** Constructor: inicializa la pila vacía. */
    public HistorialLibros() {
        this.historial = new Stack<>();
    }

    /**
     * Permite al usuario seleccionar un libro de la lista de libros disponibles,
     * mostrar su información y añadirlo al historial.
     *
     * @param libros  lista de libros disponibles (biblioteca).
     * @param entrada scanner para leer la entrada del usuario.
     */
    public void consultarLibro(ArrayList<Libro> libros, Scanner entrada) {
        //Elegir nombreLibro de la biblioteca
        System.out.println("\nLibros disponibles en la biblioteca:");
        Integer numLibro = numeroLibro(libros, entrada);
        if (numLibro == null) return;

        //Mostrar información del libro seleccionado y agregar al historial
        Libro libro = libros.get(numLibro - 1);
        agregarLibroAlHistorial(libro);
        System.out.println("\n✔️LIBRO LEÍDO:");
        libro.mostrarInfoLibro();

    }

    /**
     * Muestra un listado numerado de los libros disponibles
     * y pide al usuario que seleccione uno.
     *
     * @param biblioteca lista de libros de la biblioteca.
     * @param entrada    scanner para leer la selección del usuario.
     * @return número del libro seleccionado (1..n), o null si la entrada es inválida.
     */
    public static Integer numeroLibro(ArrayList<Libro> biblioteca, Scanner entrada) {
        //Variables
        int i=1;
        int numLibro;
        String numeroLibro;

        //Mostrar libros disponibles
        for (Libro libro : biblioteca) {
            System.out.println(i+"- "+libro.getTitulo());
            i++;
        }
        System.out.print("Seleccione el número del libro: ");
        numeroLibro = entrada.nextLine();

        //Validar entrada
        try {
            numLibro = Integer.parseInt(numeroLibro);
        } catch (NumberFormatException e) {
            System.out.println("\n❌Entrada inválida. Debe ser un número. Operación cancelada.❌");
            return null;
        }

        if (numLibro < 1 || numLibro > biblioteca.size()) {
            System.out.println("\n❌Número inválido. El número tiene que ser mayor que 0 y menor o igual que " + biblioteca.size() + ". Operación cancelada.❌");
            return null;
        }
        return numLibro;
    }

    /** Añade un libro al historial (push). */
    private void agregarLibroAlHistorial(Libro libro) {
        historial.push(libro);
    }


    /**
     * Muestra el último libro consultado sin retirarlo del historial (peek).
     */
    public void mostrarUltimoConsultado() {
        if (!historial.isEmpty()) {
            System.out.println("\nÚltimo libro consultado: " + historial.peek().getTitulo());
        } else {
            System.out.println("\nℹ️ No se han consultado libros aún. ℹ️");
        }
    }

    /**
     * Retrocede en el historial eliminando y mostrando
     * el último libro consultado (pop).
     */
    public void retrocederHistorial(){
        if (!historial.isEmpty()) {
            System.out.println("\nEl libro consultado anteriormente es: " + historial.pop().getTitulo());
        } else {
            System.out.println("\nℹ️ No quedan libros en el historial. ℹ️");
        }
    }

    /**
     * Muestra todos los libros que se han consultado hasta ahora.
     */
    public void mostrarHistorialCompleto() {
        if (!historial.isEmpty()) {
            System.out.println("\nHistorial completo de libros consultados:");
            for (Libro libro : historial) {
                System.out.println(libro.getTitulo());
            }
        } else {
            System.out.println("\nℹ️ No se han consultado libros aún. ℹ️");
        }
    }
}
