package com.shop.miniShoppingMall.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@ToString
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="buyerinfo")
@Entity
public class BuyerEntity {
    @Id
    private String merchant_uid;
    private String userid;
    private String pay_method;
    private String name;       // 상품명
    private int amount;     // 금액
    private String phone;
    private String addr;
    private String post;
    private String recipient;
}
