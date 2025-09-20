package entidades;

/**
 * Representa un libro dentro de la biblioteca.
 * <p>
 * Cada libro tiene un título, un autor y un año de publicación.
 * </p>
 * <p>
 * La igualdad entre libros se define únicamente por el título
 * (ver {@link #equals(Object)} y {@link #hashCode()}).
 * </p>
 */

public class Libro {
    //ATRIBUTOS
    private String titulo;
    private String autor;
    private int anyoPublicacion;

    //CONSTRUCTORES

    /**
     * Crea un libro con todos sus atributos.
     *
     * @param titulo título del libro.
     * @param autor autor del libro.
     * @param anyoPublicacion año de publicación del libro.
     */
    public Libro(String titulo, String autor, int anyoPublicacion) {
        this.titulo = titulo;
        this.autor = autor;
        this.anyoPublicacion = anyoPublicacion;
    }

    //GETTERS Y SETTERS
    public String getTitulo() {return titulo;}
    public String getAutor() {return autor;}
    public int getAnyoPublicacion() {return anyoPublicacion;}
    public void setTitulo(String titulo) {this.titulo = titulo;}
    public void setAutor(String autor) {this.autor = autor;}
    public void setAnyoPublicacion(int anyoPublicacion) {this.anyoPublicacion = anyoPublicacion;}

    //MÉTODOS

    /**
     * Muestra por consola la información completa del libro.
     */
    public void mostrarInfoLibro() {
        System.out.println("TÍTULO: " + getTitulo());
        System.out.println("AUTOR: " + getAutor());
        System.out.println("AÑO DE PUBLICACIÓN: " + getAnyoPublicacion());
    }

    //EQUALS Y HASHCODE

    /**
     * Dos libros se consideran iguales si tienen el mismo título.
     *
     * @param obj objeto con el que se compara.
     * @return {@code true} si el otro objeto es un libro con el mismo título.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Libro libro = (Libro) obj;
        return titulo.equals(libro.titulo);
    }

    /**
     * Genera un código hash consistente con {@link #equals(Object)},
     * basado únicamente en el título del libro.
     *
     * @return código hash del título.
     */
    @Override
    public int hashCode() {
        return titulo.hashCode();
    }
}
