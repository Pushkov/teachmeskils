import java.util.Arrays;
import java.util.Objects;

public class MainStream {
    public static void main(String[] args) {
        if (args.length > 0) {
            long countPositiveNumbers = Arrays.stream(args)
                    .map(MainStream::convertToInteger)
                    .filter(Objects::nonNull)
                    .filter(number -> number > 0)
                    .count();
            System.out.println("Count of arguments: " + args.length);
            System.out.println("Count of positive numbers: " + countPositiveNumbers);
        } else {
            System.out.println("Arguments not found.");
        }
    }

    private static Integer convertToInteger(String stringValue) {
        try {
            return Integer.valueOf(stringValue);
        } catch (NumberFormatException e) {
            System.out.println("Argument: " + stringValue + " - is not integer number");
        }
        return null;
    }
}
