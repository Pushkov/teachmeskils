package com.home.util;

public class CalculationsUtils {

    public static Integer powerToKW(Integer powerInHorsePower) {
        return (int) Math.round(powerInHorsePower * 0.74);
    }

    public static Integer powerToHP(Integer powerInKiloWatt) {
        return (int) Math.round(powerInKiloWatt / 0.74);
    }
}
