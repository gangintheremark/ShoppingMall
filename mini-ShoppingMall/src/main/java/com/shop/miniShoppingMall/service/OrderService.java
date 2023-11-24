package com.shop.miniShoppingMall.service;

import com.shop.miniShoppingMall.dto.*;
import com.shop.miniShoppingMall.model.CartEntity;
import com.shop.miniShoppingMall.model.MemberEntity;
import com.shop.miniShoppingMall.model.OrderEntity;
import com.shop.miniShoppingMall.repository.CartRepository;
import com.shop.miniShoppingMall.repository.MemberRepository;
import com.shop.miniShoppingMall.repository.OrderRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
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
        for(CartEntity dto : carts) {
            System.out.println("CArts : " + dto);
        }

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
    public OrderEntity orderDone(OrderEntity request) {
        OrderEntity order = orderRepository.save(request);

        return order;
    }

    @Transactional
    public void deleteCart(Long cartid, String userid) {
        CartEntity cart = cartRepository.findByUseridAndCartid(userid, cartid);
        cartRepository.delete(cart);
    }

    public OrderDTO findOrder(Long orderid) {
        OrderEntity order = orderRepository.findById(orderid).orElseThrow();

        return OrderDTO.builder()
                .orderid(order.getOrderid())
                .cartid(order.getCartid())
                .gcode(order.getGcode())
                .gname(order.getGname())
                .gsize(order.getGsize())
                .gcolor(order.getGcolor())
                .gimage(order.getGimage())
                .gprice(order.getGprice())
                .gamount(order.getGamount())
                .userid(order.getUserid())
                .username(order.getUsername())
                .post(order.getPost())
                .addr1(order.getAddr1())
                .addr2(order.getAddr2())
                .phone(order.getPhone())
                .ordername(order.getOrdername())
                .paymethod(order.getPaymethod())
                .build();
    }

    @Transactional
    public void orderDoneAll(List<CartDTO> carts, OrdererDTO order) {
        carts.forEach((cart) -> {
            OrderEntity orderEntity = OrderEntity.builder()
                    .userid(order.getUserid())
                    .username(order.getUsername())
                    .ordername(order.getOrdername())
                    .post(order.getPost())
                    .addr1(order.getAddr1())
                    .addr2(order.getAddr2())
                    .phone(order.getPhone())
                    .paymethod(order.getPaymethod())
                    .cartid(cart.getCartid())
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
