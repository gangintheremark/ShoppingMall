package com.shop.miniShoppingMall.dto;

import lombok.*;

import java.util.List;

@ToString
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CartsAndMemberDTO {
    List<CartDTO> carts;
    private String userid;
    private String username;
    private String post;
    private String addr1;
    private String addr2;
    private String phone;

}
