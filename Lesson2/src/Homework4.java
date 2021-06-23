public class Homework4 {
    public static void main(String[] args) {
        int[] array = ConsoleReader.readArrayOfInteger();
        if (array != null) {
            System.out.println("Max number in array: " + max(array));
        } else
            System.out.println("Array is empty");
    }

    /**
     * Метод должен вернуть максимальый элемент массива. Пример: array = {1,2,10,3} метод возвращает 10
     **/
    public static int max(int[] array) {
        int max = array[0];
        for (int i : array) {
            if (i > max)
                max = i;
        }
        return max;
    }

}
