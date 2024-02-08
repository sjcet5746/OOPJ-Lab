public class MaximumFinder {

    public static <T extends Comparable<T>> T findMax(T[] array) {
        if (array == null || array.length == 0) {
            return null;
        }

        T max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i].compareTo(max) > 0) {
                max = array[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Integer[] intArray = {3, 7, 2, 9, 1};
        System.out.println("Maximum integer value: " + findMax(intArray));

        Double[] doubleArray = {3.5, 7.2, 2.8, 9.1, 1.3};
        System.out.println("Maximum double value: " + findMax(doubleArray));

        String[] stringArray = {"apple", "banana", "orange", "grape"};
        System.out.println("Maximum string value: " + findMax(stringArray));
    }
}
