package servicio;

public class ServicioException extends Exception {
	
	// Faltan completar las excepciones

    public ServicioException() {
    }

    public ServicioException(String message) {
        super(message);
    }

    public ServicioException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServicioException(Throwable cause) {
        super(cause);
    }

    public ServicioException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
