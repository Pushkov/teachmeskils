package com.tms.service;

import com.tms.model.Computer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ComputerServiceImpl implements ComputerService {

    List<Computer> computersInWork = new ArrayList<>();

    @Override
    public void on(Computer computer) {
        if (!hasComputerInWork(computer)) {
            if (hasResource(computer)) {
                System.out.printf("(on)Компьютер %s запускается...\n", computer.getProcessor());
                setDelay(1000);
                if (!checkStartupCode()) {
                    crashed(computer);
                    return;
                }
                System.out.printf("Компьтер %s работает\n", computer.getProcessor());
                computersInWork.add(computer);
            } else {
                System.out.printf("Компьютер %s неисправен...\n", computer.getProcessor());
            }
        } else {
            System.out.printf("(on) Компьютер %s уже работает", computer.getProcessor());
        }
    }

    @Override
    public void info(Computer computer) {
        if (hasComputerInWork(computer)) {
            System.out.println("(info)" + computer.toString());
        } else {
            System.out.printf("(info) Компьютр %s выключен или неисправен\n", computer.getProcessor());
        }
    }

    @Override
    public void off(Computer computer) {
        if (hasComputerInWork(computer)) {
            System.out.printf("(off)Компьютер %s выключается ...\n", computer.getProcessor());
            setDelay(1000);
            int resource = computer.getResource();
            computer.setResource(--resource);
            computersInWork.remove(computer);
            System.out.printf("Компьютер %s выключился.\n", computer.getProcessor());
        } else {
            System.out.printf("(off) Компьютр %s выключен или неисправен\n", computer.getProcessor());
        }
    }

    @Override
    public boolean hasResource(Computer computer) {
        return computer.getResource() > 0;
    }

    @Override
    public void crashed(Computer computer) {
        System.out.printf("Компьютер %s сгорел....", computer.getProcessor());
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
