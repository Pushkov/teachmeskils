package com.tms;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.tms.model.Product;
import com.tms.model.User;
import com.tms.produce.Factory;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class HomeWork18 {
    public static final int CASH_REGISTER = 5;
    public static final int USERS_COUNT = 12;
    public static final int PRODUCT_LIMIT = 5;
    public static Random random = new Random();

    public static void main(String[] args) {
        Factory factory = Factory.getInstance();
        List<User> users = factory.create(User.class, USERS_COUNT);
        users.forEach(u -> u.setProducts(factory.create(Product.class, getProductCount())));
        users.forEach(System.out::println);

        final ThreadFactory threadFactory = new ThreadFactoryBuilder()
                .setNameFormat(" №-%d")
                .build();
        final ExecutorService service = Executors.newFixedThreadPool(CASH_REGISTER, threadFactory);
        users.forEach(service::submit);
        service.shutdown();
    }

    private static int getProductCount() {
        return random.nextInt(PRODUCT_LIMIT) + 1;
    }
}
