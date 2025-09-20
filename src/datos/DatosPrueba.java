package datos;

import entidades.Libro;
import entidades.Usuario;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase de utilidad que centraliza los datos de prueba
 * (libros y usuarios) utilizados en los distintos ejercicios.
 *
 * <p>Contiene dos listas de ejemplos de prueba:
 * <ul>
 *     <li>{@link #LIBROS} → colección inicial de libros de ejemplo.</li>
 *     <li>{@link #USUARIOS} → colección inicial de usuarios de ejemplo.</li>
 * </ul>
 */

public class DatosPrueba {

    /** Constructor privado para evitar instanciación. */
    private DatosPrueba() {}

    /**
     * Lista de libros de prueba disponibles para los ejercicios.
     * <p>Es un {@link ArrayList} modificable inicializado con 10 libros
     * de distintos autores.</p>
     */
    public static ArrayList<Libro> LIBROS = new ArrayList<>(List.of(
            new Libro("El señor de los anillos","JRR Tolkien",1954),
            new Libro("22/11/63","Stephen King",2011),
            new Libro("El código da Vinci","Dan Brown",2003),
            new Libro("It","Stephen King",1986),
            new Libro("La sombra del viento","Carlos Ruiz Zafón",2001),
            new Libro("Cien años de soledad","Gabriel García Márquez",1967),
            new Libro("Don Quijote de la Mancha","Miguel de Cervantes",1605),
            new Libro("1984","George Orwell",1949),
            new Libro("Matar a un ruiseñor","Harper Lee",1960),
            new Libro("El gran Gatsby","F. Scott Fitzgerald",1925)
    ));

    /**
     * Lista de usuarios de prueba disponibles para los ejercicios.
     * <p>Es un {@link ArrayList} mutable inicializado con 10 nombres
     * comunes, simulando los usuarios que podrían interactuar con
     * la biblioteca.</p>
     */
    public static ArrayList<Usuario> USUARIOS = new ArrayList<>(List.of(
            new Usuario("Ana"),
            new Usuario("Luis"),
            new Usuario("María"),
            new Usuario("Carlos"),
            new Usuario("Marta"),
            new Usuario("Javier"),
            new Usuario("Sofía"),
            new Usuario("David"),
            new Usuario("Lucía"),
            new Usuario("Miguel")
    ));
}





