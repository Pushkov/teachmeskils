import java.util.Arrays;
import java.util.stream.Collectors;

public class MainStream {
    public static void main(String[] args) {
        if (args.length > 0) {
            int countPositiveNumbers = Arrays.stream(args)
                    .map(argument -> {
                        try {
                            return Integer.valueOf(argument);
                        } catch (NumberFormatException e) {
                            System.out.println("Argument: " + argument + " - is not integer number");
                            return -1;  //Не знаю насколько корректно этот метод обработки исключения
                        }
                    })
                    .filter(number -> number >= 0)
                    .collect(Collectors.toList())
                    .size();
            System.out.println("Count of arguments: " + args.length);
            System.out.println("Count of positive numbers: " + countPositiveNumbers);
        } else {
            System.out.println("Arguments not found.");
        }
    }
}
