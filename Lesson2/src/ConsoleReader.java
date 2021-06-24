import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleReader {

    public static int readInteger(String message) {
        Scanner scan = new Scanner(System.in);
        System.out.print(message);
        return scan.nextInt();
    }

    public static int[] readArrayOfInteger() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter some numbers: ");
        String list = scan.nextLine();
        List<Integer> listInteger = new ArrayList();
        scan = new Scanner(list);
        while (scan.hasNext()) {
            listInteger.add(scan.nextInt());
        }
        int[] resultArray = new int[listInteger.size()];
        for (int i = 0; i < resultArray.length; i++) {
            resultArray[i] = listInteger.get(i).intValue();
        }
        return resultArray;

    }


}
