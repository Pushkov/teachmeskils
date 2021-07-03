import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class InputUtils {

    public static int readIntFromConsole(String message, boolean onlyPositive) {
        Scanner scanner = new Scanner(System.in);
        int number;
        boolean isPositiveNumber = true;
        do {
            System.out.println(message);
            while (!scanner.hasNextInt()) {
                System.out.println("Введенное не является ЦЕЛЫМ числом.");
                scanner.next();
            }
            number = scanner.nextInt();
            if (onlyPositive) {
                isPositiveNumber = checkNumberIsPositive(number);
            } else {
                isPositiveNumber = false;
            }
        } while (isPositiveNumber);
        return number;
    }

    private static boolean checkNumberIsPositive(int number) {
        boolean isPositiveNumber = true;
        if (number > 0) {
            isPositiveNumber = false;
        } else {
            System.out.println("Введенное не является ПОЛОЖИТЕЛЬНЫМ целым числом.");
        }
        return isPositiveNumber;
    }


    public static int[] createArrayWithRandomElements(int size) {
        int[] array;
        if (size > 0) {
            Random random = new Random();
            array = new int[size];
            Arrays.setAll(array, x -> random.nextInt());
        } else {
            array = new int[0];
        }
        return array;
    }

    public static int[] createArrayWithRandomElements(int size, int randomBound) {

        int[] array;
        if (size > 0) {
            Random random = new Random();
            array = new int[size];
            Arrays.setAll(array, x -> random.nextInt(randomBound));
        } else {
            array = new int[0];
        }
        return array;
    }

    public static int[][] createSquareMatrix(int size) {
        int[][] array;
        if (size > 0) {
            Random random = new Random();
            array = new int[size][];
            for (int i = 0; i < array.length; i++) {
                array[i] = new int[size];
                Arrays.setAll(array[i], x -> random.nextInt());
            }
        } else {
            array = new int[0][];
        }
        return array;
    }

    public static int[][] createSquareMatrix(int size, int randomBound) {
        int[][] array;
        if (size > 0) {
            Random random = new Random();
            array = new int[size][];
            for (int i = 0; i < array.length; i++) {
                array[i] = new int[size];
                Arrays.setAll(array[i], x -> random.nextInt(randomBound));
            }
        } else {
            array = new int[0][];
        }
        return array;
    }

    public static void printTwoDimensionalMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }
}
