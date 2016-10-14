public interface AbstractExceptionFactory {
    RuntimeException getException(String msg);

    RuntimeException getException(String msg, Throwable throwable);
}
