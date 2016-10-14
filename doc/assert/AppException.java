public class AppException extends RuntimeException {
    public AppException(String msg) {
        super(msg);
    }

    public AppException(String msg, Throwable throwable) {
        super(msg, throwable);
    }
}
