public class DefaultUtils {
    public static <T> T nullToDefault(final T value, final T dft) {
        if (null == value) {
            return dft;
        }

        return value;
    }
}
