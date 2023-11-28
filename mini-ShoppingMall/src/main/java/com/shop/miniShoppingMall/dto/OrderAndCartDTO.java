package com.shop.miniShoppingMall.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrderAndCartDTO {
    private String merchant_uid;
    private String userid;
    private String post;
    private String addr;
    private String phone;
    private String gcode;
    private String gname;
    private String gcolor;
    private String gsize;
    private String gimage;
    private int gprice;
    private int gamount;
    private String recipient;
    private String orderDay;
    private Long cartid;
}
