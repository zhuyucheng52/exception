public class AssertUtils {
    private static AbstractExceptionFactory exceptionFactory = new AppExceptionFactory();

    public static void setExceptionFactory(AbstractExceptionFactory exceptionFactory) {
        AssertUtils.exceptionFactory = exceptionFactory;
    }

    public static void assertTrue(boolean result, String msg) {
        if (!result) {
            throw exceptionFactory.getException(msg);
        }
    }

    public static void assertFalse(boolean result, String msg) {
        if (result) {
            throw exceptionFactory.getException(msg);
        }
    }

    static <T> boolean equals(T obj1, T obj2) {
        if (obj1 == obj2
                || (null != obj1 && obj1.equals(obj2))) {
            return true;
        }
        return false;
    }

    public static <T> void assertEquals(T obj1, T obj2, String msg) {
        if (!equals(obj1, obj2)) {
            throw exceptionFactory.getException(msg);
        }
    }

    public static <T> void assertNotEquals(T obj1, T obj2, String msg) {
        if (equals(obj1, obj2)) {
            throw exceptionFactory.getException(msg);
        }
    }

    public static <T> void assertNull(T obj, String msg) {
        if (null != obj) {
            throw exceptionFactory.getException(msg);
        }
    }

    public static <T> void assertNotNull(T obj, String msg) {
        if (null == obj) {
            throw exceptionFactory.getException(msg);
        }
    }

    public static void assertThat(Matcher matcher, String msg) {
        if (!matcher.matches()) {
            throw exceptionFactory.getException(msg);
        }
    }

}
