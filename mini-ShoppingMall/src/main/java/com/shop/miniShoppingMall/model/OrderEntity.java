package com.shop.miniShoppingMall.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="orderinfo")
@Entity
public class OrderEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderid;
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
    private String ordername;
    private String paymethod;
    private String orderDay;
}
