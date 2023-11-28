package com.shop.miniShoppingMall.service;

import com.shop.miniShoppingMall.dto.*;
import com.shop.miniShoppingMall.model.BuyerEntity;
import com.shop.miniShoppingMall.model.CartEntity;
import com.shop.miniShoppingMall.model.MemberEntity;
import com.shop.miniShoppingMall.model.OrderEntity;
import com.shop.miniShoppingMall.repository.BuyerRepository;
import com.shop.miniShoppingMall.repository.CartRepository;
import com.shop.miniShoppingMall.repository.MemberRepository;
import com.shop.miniShoppingMall.repository.OrderRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Service;

import java.lang.reflect.Member;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class OrderService {

    final private MemberRepository memberRepository;
    final private CartRepository cartRepository;
    final private OrderRepository orderRepository;
    final private BuyerRepository buyerRepository;

    public CartAndMemberDTO orderConfirm(String userid, Long cartid) {
        CartEntity cart = cartRepository.findByUseridAndCartid(userid, cartid);
        MemberEntity user = memberRepository.findById(userid).orElseThrow();

        return CartAndMemberDTO.builder()
                .cartid(cart.getCartid())
                .gcode(cart.getGcode())
                .gname(cart.getGname())
                .gsize(cart.getGsize())
                .gcolor(cart.getGcolor())
                .gimage(cart.getGimage())
                .gprice(cart.getGprice())
                .gamount(cart.getGamount())
                .userid(user.getUserid())
                .username(user.getUsername())
                .post(user.getPost())
                .addr1(user.getAddr1())
                .addr2(user.getAddr2())
                .phone(user.getPhone())
                .build();

    }

    public CartsAndMemberDTO orderConfirmAll(List<Long> cartIds, String userid) {
        List<CartEntity> carts = cartRepository.findCarts(cartIds);
        MemberEntity user = memberRepository.findById(userid).orElseThrow();

        List<CartDTO> cartDTOs = carts.stream().map(cart ->  CartDTO.builder()
                .cartid(cart.getCartid())
                .gcode(cart.getGcode())
                .gname(cart.getGname())
                .gsize(cart.getGsize())
                .gcolor(cart.getGcolor())
                .gprice(cart.getGprice())
                .gamount(cart.getGamount())
                .gimage(cart.getGimage())
                .build()
        ).collect(Collectors.toList());

        return CartsAndMemberDTO.builder()
                .carts(cartDTOs)
                .userid(user.getUserid())
                .username(user.getUsername())
                .post(user.getPost())
                .addr1(user.getAddr1())
                .addr2(user.getAddr2())
                .phone(user.getPhone())
                .build();
    }

    @Transactional
    public void save_buyerInfo(BuyerEntity request) {
        buyerRepository.save(request);
    }

    @Transactional
    public void save_orderInfo(OrderEntity request) {
        orderRepository.save(request);
    }

    @Transactional
    public void deleteCart(Long cartid, String userid) {
        CartEntity cart = cartRepository.findByUseridAndCartid(userid, cartid);
        cartRepository.delete(cart);
    }

    public BuyerDTO orderDone(String merchant_uid) {
        BuyerEntity buyer = buyerRepository.findById(merchant_uid).orElseThrow();
        return BuyerDTO.builder()
                .merchant_uid(buyer.getMerchant_uid())
                .userid(buyer.getUserid())
                .pay_method(buyer.getPay_method())
                .name(buyer.getName())
                .amount(buyer.getAmount())
                .phone(buyer.getPhone())
                .addr(buyer.getAddr())
                .post(buyer.getPost())
                .recipient(buyer.getRecipient())
                .build();
    }

    @Transactional
    public void orderDoneAll(List<CartDTO> carts, OrdererDTO order) {
        carts.forEach((cart) -> {
            OrderEntity orderEntity = OrderEntity.builder()
                    .userid(order.getUserid())
                    .recipient(order.getOrdername())
                    .post(order.getPost())
                    .phone(order.getPhone())
                    .gname(cart.getGname())
                    .gcode(cart.getGcode())
                    .gsize(cart.getGsize())
                    .gcolor(cart.getGcolor())
                    .gprice(cart.getGprice())
                    .gamount(cart.getGamount())
                    .gimage(cart.getGimage())
                    .build();

            orderRepository.save(orderEntity);
        });
    }

    @Transactional
    public void deleteCarts(List<CartDTO> carts) {
        carts.forEach((cart) -> {
            CartEntity cartEntity = CartEntity.builder()
                    .cartid(cart.getCartid())
                    .gname(cart.getGname())
                    .gcode(cart.getGcode())
                    .gsize(cart.getGsize())
                    .gcolor(cart.getGcolor())
                    .gprice(cart.getGprice())
                    .gamount(cart.getGamount())
                    .gimage(cart.getGimage())
                    .build();
            cartRepository.delete(cartEntity);
        });
    }
}
