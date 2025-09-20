package ejercicios.Ejercicio3_Set;

import datos.DatosPrueba;
import entidades.Libro;
import utilidades.UtilidadesTexto;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Clase que gestiona un catálogo de libros usando un {@link HashSet}.
 * <p>
 * Los títulos de los libros se almacenan de forma normalizada en mayúsculas
 * para evitar duplicados causados por diferencias en mayúsculas, minúsculas o espacios.
 * </p>
 * <p>Funcionalidades principales:</p>
 * <ul>
 *     <li>Inicializar el catálogo con los libros de {@link DatosPrueba}.</li>
 *     <li>Añadir nuevos títulos evitando duplicados.</li>
 *     <li>Buscar un libro en el catálogo de forma normalizada.</li>
 *     <li>Mostrar todos los libros guardados en mayúsculas.</li>
 * </ul>
 */

public class CatalogoLibros {
    /** Conjunto de títulos de libros */
    private final HashSet<String> catalogo;

    /**
     * Constructor de {@code CatalogoLibros}.
     * <p>
     * Inicializa el catálogo con los títulos de {@link DatosPrueba},
     * normalizándolos a mayúsculas para asegurar más uniformidad.
     * </p>
     */
    public CatalogoLibros() {
        this.catalogo = new HashSet<>();

        for (Libro libro : DatosPrueba.LIBROS) {
            catalogo.add(UtilidadesTexto.normalizarMayusculas(libro.getTitulo()));
        }
    }

    /**
     * Permite añadir un nuevo libro al catálogo.
     * <p>
     * El título introducido se normaliza a mayúsculas antes de insertarse
     * para mejorar la comparación del HashSet. Si ya existe, el HashSet no lo añade.
     * </p>
     * @param entrada Scanner usado para leer la entrada del usuario.
     */
    public void agregarLibro(Scanner entrada){
        System.out.println("\n ¿Qué nuevo libro deseas añadir al catálogo?");
        String tituloLibro = UtilidadesTexto.normalizarMayusculas(entrada.nextLine());

        if (catalogo.add(tituloLibro)){
            System.out.println("\n✔️El libro '"+tituloLibro+"' ha sido añadido al catálogo.✔️");
        } else {
            System.out.println("\n❌El libro '"+tituloLibro+"' ya está en el catálogo. No se puede añadir de nuevo.❌");
        }
    }

    /**
     * Busca un libro en el catálogo de forma normalizada.
     * <p>
     * El título introducido se transforma a mayúsculas antes de comprobar
     * si existe en el conjunto.
     * </p>
     *
     * @param entrada Scanner usado para leer la entrada del usuario.
     */
    public void buscarLibro(Scanner entrada){
        String tituloABuscar;

        if (!catalogo.isEmpty()) {
            System.out.println("\n¿Qué libro deseas buscar en el catálogo?");
            tituloABuscar = UtilidadesTexto.normalizarMayusculas(entrada.nextLine());

            if (catalogo.contains(tituloABuscar)) {
                System.out.println("\n✔️El libro '"+tituloABuscar+"' está en el catálogo.✔️");
            }else{
                System.out.println("\n❌El libro '"+tituloABuscar+"' no está en el catálogo.❌");
            }
        } else {
            System.out.println("\nℹ️ Todavía no hay libros en el catálogo. ℹ️");
        }
    }

    /**
     * Muestra todos los libros del catálogo en mayúsculas.
     * <p>
     * Si no hay libros, muestra un mensaje indicándolo.
     * </p>
     */
    public void mostrarCatalogo(){
        if (!catalogo.isEmpty()) {
            System.out.println("\nCatálogo completo de libros:");
            for (String libro : catalogo) {
                System.out.println("- "+libro);
            }
        } else {
            System.out.println("\nℹ️ Todavía no hay libros en el catálogo. ℹ️");
        }
    }
}
