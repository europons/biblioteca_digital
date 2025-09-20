package ejercicios.Ejercicio5_TreeMap;

import ejercicios.Ejercicio1_Stack.HistorialLibros;
import entidades.Libro;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Gestiona un registro de descargas por libro utilizando un {@link TreeMap}.
 * <p>
 * El {@code TreeMap} mantiene las entradas ordenadas por clave (título del libro)
 * según el orden natural alfabético. Permite:
 * </p>
 * <ul>
 *   <li>Agregar (o actualizar) el número total de descargas de un libro.</li>
 *   <li>Mostrar todos los libros con sus descargas en orden A→Z.</li>
 *   <li>Consultar el primer y el último libro según el orden alfabético de claves.</li>
 * </ul>
 */

public class GestionDescargas {
    /** Mapa ordenado: clave = título del libro; valor = descargas totales. */
    private final TreeMap <String, Integer> descargas;

    /** Crea la estructura de descargas vacía. */
    public GestionDescargas() {
        this.descargas = new TreeMap<>();
    }

    /**
     * Pide al usuario un libro de la biblioteca y un número de descargas (entero ≥ 0),
     * y guarda/actualiza esa información en el {@link TreeMap}.
     *
     * @param biblioteca lista de libros disponibles para seleccionar.
     * @param entrada    scanner compartido para lectura por consola.
     */
    public void agregarLibro(ArrayList<Libro> biblioteca, Scanner entrada) {
        // Variables
        Libro libro;
        String titulo;
        int vecesDescargado;

        System.out.println("\nLibros disponibles en la biblioteca:");
        Integer numLibro = HistorialLibros.numeroLibro(biblioteca, entrada); // mejor llamar explícito
        if (numLibro == null) return;

        libro = biblioteca.get(numLibro - 1);
        titulo = libro.getTitulo();

        // Pedir descargas hasta que el usuario introduzca un número válido
        do {
            System.out.print("\nAñade las descargas totales del libro '" + titulo + "': ");
            try {
                vecesDescargado = entrada.nextInt();
                if (vecesDescargado < 0) {
                    System.out.println("\n❌ Número inválido. Debe ser mayor o igual que 0. ❌");
                }
            } catch (Exception e) {
                System.out.println("\n❌ Entrada inválida. Debe ser un número entero. ❌");
                entrada.nextLine();
                vecesDescargado = -1;
            }
            entrada.nextLine();
        } while (vecesDescargado < 0);

        descargas.put(titulo, vecesDescargado);
        System.out.println("✔️ Libro '" + titulo + "' añadido con " + vecesDescargado + " descargas.");
    }

    /**
     * Muestra todos los libros presentes en el mapa de descargas, en orden alfabético.
     * Si no hay datos, informa y retorna.
     */
    public void mostrarLibrosDescargados() {
        if (noHayDescargas()) return;

        System.out.println("\n📚Libros descargados📚");
        for (String titulo : descargas.keySet()) {
            System.out.println("- '"+titulo+"' con "+descargas.get(titulo)+" descargas.");
        }
    }

    /**
     * Muestra la primera y la última entrada del {@link TreeMap} según el orden natural de las claves.
     * Si no hay datos, informa y sale.
     */
    public void consultaPrimerUltimoLibro (){
        if (noHayDescargas()) return;

        var primero = descargas.firstEntry();
        var ultimo = descargas.lastEntry();

        System.out.println("\n📖 El primer libro de la colección es: '"
                + primero.getKey() + "' con " + primero.getValue() + " descargas.");
        System.out.println("📖 El último libro de la colección es: '"
                + ultimo.getKey() + "' con " + ultimo.getValue() + " descargas.");

    }

    /**
     * Indica si no hay registros de descargas e imprime un mensaje informativo.
     *
     * @return {@code true} si no hay descargas; {@code false} en caso contrario.
     */
    private boolean noHayDescargas() {
        if (descargas.isEmpty()) {
            System.out.println("\n❌No hay libros descargados.❌");
            return true;
        }
        return false;
    }
}
