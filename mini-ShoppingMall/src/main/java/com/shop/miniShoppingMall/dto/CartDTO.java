package com.shop.miniShoppingMall.dto;


import lombok.*;

@Builder
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CartDTO {
    private Long cartid;
    private String userid;
    private String gcode;
    private String gname;
    private int gprice;
    private String gsize;
    private String gcolor;
    private int gamount;
    private String gimage;
}
