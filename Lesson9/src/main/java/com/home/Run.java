package com.home;

import com.home.hands.SamsungHand;
import com.home.hands.SonyHand;
import com.home.hands.ToshibaHand;
import com.home.heads.SamsungHead;
import com.home.heads.SonyHead;
import com.home.heads.ToshibaHead;
import com.home.legs.SamsungLeg;
import com.home.legs.SonyLeg;
import com.home.legs.ToshibaLeg;

import java.util.List;

public class Run {
    public static void main(String[] args) {
        /*
        Создать по 3 реализации(Sony, Toshiba, Samsung) каждой запчасти(IHead, IHand, ILeg)
        Класс SonyHead является примером реализацией головы от Sony.
        Создайте 3 робота с разными комплектующими.
        Например у робота голова и нога от Sony а, рука от Samsung.
        У всех роботов вызовите метод action.
        Среди 3-х роботов найдите самого дорогого.
        */
        List<IRobot> robotList = List.of(
                new Robot(new SonyHead(123), new SamsungHand(452), new ToshibaLeg(55)),
                new Robot(new SamsungHead(88), new ToshibaHand(321), new SonyLeg(24)),
                new Robot(new ToshibaHead(114), new SonyHand(234), new SamsungLeg(77))
        );
        IRobot mostExpensiveRobot = null;
        int maxPrice = 0;
        for (IRobot robot : robotList) {
            System.out.println("Робот №" + (robotList.indexOf(robot) + 1));
            robot.action();
            if (robot.getPrice() > maxPrice) {
                maxPrice = robot.getPrice();
                mostExpensiveRobot = robot;
            }
            System.out.println();
        }
        if (mostExpensiveRobot != null) {
            System.out.println("Самый дорогой робот:");
            mostExpensiveRobot.action();
        } else {
            System.out.println("Самый дорогой робот не определен");
        }
    }
}
