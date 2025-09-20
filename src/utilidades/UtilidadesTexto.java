package utilidades;

/**
 * Clase de utilidades para normalizar cadenas de texto.
 * <p>
 * Proporciona métodos estáticos para homogeneizar la forma de un texto
 * (pasar a minúsculas eliminando acentos, o convertir todo a mayúsculas).
 * </p>
 */

public class UtilidadesTexto {

    /**
     * Convierte un texto a minúsculas, elimina espacios al inicio y al final
     * y reemplaza las vocales acentuadas por sus equivalentes sin acento.
     * <p>
     * Este método es útil para comparaciones más precisas entre cadenas de texto.
     * </p>
     *
     * @param textoOriginal texto original a normalizar.
     * @return texto normalizado en minúsculas, sin acentos ni espacios sobrantes.
     */
    public static String normalizarMinusculasAcentos(String textoOriginal) {
        if (textoOriginal == null) return "";

        String textoNormalizado = textoOriginal.trim().toLowerCase();

        // Quitar acentos de las vocales
        textoNormalizado =  textoNormalizado.replaceAll("[áàäâ]", "a")
                                            .replaceAll("[éèëê]", "e")
                                            .replaceAll("[íìïî]", "i")
                                            .replaceAll("[óòöô]", "o")
                                            .replaceAll("[úùüû]", "u");
        return textoNormalizado;
    }

    /**
     * Convierte un texto a mayúsculas y elimina espacios
     * al inicio y al final.
     * <p>
     * Este método es útil cuando se quiere almacenar, comparar
     * o mostrar todos los textos de forma uniforme.
     * </p>
     *
     * @param textoOriginal texto original a normalizar (puede ser {@code null}).
     * @return texto normalizado en mayúsculas, sin espacios sobrantes.
     */
    public static String normalizarMayusculas(String textoOriginal) {
        if (textoOriginal == null) return "";
        return textoOriginal.trim().toUpperCase();
    }
}
