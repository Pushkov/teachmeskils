package com.home.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Transport {
    private String model;
    private Integer power;
    private Integer mass;
    private Integer maximalSpeed;

}
