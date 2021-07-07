public class Homework2 {
    public static void main(String[] args) {
        int first = ConsoleReader.readInteger("Enter first number:");
        int second = ConsoleReader.readInteger("Enter second number:");
        System.out.println("Max: " + max(first, second));
    }

    /**
     * Метод должен вернуть максимальное значение из двух чисел
     *
     * <p>
     * Example1:
     * a = 4,
     * b = 5
     * <p>
     * Метод должен вернуть 5
     * Example2:
     * a = 10,
     * b = 10
     * <p>
     * Метод должен вернуть 10
     */
    public static int max(int a, int b) {
        return Math.max(a, b);
    }

}
