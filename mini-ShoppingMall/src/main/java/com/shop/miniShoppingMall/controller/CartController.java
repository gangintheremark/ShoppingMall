package com.shop.miniShoppingMall.controller;

import com.shop.miniShoppingMall.dto.CartDTO;
import com.shop.miniShoppingMall.dto.CartEditDTO;
import com.shop.miniShoppingMall.model.CartEntity;
import com.shop.miniShoppingMall.service.CartService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class CartController {
    private final CartService cartService;

    @GetMapping("/carts")
    public String carts(HttpSession session, Model m) {
        String userid = (String) session.getAttribute("login");
        List<CartDTO> carts = cartService.findCarts(userid);
        m.addAttribute("carts", carts);

        return "goods/cartList";
    }

    @PostMapping("/cart")
    @ResponseBody
    public void cartAdd(@RequestBody CartEntity request) {
        cartService.cartAdd(request);
    }

    @PutMapping("/carts")
    @ResponseBody
    public void editCarts(@RequestBody CartEditDTO request) {
        cartService.cartEdit(request);
    }

    @DeleteMapping("/carts")
    @ResponseBody
    public void deleteCarts(@RequestBody Long cartid) {
        cartService.cartDelete(cartid);
    }
}
