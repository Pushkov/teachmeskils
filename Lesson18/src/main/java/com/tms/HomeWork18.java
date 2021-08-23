package com.tms;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.tms.model.CashRegister;
import com.tms.model.Product;
import com.tms.model.User;
import com.tms.produce.Factory;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class HomeWork18 {
    public static final int CASH_REGISTER = 3;
    public static final int USERS_COUNT = 7;
    public static final int PRODUCT_LIMIT = 2;
    public static Random random = new Random();

    private static Factory factory;
    private static List<User> users;

    public static void main(String[] args) {
        factory = Factory.getInstance();
        users = factory.create(User.class, USERS_COUNT);
        users.forEach(u -> u.setProducts(factory.create(Product.class, getProductCount())));
        users.forEach(System.out::println);
//        threadPoolMethod();
        lockMethod();
    }

    private static void threadPoolMethod() {
        System.out.println("Разбор единой очереди с помощью пул-а потоков.");
        final ThreadFactory threadFactory = new ThreadFactoryBuilder()
                .setNameFormat(" Касса №-%d")
                .build();
        final ExecutorService service = Executors.newFixedThreadPool(CASH_REGISTER, threadFactory);
        users.forEach(service::submit);
        service.shutdown();
    }

    private static void lockMethod() {
        System.out.println("Разбиение покупателей на очереди для каждой кассы и обслуживание  каждого пользователся в кассе с использованием блокировки");
        List<CashRegister> cashRegisters = factory.create(CashRegister.class, CASH_REGISTER);
        List<CashRegister> usersQueues = splitUsersByCashRegistry(users, cashRegisters);
        usersQueues.forEach(x -> System.out.println(x + "\n"));
        usersQueues.forEach(cashRegister -> cashRegister.getQueue().forEach(user -> cashRegistryService(cashRegister, user)));
    }

    private static void cashRegistryService(CashRegister cass, User user) {
        user.setCass(cass);
        Thread thread = new Thread(user, cass.getName());
        thread.start();
    }

    private static List<CashRegister> splitUsersByCashRegistry(List<User> users, List<CashRegister> cashRegisters) {
        int index = 0;
        for (User u : users) {
            if (index >= cashRegisters.size()) {
                index = 0;
            }
            cashRegisters.get(index).getQueue().add(u);
            index++;
        }
        return cashRegisters;
    }

    private static int getProductCount() {
        return random.nextInt(PRODUCT_LIMIT) + 1;
    }
}
