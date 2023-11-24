package com.shop.miniShoppingMall.controller;

import com.shop.miniShoppingMall.dto.CartAndMemberDTO;
import com.shop.miniShoppingMall.dto.OrderDTO;
import com.shop.miniShoppingMall.model.OrderEntity;
import com.shop.miniShoppingMall.repository.CartRepository;
import com.shop.miniShoppingMall.repository.MemberRepository;
import com.shop.miniShoppingMall.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@Controller
public class OrderController {

    private final OrderService orderService;
    @GetMapping("/order")
    public String orderConfirm(@RequestParam Long cartid, Model m ) {
        CartAndMemberDTO order = orderService.orderConfirm(cartid);
        m.addAttribute("order", order);
        return "goods/orderConfirm";
    }

    @PostMapping("/orderDone")
    @ResponseBody
    public Long orderDone(@RequestBody OrderEntity request){
        OrderEntity order = orderService.orderDone(request);
        orderService.deleteCart(request.getCartid(), request.getUserid());
        return order.getOrderid();
    }

    @GetMapping("/orderDone")
    public String orderDone(@RequestParam Long orderid, Model m) {
        OrderDTO order = orderService.findOrder(orderid);
        m.addAttribute("order", order);

        return "goods/orderDone";
    }

}
