package com.home.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Getter
@Setter
public class Computer {

    private String processor;
    private Integer quantityRAM;
    private Integer quantityHDD;
    private Integer resource;
//
//    public void on() {
//        System.out.println("Компьютер включяется....");
//        try {
//            Thread.sleep(1500);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        if (this.resource == 0) {
//            crashed();
//        } else {
//            System.out.println("Компьютер включился");
//            int userStartupCode = InputUtils.readStartupCode();
//            int systemStartupCode = new Random().nextInt(2);
//            if (userStartupCode != systemStartupCode) {
//                crashed();
//            }
//        }
//    }
//
//    public void info() {
//        System.out.println("Информация о компьютере: ");
//        if (this.resource > 0) {
//            System.out.println(this);
//        } else {
//            crashed();
//        }
//    }
//
//    public void off() {
//        System.out.println("Компьютер выключяется....");
//        if (this.resource > 0) {
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            this.resource--;
//            System.out.println("Компьютер выключен.");
//        } else {
//            crashed();
//        }
//    }
//
//    public void crashed() {
//        this.resource = 0;
//        System.out.println("Компьютер сгорел.");
//    }
}
