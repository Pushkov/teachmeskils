public class Main {
    public static void main(String[] args) {
        if (args.length > 0) {
            int countPositiveNumbers = 0;
            for (String arg : args) {
                try {
                    int currentArg = Integer.parseInt(arg);
                    if (currentArg > 0) {
                        countPositiveNumbers++;
                        System.out.println("Argument: " + arg + " - is positive number");
                    } else {
                        System.out.println("Argument: " + arg + " - is negative number");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Argument: " + arg + " - is not Integer");
                }
            }
            System.out.println("Count of arguments: " + args.length);
            System.out.println("Count of positive numbers: " + countPositiveNumbers);
        } else {
            System.out.println("Arguments not found.");
        }
    }
}
