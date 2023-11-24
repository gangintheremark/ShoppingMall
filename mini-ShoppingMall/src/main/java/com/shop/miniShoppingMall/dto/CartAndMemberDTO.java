package com.shop.miniShoppingMall.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CartAndMemberDTO {
    private Long cartid;
    private String userid;
    private String username;
    private String post;
    private String addr1;
    private String addr2;
    private String phone;
    private String gcode;
    private String gname;
    private String gcolor;
    private String gsize;
    private String gimage;
    private int gprice;
    private int gamount;
}
