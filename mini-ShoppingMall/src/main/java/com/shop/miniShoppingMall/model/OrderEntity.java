package com.shop.miniShoppingMall.model;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="orderinfo")
@Entity
public class OrderEntity {
    @Id
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
}
