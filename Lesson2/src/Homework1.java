public class Homework1 {
    public static void main(String[] args) {
        int first = ConsoleReader.readInteger("Enter first number:");
        int second = ConsoleReader.readInteger("Enter second number:");
        System.out.println("Result: " + sum(first, second));
    }

    /**
     * 1. Метод должен вернуть сумму двух чисел a и b
     * 2. Дополнительно: сделать проверку если сумма a и b больше чем максимальное значение int то вернуть -1
     **/
    public static int sum(int a, int b) {
        long result = (long) a + (long) b;
        return (int) (result > Integer.MAX_VALUE ? -1 : result);
    }
}
