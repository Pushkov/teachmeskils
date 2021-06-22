public class Homework5 {
    public static void main(String[] args) {
        int first = ConsoleReader.readInteger("Enter first cathetus:");
        int second = ConsoleReader.readInteger("Enter second cathetus:");
        System.out.println("Hypotenuse: " + calculateHypotenuse(first, second));
    }

    /**
     * Используя теорему Пифагора, вычислите значение гипотенузы. Квадрат гипотенузы = сумме квадратов катетов
     * <p>
     * Example1:
     * 3
     * 4
     * return 5
     * <p>
     * Example2:
     * 12
     * 16
     * return 20
     */
    public static double calculateHypotenuse(int a, int b) {
        return Math.sqrt(a * a + b * b);
    }
}
