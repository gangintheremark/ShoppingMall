package com.shop.miniShoppingMall.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BuyerDTO {
    private String merchant_uid;
    private String userid;
    private String pay_method;
    private String name;
    private int amount;
    private String phone;
    private String addr;
    private String post;
    private String recipient;
}
