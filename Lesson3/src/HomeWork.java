import java.io.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class HomeWork {

    public static void main(String[] args) {

        System.out.println("*** TASK: fill array random values and printing;");
        printArray();
        System.out.println();
        System.out.println("*** TASK: operation;");
        System.out.println(operation(1));
        System.out.println(operation(0));
        System.out.println(operation(-1));
        System.out.println();
        System.out.println("*** TASK: count of odd elements in array;");
        System.out.println(calculateCountOfOddElementsInMatrix(new int[]{1, 2, 3, 4, 5, 6}));
        System.out.println();
        System.out.println("*** TASK: sum of diagonal elements;");
        calculateSumOfDiagonalElements();
        System.out.println();
        System.out.println("*** TASK: count developers;");
        countDevs(11);
        countDevs(31);
        countDevs(42);
        countDevs(104);
        countDevs(105);
        countDevs(16);
        countDevs(107);
        countDevs(101);
        countDevs(109);
        countDevs(100);
        countDevs(187);
        countDevs(1);
        countDevs(2);
        System.out.println();
        System.out.println("*** TASK: division by 3 and 5;");
        foobar(1);
        foobar(3);
        foobar(4);
        foobar(6);
        foobar(10);
        foobar(11);
        foobar(15);
        System.out.println();
        System.out.println("*** TASK: print matrix;");
        printMatrix();
        System.out.println();
        System.out.println("*** TASK: prime numbers;");
        printPrimeNumbers();
    }

    /**
     * Необходимо прочитать с консоли значение числа типа int,
     * далее создать одноменрый массив типа int размера прочитаного с консоли
     * далее заполнить массив случайными значениями
     * далее вывести массив на консоль
     */
    private static void printArray() {
        String arrayLengthInStringFormat = readFromConsole("Enter size of array:");
        int arrayDimension = convertToInteger(arrayLengthInStringFormat);
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
        System.out.printf("Original number: %d - processed number - ", number);
        if (number > 0) {
            number += 1;
        } else if (number == 0) {
            number = 10;
        } else {
            number -= 2;
        }
        return number;
    }

    /**
     * На вход приходит массив целых чисел типа int
     * Необходимо найти количество нечетных элементов в массиве и вернуть значение в метод main,
     * в котором это значение распечатается на консоль.
     */
    public static int calculateCountOfOddElementsInMatrix(int[] ints) {
        System.out.print("Original array: " + Arrays.toString(ints) + "; Count odd elements: ");
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
        System.out.println("Сделано с SWITCH: " + count + " программист" + getEndingSwitch(count));
        System.out.println("Сделано с IF: " + count + " программист" + getEndingIf(count));
    }

    private static String getEndingIf(int count) {
        String ending = "";
        if (count % 10 >= 2) {
            ending = "а";
        }
        if (count % 10 >= 5 || count % 10 == 0 || (count >= 11 & count <= 14)) {
            ending = "ов";
        }
        return ending;
    }

    private static String getEndingSwitch(int count) {
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
            System.out.println("foo");
        } else if (remainder3 != 0 && remainder5 == 0) {
            System.out.println("bar");
        } else if (remainder3 == 0 && remainder5 == 0) {
            System.out.println("foobar");
        }
    }

    /**
     * заполнить рандомно 2-х мерный массив и посчитать сумму элементов на диагонали
     */
    public static void calculateSumOfDiagonalElements() {
        String value = readFromConsole("Enter size two-dimension array:");
        int dimension = convertToInteger(value);
        int[][] array2dimension = create2DimArray(dimension, dimension);
        int summ = 0;
        print2DimArray(array2dimension);
        System.out.print("Elements of diagonal: ");
        for (int i = 0; i < array2dimension.length; i++) {
            summ += array2dimension[i][i];
            System.out.printf("%3d", array2dimension[i][i]);
        }
        System.out.println("\nSum: " + summ);
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
        System.out.println("Original array:");
        print2DimArray(array2dim);
        System.out.println();
        System.out.println("Processed array:");
        for (int[] row : array2dim) {
            for (int number : row) {
                System.out.printf("%3s", processingNumber(number));
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
        Integer[] primeArray = getStartList().toArray(new Integer[0]);
        System.out.println("Count of prime numbers: " + primeArray.length);
        System.out.println("List of prime numbers: " + Arrays.toString(primeArray));
    }

    private static List<Integer> getStartList() {
        List<Integer> primeList = new ArrayList<>();
        for (int i = 2; i < 1001; i++) {
            boolean isPrime = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                }
            }
            if (isPrime) {
                primeList.add(i);
            }
        }
        return primeList;
    }
}