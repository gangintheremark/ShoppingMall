package com.shop.miniShoppingMall.repository;

import com.shop.miniShoppingMall.model.BuyerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuyerRepository extends JpaRepository<BuyerEntity, String> {
}
