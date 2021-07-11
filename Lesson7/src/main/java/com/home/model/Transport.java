package com.home.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
public class Transport {
    private String model;
    private Integer power;
    private Integer mass;
    private Integer maximalSpeed;

}
