package com.tms.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Computer {

    private String processor;
    private Integer quantityRAM;
    private Integer quantityHDD;
    private Integer resource;
}
