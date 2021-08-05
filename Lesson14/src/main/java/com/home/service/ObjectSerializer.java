package com.home.service;

import com.home.model.SimpleCar;

import java.io.*;

public class ObjectSerializer {

    public static void toFile(SimpleCar car, String path) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))) {
            oos.writeObject(car);
        }
    }

    public static void fromFile(String path) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))) {
            SimpleCar p = (SimpleCar) ois.readObject();
            System.out.println("Объект из файла: " + p.toString());
        }
    }
}
