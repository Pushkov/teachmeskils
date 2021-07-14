package com.home.service;

import com.home.exeptions.NoFreeVolumeInFuelTankExeption;
import com.home.model.Car;

import static com.home.utils.HomeWork8Utils.getEndingForRefueling;

public class CarServiceImpl implements CarService {
    private final Car car;
    private final EngineService engineService;
    private final FuelTankService fuelTankService;

    public CarServiceImpl(Car car) {
        this.car = car;
        this.engineService = new EngineServiceImpl(car.getEngine());
        this.fuelTankService = new FuelTankServiceImpl(car.getFuelTank());
    }

    @Override
    public void carInfo() {
        System.out.println(car);
    }

    @Override
    public boolean isEngineRunning() {
        return engineService.isRunning();
    }

    public void startEngine() {
        if (!isEngineRunning() && !isFuelEmpty()) {
            engineService.start();
        } else if (isEngineRunning()) {
            System.out.println("��������� ��� ��������");
        } else if (isFuelEmpty()) {
            System.out.println("��������� ����������");
        }
    }

    public void stopEngine() {
        if (isEngineRunning() && !isMoving()) {
            engineService.stop();
        } else if (!isEngineRunning()) {
            System.out.println("��������� �� �������");
        } else if (isMoving()) {
            System.out.println("������� ���������� ����������");
        }
    }

    public void startMoving() {
        if (isEngineRunning()) {
            setCarMoving(true);
            setCarCurrentSpeed();
            System.out.println("���������� ������ �� ��������� " + car.getCurrentSpeed() + " ��/�");
        } else {
            System.out.println("�������� ���������");
        }
    }

    public void stopMoving() {
        if (isMoving()) {
            setCarMoving(false);
            int distance = car.getCurrentSpeed() * 2; // ������ ����� 2 ���� ��� �������
            setCurrentTraveledDistance(distance);
            setTotalTraveledDistance(distance);
            System.out.println("���������� �����������.");
        }
    }

    @Override
    public boolean isMoving() {
        return car.isMoving();
    }

    @Override
    public boolean isFuelEmpty() {
        return fuelTankService.isEmpty();
    }

    public void viewFuelLevel() {
        System.out.println("������� ������� �������: " + fuelTankService.getFuelLevel());
    }

    @Override
    public void refueling() {
        int refuelVolume = fuelTankService.refuel();
        System.out.println("���������� ��������� " + refuelVolume + " ����" + getEndingForRefueling(refuelVolume) + " �������.");
    }

    @Override
    public void refueling(int fuelVolume) {
        try {
            int refuelVolume = fuelTankService.refuel(fuelVolume);
            System.out.println("���������� ��������� " + refuelVolume + " ����" + getEndingForRefueling(refuelVolume) + " �������.");
        } catch (NoFreeVolumeInFuelTankExeption e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void showCurrentTraveledDistance() {
        System.out.println("���������� ��������� �������: " + getTraveledDistance() +  " ��.");
    }

    public int getTraveledDistance() {
        return car.getTraveledDistance();
    }

    private void setCurrentTraveledDistance(int distance) {
        car.setTraveledDistance(distance);
    }

    @Override
    public void showTotalTraveledDistance() {
        System.out.println("����� ������ ����������: " + getTotalTraveledDistance() +  " ��.");
    }

    public int getTotalTraveledDistance() {
        return car.getTotalTraveledDistance();
    }

    private void setTotalTraveledDistance(int distance) {
        car.setTotalTraveledDistance(getTotalTraveledDistance() + distance);
    }

    private void setCarMoving(boolean isMove) {
        car.setMoving(isMove);
    }

    private void setCarCurrentSpeed() {
        car.setCurrentSpeed((int) (Math.random() * car.getMaxSpeed()));
    }
}
