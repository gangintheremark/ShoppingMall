package com.shop.miniShoppingMall.service;

import com.shop.miniShoppingMall.dto.CartDTO;
import com.shop.miniShoppingMall.dto.CartEditDTO;
import com.shop.miniShoppingMall.model.CartEntity;
import com.shop.miniShoppingMall.repository.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CartService {
    private final CartRepository cartRepository;

    public List<CartDTO> findCarts(String userid) {
        List<CartEntity> carts = cartRepository.findByUserid(userid);

        return carts.stream().map((cart)-> CartDTO.builder()
                .cartid(cart.getCartid())
                .userid(cart.getUserid())
                .gcode(cart.getGcode())
                .gname(cart.getGname())
                .gprice(cart.getGprice())
                .gsize(cart.getGsize())
                .gcolor(cart.getGcolor())
                .gamount(cart.getGamount())
                .gimage(cart.getGimage())
                .build()).toList();
    }

    public CartEntity cartAdd(CartEntity request) {
        cartRepository.save(request);
        return request;
    }

    public void cartEdit(CartEditDTO request) {
        CartEntity cart = cartRepository.findById(request.getCartid()).orElseThrow();
        cart.setGamount(request.getGamount());
        cartRepository.save(cart);
    }

    public void cartDelete(Long cartid) {
        CartEntity cart = cartRepository.findById(cartid).orElseThrow();
        cartRepository.delete(cart);
    }
}

