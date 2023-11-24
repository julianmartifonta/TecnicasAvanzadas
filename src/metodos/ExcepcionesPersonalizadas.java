package metodos;

public class ExcepcionesPersonalizadas {
    public static class ClaveDuplicadaException extends Exception {
        public ClaveDuplicadaException() {
            super("Clave duplicada encontrada.");
        }
    }

    public static class ConexionException extends Exception {
        public ConexionException(String string) {
            super("Error de conexión a la base de datos.");
        }
    }

    public static class DatosInvalidosException extends Exception {
        public DatosInvalidosException() {
            super("Los datos proporcionados son inválidos.");
        }
    }
}