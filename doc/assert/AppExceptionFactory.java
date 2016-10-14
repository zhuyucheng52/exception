public class AppExceptionFactory implements AbstractExceptionFactory {
    public AppException getException(String msg) {
        return new AppException(msg);
    }

    public AppException getException(String msg, Throwable throwable) {
        return new AppException(msg, throwable);
    }
}
