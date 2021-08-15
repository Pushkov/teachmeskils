package tt;

import java.util.function.Consumer;

public class testMain {
    public static void main(String[] args) {

        Consumer<Integer> consumer = v -> v += 5;
//        consumer.andThen(System.out::println).accept(333);
        consumer.accept(333);
    }
}
