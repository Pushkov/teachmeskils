package com.home;

import com.home.model.Car;
import com.home.model.Engine;
import com.home.model.FuelTank;
import com.home.service.CarService;
import com.home.service.CarServiceImpl;

public class HomeWork8 {
    public static void main(String[] args) {
    /*
 Напишите структуру классов и продемонстрируйте работу

 - Машина имеет двигатель, бензобак (реализуйте класс для каждой сущности).
 - Чтобы поехать, машину необходимо завести, т.е. включить двигатель.
 - Реализуйте методы включения машины, который в свою очередь включает её двигатель.
 - Реализуйте метод езды на машине (например просто печатаем на консоль, что машина поехала)
 - Если машина не заведена, ехать она не может.
 - Машину можно заглушить.
 - После каждой поездки считаем, что машина прошла фиксированное расстояние.
 - Реализовать возможность посмотреть, какое расстояние машина прошла за все время.
 - Чтобы создать машину обязательно нужно иметь двигатель и бензобак.
 - Марка машины, год выпуска, пройденное расстояние - не обязательны при создании машины и могут быть выставлены потом.
 (не обязательно задавать в конструкторе)
 - После создания поменять двигатель машине нельзя.
 - Чтобы машина завелась, у неё должно быть топливо в бензобаке, если топлива нет, машина не может завестись.
 - Машину можно дозаправить, можно проверить сколько топлива осталось.
 - Реализуйте пару полей для двигателя и бензобака, например: тип двигателя, общий объем бензобака,
 сколько бензина сейчас и т.д.
     */
        CarService carService = new CarServiceImpl(initCar());
        carService.carInfo();
        carService.viewFuelLevel();
        carService.refueling(53);
        carService.refueling(70);
        carService.refueling(2);
        carService.viewFuelLevel();
        carService.startEngine();
        carService.startMoving();
        carService.stopMoving();
        carService.showCurrentTraveledDistance();
        carService.startMoving();
        carService.stopMoving();
        carService.showCurrentTraveledDistance();
        carService.startMoving();
        carService.stopEngine();
        carService.stopMoving();
        carService.showCurrentTraveledDistance();
        carService.stopEngine();
        carService.showTotalTraveledDistance();
    }

    private static Car initCar(){
        Car car = new Car(new Engine("diesel",2000),new FuelTank(64));
        car.setModel("Mazda");
        car.setColor("Red");
        car.setYearOfIssue(1991);
        car.setMaxSpeed(160);
        return car;
    }

}
