package com.shop.miniShoppingMall.repository;

import com.shop.miniShoppingMall.model.CartEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepository extends JpaRepository<CartEntity, Long> {
    List<CartEntity> findByUserid(String userid);
    CartEntity findByUseridAndCartid(String userid, Long cartid);
}
