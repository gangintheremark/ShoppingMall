package com.shop.miniShoppingMall.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.math.BigDecimal;

@ToString
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="pre_payment")
@Entity
public class PrePaymentEntity {
    @Id
    private String merchant_uid;
    BigDecimal amount;
}
