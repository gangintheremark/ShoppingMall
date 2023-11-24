package com.shop.miniShoppingMall.model;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cart")
@Entity
public class CartEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
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
