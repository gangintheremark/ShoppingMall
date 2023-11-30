package com.shop.miniShoppingMall.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDTO {
    private String imp_uid;
    private String merchant_uid;
}
