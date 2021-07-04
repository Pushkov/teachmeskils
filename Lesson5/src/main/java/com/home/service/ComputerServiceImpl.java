package com.home.service;

import com.home.model.Computer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ComputerServiceImpl implements ComputerService {

    List<Computer> computersInWork = new ArrayList<>();

    @Override
    public void on(Computer computer) {
        if (!hasComputerInWork(computer)) {
            if (hasResource(computer)) {
                System.out.println("(on)Компьютер запускается...");
                setDelay(1000);
                if (!checkStartupCode()) {
                    crashed(computer);
                    return;
                }
                System.out.println("Компьтер работает");
                computersInWork.add(computer);
            } else {
                System.out.println("Компьютер неисправен...");
            }
        } else {
            System.out.println("(on) Компьютер уже работает");
        }
    }

    @Override
    public void info(Computer computer) {
        if (hasComputerInWork(computer)) {
            System.out.println("(info)" + computer.toString());
        } else {
            System.out.println("(info) Компьютр выключен или неисправен");
        }
    }

    @Override
    public void off(Computer computer) {
        if (hasComputerInWork(computer)) {
            System.out.println("(off)Компьютер выключается ...");
            setDelay(1000);
            int resource = computer.getResource();
            computer.setResource(--resource);
            computersInWork.remove(computer);
            System.out.println("Компьютер выключился.");
        } else {
            System.out.println("(off) Компьютр выключен или неисправен");
        }
    }

    @Override
    public boolean hasResource(Computer computer) {
        return computer.getResource() > 0;
    }

    @Override
    public void crashed(Computer computer) {
        System.out.println("Компьютер сгорел....");
        computer.setResource(0);
        computersInWork.remove(computer);

    }

    private void setDelay(int mills) {
        try {
            Thread.sleep(mills);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private boolean hasComputerInWork(Computer computer) {
        return computersInWork.contains(computer);
    }

    private boolean checkStartupCode() {
        int userStartupCode = InputUtils.readStartupCode();
        int systemStartupCode = new Random().nextInt(2);
        return userStartupCode != systemStartupCode;
    }

}
