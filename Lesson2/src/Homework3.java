public class Homework3 {
    public static void main(String[] args) {
        int[] array = ConsoleReader.readArrayOfInteger();
        if (array != null)
            System.out.println("Average value of array: " + average(array));
        else
            System.out.println("Array is empty");
    }

    /**
     * Метод должен вернуть среднее значение из массива чисел
     * (необходимо сумму всех элеменов массива разделить на длину массива)
     * <p>
     * Example:
     * array = {1,2,3,4,5}
     * Метод должен return 3.0
     */
    public static double average(int[] array) {
        int sum = 0;
        for (int i : array) {
            sum += i;
        }
        return (double) sum / array.length;
    }
}
