package com.shop.miniShoppingMall.dto;

import jdk.jfr.Name;
import lombok.*;

@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrdererDTO {
    private String userid;
    private String username;
    private String ordername;
    private String post;
    private String addr1;
    private String addr2;
    private String phone;
    private String paymethod;
    private int totalPrice;

}
