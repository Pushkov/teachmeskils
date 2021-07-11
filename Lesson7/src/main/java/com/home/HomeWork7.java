package com.home;

import com.home.model.*;

public class HomeWork7 {
    public static void main(String[] args) {

        Transport air = new CivilAirTransport();
        air.setModel("model");
        air.setPower(100);
        System.out.println(air);
        air = new MilitaryAirTransport();
        air.setModel("model");
        air.setPower(100);
        System.out.println(air);
        air = new PassengerGroundTransport();
        air.setModel("model");
        air.setPower(100);
        System.out.println(air);
        air = new FreightGroundTransport();
        air.setModel("model");
        air.setPower(100);
        System.out.println(air);
//        System.out.println(powerToKW(100));
//        System.out.println(powerToHP(74));
    }
}
