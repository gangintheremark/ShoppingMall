package com.shop.miniShoppingMall.dto;

import lombok.*;

@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CartEditDTO {
    private Long cartid;
    private int gamount;
}
