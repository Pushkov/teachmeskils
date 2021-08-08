package com.home.service;

import lombok.experimental.UtilityClass;

import java.io.*;

@UtilityClass
public class ObjectSerializer {

    public static void toFile(Object object, String path) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))) {
            oos.writeObject(object);
        }
    }

    public static Object fromFile(String path) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))) {
            return ois.readObject();
        }
    }
}
