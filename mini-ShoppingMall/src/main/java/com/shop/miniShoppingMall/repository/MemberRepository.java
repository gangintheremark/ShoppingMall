package com.shop.miniShoppingMall.repository;

import com.shop.miniShoppingMall.model.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<MemberEntity, String> {
}
