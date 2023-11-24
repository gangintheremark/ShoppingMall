package com.shop.miniShoppingMall.service;

import com.shop.miniShoppingMall.dto.CartAndMemberDTO;
import com.shop.miniShoppingMall.dto.OrderDTO;
import com.shop.miniShoppingMall.model.CartEntity;
import com.shop.miniShoppingMall.model.MemberEntity;
import com.shop.miniShoppingMall.model.OrderEntity;
import com.shop.miniShoppingMall.repository.CartRepository;
import com.shop.miniShoppingMall.repository.MemberRepository;
import com.shop.miniShoppingMall.repository.OrderRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class OrderService {

    final private MemberRepository memberRepository;
    final private CartRepository cartRepository;
    final private OrderRepository orderRepository;

    public CartAndMemberDTO orderConfirm(Long cartid) {
        CartEntity cart = cartRepository.findById(cartid).orElseThrow();
        MemberEntity user = memberRepository.findById(cart.getUserid()).orElseThrow();

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
}
