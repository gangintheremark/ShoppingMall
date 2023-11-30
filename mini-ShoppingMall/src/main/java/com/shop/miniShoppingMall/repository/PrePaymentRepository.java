package com.shop.miniShoppingMall.repository;

import com.shop.miniShoppingMall.model.PrePaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrePaymentRepository extends JpaRepository<PrePaymentEntity, String> {
}
