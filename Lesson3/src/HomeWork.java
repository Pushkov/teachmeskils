import java.io.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class HomeWork {

    public static void main(String[] args) {
//        printArray(); //
/*
        System.out.println(operation(1));
        System.out.println(operation(0));
        System.out.println(operation(-1));
*/
//        System.out.println(calculateCountOfOddElementsInMatrix(new int[]{1, 2, 3, 4, 5, 6}));
//        calculateSumOfDiagonalElements();
/*
        countDevs(11);
        countDevs(31);
        countDevs(42);
        countDevs(104);
        countDevs(105);
        countDevs(106);
        countDevs(107);
        countDevs(108);
        countDevs(109);
        countDevs(100);
*/

/*
        foobar(1);
        foobar(3);
        foobar(4);
        foobar(6);
        foobar(10);
        foobar(11);
        foobar(15);
*/
//        printMatrix();
//        printPrimeNumbers();
    }

    /**
     * Необходимо прочитать с консоли значение числа типа int,
     * далее создать одноменрый массив типа int размера прочитаного с консоли
     * далее заполнить массив случайными значениями
     * далее вывести массив на консоль
     */
    private static void printArray() {
        String stringValue = readFromConsole("Enter integer number:");
        int arrayDimension = convertToInteger(stringValue);
        int[] array = createArrayWithRandomFilling(arrayDimension);
        System.out.println(Arrays.toString(array));
    }

    private static String readFromConsole(String message) {
        Console console = System.console();
        System.out.print(message);
        return console.readLine();
    }

    private static int convertToInteger(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            System.out.println("Check entered data.");
        }
        return 0;
    }

    private static int[] createArrayWithRandomFilling(int dimension) {
        int[] array = new int[dimension];
        for (int i = 0; i < array.length; i++) {
            array[i] = new Random().nextInt(100);
        }
        return array;
    }

    /**
     * Метод должен выполнять некоторую операцию с int "number" в зависимости от некоторых условий:
     * - if number положительное число, то необходимо number увеличить на 1
     * - if number отрицательное - уменьшить на 2
     * - if number равно 0 , то замените значение number на 10
     * вернуть number после выполнения операций
     */
    public static int operation(int number) {
        if (number > 0) {
            return number += 1;
        }
        if (number == 0) {
            return 10;
        }
        return number -= 2;
    }

    /**
     * На вход приходит массив целых чисел типа int
     * Необходимо найти количество нечетных элементов в массиве и вернуть значение в метод main,
     * в котором это значение распечатается на консоль.
     */
    public static int calculateCountOfOddElementsInMatrix(int[] ints) {
        return (int) Arrays.stream(ints)
                .filter(x -> x % 2 != 0)
                .count();
    }

    /**
     * На вход приходит число.
     * Вывести в консоль фразу из разряда "_COUNT_ программистов",
     * заменить _COUNT_ на число которое пришло на вход в метод и заменить окончание в слове "программистов" на
     * уместное с точки зрения русского языка.
     * Пример: 1 программист, 42 программиста, 50 программистов
     *
     * @param count - количество программистов
     */
    public static void countDevs(int count) {
        System.out.println(count + " програмист" + getEnding(count));
    }

    private static String getEnding(int count) {
        switch (count) {
            case 11:
            case 12:
            case 13:
            case 14:
                return "ов";
        }
        switch (count % 10) {
            case 2:
            case 3:
            case 4:
                return "а";
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 0:
                return "ов";
            default:
                return "";
        }
    }

    /**
     * Метод должен выводить разные строки в консоли в зависимости от некоторых условий:
     * - если остаток от деления на 3 равен нулю - выведите "foo" (example of number - 6)
     * - если остаток от деления на 5 равен нулю - вывести "bar" (example of number - 10)
     * - если остаток от деления на 3 и 5 равен нулю 0 ,то вывести "foobar" (example of number - 15)
     */
    public static void foobar(int number) {
        int remainder3 = number % 3;
        int remainder5 = number % 5;
        if (remainder3 == 0 && remainder5 != 0) {
            System.out.println(number + " divisible only by 3");
        } else if (remainder3 != 0 && remainder5 == 0) {
            System.out.println(number + " divisible only by 5");
        } else if (remainder3 == 0 && remainder5 == 0) {
            System.out.println(number + " divisible by 3 and 5");
        } else {
            System.out.println(number + " not divisible by 3 and 5");
        }
    }

    /**
     * заполнить рандомно 2-х мерный массив и посчитать сумму элементов на диагонали
     */
    public static void calculateSumOfDiagonalElements() {
        String value = readFromConsole("Enter integer number:");
        int dimension = convertToInteger(value);
        int[][] array2dimension = create2DimArray(dimension, dimension);
        int summ = 0;
        print2DimArray(array2dimension);
        for (int i = 0; i < array2dimension.length; i++) {
            summ += array2dimension[i][i];
        }
        System.out.println(summ);
    }

    private static int[][] create2DimArray(int rows, int cols) {
        int[][] array2dim = new int[rows][];
        for (int i = 0; i < array2dim.length; i++) {
            array2dim[i] = createArrayWithRandomFilling(cols);
        }
        return array2dim;
    }

    private static void print2DimArray(int[][] array) {
        for (int[] row : array) {
            for (int number : row) {
                System.out.printf("%3d", number);
            }
            System.out.println();
        }
    }

    /**
     * Шаги по реализации:
     * - Прочитать два int из консоли
     * - Создайте двумерный массив int (используйте целые числа, которые вы читаете по высоте и ширине консоли)
     * - Заполнить массив случайными значениями (до 100)
     * - Вывести в консоль матрицу заданного размера, но:
     * - Если остаток от деления элемента массива на 3 равен нулю - выведите знак "+" вместо значения элемента массива.
     * - Если остаток от деления элемента массива на 7 равен нулю - выведите знак "-" вместо значения элемента массива.
     * - В противном случае выведите "*"
     * <p>
     * Example:
     * - Значения с консоли - 2 и 3
     * - Массив будет выглядеть так (значения будут разными, потому что он случайный)
     * 6 11 123
     * 1 14 21
     * - Для этого значения вывод в консоли должен быть:
     * <p>
     * + * *
     * * - +
     * <p>
     * Обратите внимание, что 21% 3 == 0 и 21% 7 = 0, но выводить надо не +-, а +
     */
    public static void printMatrix() {
        String dimensionX = readFromConsole("Enter first dimension of array:");
        int dimX = convertToInteger(dimensionX);
        String dimensionY = readFromConsole("Enter second dimension of array:");
        int dimY = convertToInteger(dimensionY);
        int[][] array2dim = create2DimArray(dimX, dimY);
        print2DimArray(array2dim);
        System.out.println();
        for (int[] row : array2dim) {
            for (int number : row) {
                System.out.printf("%3s",processingNumber(number));
            }
            System.out.println();
        }
    }

    private static String processingNumber(int number) {
        if (number % 3 == 0) {
            return "+";
        }
        if (number % 7 == 0) {
            return "-";
        }
        return "*";
    }

    /**
     * Задача со звездочкой!
     * Метод должен печатать все простые числа <1000
     * что такое просто число (https://www.webmath.ru/poleznoe/formules_18_5.php)
     */
    public static void printPrimeNumbers() {
        // тут пишем логику
    }

    private static List<Integer> getStartList(){
        List<Integer> list = new ArrayList();
        for (int i = 2; i < 1001 ; i++) {
            list.add(i);
        }
        return list;
    }

}