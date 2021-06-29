import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class HomeWork {
    public static void main(String[] args) {
        //1)
//        cellDoubling();
//        2)
//        System.out.println("Произведение: " + summ(5,3));
//        3)
//        fourTriangle();
//        4)
//        numberOfDigits();
//        5)
//        printReverseArray();
//        6)
//        indexOfMaxElement();
//        7)
//        replaceOddElements();
//        8)
//        changeMinMax();
//        9)
//        findDuplicatedElements();
//        10)
//        transposeMatrix();
    }

    //         1) Одноклеточная амеба каждые 3 часа делится на 2 клетки. Определить,
//   сколько амеб будет через 3, 6, 9, 12,..., 24 часа
    private static void cellDoubling() {
        int cellCount = 1;
        System.out.printf("Число амеб в начальный момент времени %d\n", cellCount);
        for (int i = 3; i <= 24; i += 3) {
            cellCount *= 2;
            System.out.printf("Прошло времени, часов: %d, Число амеб, штук: %d\n", i, cellCount);
        }
    }

    //        2) Напишите реализацию метода summ(int a, int b), вычисляющий a*b, не пользуясь операцией
//        умножения, где a и b целые числа, вызовите метод summ  в методе main и распечатайте на консоль.
    private static int summ(int a, int b) {
        int result = 0;
        for (int i = 0; i < b; i++) {
            result += a;
        }
        return result;
    }

    //        3) Дан двухмерный массив размерностью 4 на 4, необходимо нарисовать четыре треугольника вида
    //        a)                  b)
//              *        *
//            * *        * *
//          * * *        * * *
//        * * * *        * * * *
//
//        c)                  d)
//        * * * *        * * * *
//          * * *        * * *
//            * *        * *
//              *        *
    private static void fourTriangle() {

    }

    //        4)В переменную записываем число.
//        Надо вывести на экран сколько в этом числе цифр и положительное оно или отрицательное.
//        Например, Введите число: 5
//        "5 - это положительное число, количество цифр = 1"
    private static void numberOfDigits() {
        int number = InputUtils.readIntFromConsole("Введите произольное целое число", false);
        int count = (number == 0) ? 1 : 0;
        while (number != 0) {
            count++;
            number /= 10;
        }
        System.out.println("Количество цифр: " + count);
    }

    //        5) Создайте массив из всех нечётных чисел от 1 до 100, выведите его на экран в строку,
//        а затем этот же массив выведите на экран тоже в строку, но в обратном порядке (99 97 95 93 ... 7 5 3 1).
    private static void printReverseArray() {
        System.out.print("(");
        for (int i = 1; i < 100; i++) {
            System.out.printf("%3d", i);
        }
        System.out.println(" )");
        System.out.print("(");
        for (int i = 99; i > 0; i--) {
            System.out.printf("%3d", i);
        }
        System.out.println(" )");
    }

    //        6) Создайте массив из int[] mass = new int[12]; Рандомно заполните его значениями от 0 до 15.
//        Определите какой элемент является в этом массиве максимальным и сообщите индекс его последнего вхождения в массив.
//        Пример: {3,4,5,62,7,8,4,-5,7,62,5,1} Максимальный элемент 62, индекс его последнего вхождения в массив = 10
    private static void indexOfMaxElement() {
        Random random = new Random();
        int maxElement = 0;
        int indexMax = 0;
        int[] array = new int[12];
        System.out.print("(");
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(15);
            System.out.printf("%3d", array[i]);
            if (i == 0) {
                maxElement = array[i];
                indexMax = i;
                continue;
            }
            if (array[i] >= maxElement) {
                maxElement = array[i];
                indexMax = i;
            }
        }
        System.out.println(" )");
        System.out.println("Максимальный элемент: " + maxElement);
        System.out.println("Индекс максимального элемента: " + indexMax);
    }

    //        7) Создайте массив размера 20, заполните его случайными целыми чиселами из отрезка от 0 до 20.
//        Выведите массив на экран в строку. Замените каждый элемент с нечётным индексом на ноль.
//        Снова выведете массив на экран на отдельной строке.
    private static void replaceOddElements() {
        int[] array = InputUtils.createArrayWithRandomElements(20, 20);
        System.out.println(Arrays.toString(array));
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            array[i] = array[i] % 2 != 0 ? 0 : array[i];
            System.out.printf("%3d", array[i]);
        }
        System.out.println(" ]");
    }

    //        8) Найти максимальный элемент в массиве {4,5,0,23,77,0,8,9,101,2} и поменять его местами с нулевым элементом
    private static void changeMinMax() {
        int size = InputUtils.readIntFromConsole("Введите длину массива: ", true);
        int bound = InputUtils.readIntFromConsole("Введите максимально возможное значение ячейки: ", true);
        int[] array = InputUtils.createArrayWithRandomElements(size, bound);
//        int[] array = {4, 5, 0, 23, 77, 0, 8, 9, 101, 2};
        System.out.println(Arrays.toString(array));
        int maxValue = array[0];
        int indexMaxValue = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] >= maxValue) {
                maxValue = array[i];
                indexMaxValue = i;
            }
        }
        int tempElement = array[0];
        array[0] = array[indexMaxValue];
        array[indexMaxValue] = tempElement;
        System.out.println(Arrays.toString(array));
    }

    //        9) Проверить, различны ли все элементы массива, если не различны то вывести элемент повторяющийся
//        Пример: {0,3,46,3,2,1,2}
//        Массив имеет повторяющиеся элементы 3, 2
//        Пример: {0,34,46,31,20,1,28}
//        Массив не имеет повторяющихся элементов
    private static void findDuplicatedElements() {
        int size = InputUtils.readIntFromConsole("Введите длину массива:", true);
        int[] array = InputUtils.createArrayWithRandomElements(size, 15);
        System.out.println(Arrays.toString(array));
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < array.length - 1; i++) {
            int checked = array[i];
            boolean isRepeats = false;
            for (int j = i + 1; j < array.length; j++) {
                if (checked == array[j] && !isRepeats) {
                    isRepeats = true;
                    list.add(checked);
                }
            }
            isRepeats = false;
        }
        if (list.size() > 0) {
            System.out.print("Массив имеет повторяющиесы элементы: ");
            System.out.println(Arrays.toString(list.toArray()));
        } else {
            System.out.print("Массив повторений не имеет.");
        }
    }

    //        10) Создаём квадратную матрицу, размер вводим с клавиатуры.
//        Заполняем случайными числами в диапазоне от 0 до 50. И выводим на консоль(в виде матрицы).
//        Далее необходимо транспонировать матрицу(1 столбец станет 1-й строкой, 2-й столбец - 2-й строкой и т. д.)
//        Пример:
//          1 2 3 4      1 6 3 1
//          6 7 8 9      2 7 3 5
//          3 3 4 5      3 8 4 6
//          1 5 6 7      4 9 5 7
    private static void transposeMatrix() {
        int size = InputUtils.readIntFromConsole("Введите размер квадратной матрицы: ", true);
        int[][] array = InputUtils.createSquareMatrix(size, 50);
        System.out.println("Исходная матрица");
        InputUtils.printTwoDimensionalMatrix(array);
        int[][] transposedArray = new int[size][size];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                transposedArray[j][i] = array[i][j];
            }
        }
        System.out.println("Транспонированная матрица");
        InputUtils.printTwoDimensionalMatrix(transposedArray);
    }
}