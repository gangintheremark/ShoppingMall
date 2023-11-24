package com.shop.miniShoppingMall.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Builder
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name="goods")
@Entity
public class GoodsEntity {
    @Id
    private String gcode;
    private String gcategory;
    private String gname;
    private String gcontent;
    private int gprice;
    private String gimage;
}
