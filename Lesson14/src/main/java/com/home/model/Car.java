package com.home.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Car {
    @JsonProperty("brand_name")
    private String brand;
    @JsonProperty("max_speed")
    private int maxSpeed;
    @JsonProperty("price")
    private int price;

    @Override
    public String toString() {
        return "Это автомобиль " +
                "марки " + brand + ". " +
                "Максимальная скорость составляет " + maxSpeed + " км/ч. " +
                "Цена " + price + " $.";
    }
}
