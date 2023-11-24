package com.shop.miniShoppingMall.repository;

import com.shop.miniShoppingMall.model.GoodsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GoodsRepository extends JpaRepository<GoodsEntity, String> {
    List<GoodsEntity> findByGcategory(String gcategory);

}
