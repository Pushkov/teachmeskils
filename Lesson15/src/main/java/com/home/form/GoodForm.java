package com.home.form;

import com.home.model.Good;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GoodForm {
    private int id;
    private String name;
    private int price;

    public static Good toGood(GoodForm form) {
        return Good.builder()
                .id(form.getId())
                .name(form.getName())
                .price(form.getPrice())
                .build();
    }

    public static GoodForm fromGood(Good good) {
        return GoodForm.builder()
                .id(good.getId())
                .name(good.getName())
                .price(good.getPrice())
                .build();
    }

}
