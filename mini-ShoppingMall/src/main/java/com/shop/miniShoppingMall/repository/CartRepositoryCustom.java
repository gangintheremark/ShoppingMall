package com.shop.miniShoppingMall.repository;

import com.shop.miniShoppingMall.model.CartEntity;

import java.util.List;

public interface CartRepositoryCustom {
    List<CartEntity> findCarts(List<Long> cartIds);
}
