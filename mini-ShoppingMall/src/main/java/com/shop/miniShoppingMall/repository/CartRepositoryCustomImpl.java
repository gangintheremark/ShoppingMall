package com.shop.miniShoppingMall.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.shop.miniShoppingMall.model.CartEntity;
import com.shop.miniShoppingMall.model.QCartEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class CartRepositoryCustomImpl implements CartRepositoryCustom {
    private final JPAQueryFactory queryFactory;

    @Override
    public List<CartEntity> findCarts(List<Long> cartIds) {
        List<CartEntity> carts = queryFactory.selectFrom(QCartEntity.cartEntity)
                .where(QCartEntity.cartEntity.cartid.in(cartIds))
                .fetch();

        return carts;
    }
}
