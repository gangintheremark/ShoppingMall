package com.shop.miniShoppingMall.dto;

import lombok.*;

@Getter
@Builder
@ToString
@NoArgsConstructor(force = true)
@AllArgsConstructor
public class GoodsDTO {
    private final String gcode;
    private final String gcategory;
    private final String gname;
    private final String gcontent;
    private final int gprice;
    private final String gimage;
}
