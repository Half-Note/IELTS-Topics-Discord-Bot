public class ArrayUtilities {
    public static boolean contains(long[] array, long key) {
        for (long i : array) {
            if (key == i) {
                return true;
            }
        }

        return false;
    }

    public static boolean contains(String[] array, String key) {
        for (String i : array) {
            if (key.equals(i)) {
                return true;
            }
        }

        return false;
    }

    public static boolean containsIgnoreCase(String[] array, String key) {
        for (String i : array) {
            if (key.equalsIgnoreCase(i)) {
                return true;
            }
        }

        return false;
    }
}
