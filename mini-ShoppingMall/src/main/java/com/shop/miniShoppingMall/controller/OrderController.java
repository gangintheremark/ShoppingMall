package com.shop.miniShoppingMall.controller;

import com.shop.miniShoppingMall.dto.*;
import com.shop.miniShoppingMall.model.OrderEntity;
import com.shop.miniShoppingMall.repository.CartRepository;
import com.shop.miniShoppingMall.repository.MemberRepository;
import com.shop.miniShoppingMall.service.OrderService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class OrderController {

    private final OrderService orderService;
    @GetMapping("/order")
    public String orderConfirm(@RequestParam Long cartid, HttpSession session, Model m ) {
        String userid =  (String) session.getAttribute("login");
        CartAndMemberDTO order = orderService.orderConfirm(userid, cartid);
        m.addAttribute("order", order);
        return "goods/orderConfirm";
    }

    @GetMapping("/orders")
    public String orderConfirmAll(@RequestParam Long[] check, HttpSession session, Model m) {
        List<Long> cartIds = Arrays.asList(check);
        String userid = (String) session.getAttribute("login");
        CartsAndMemberDTO order = orderService.orderConfirmAll(cartIds, userid);
        List<CartDTO> carts = order.getCarts();
        int totalPrice = 0;
        for (CartDTO cart : carts) {
            totalPrice += cart.getGprice() * cart.getGamount();
        }
        session.setAttribute("carts", carts);
        m.addAttribute("order", order);
        m.addAttribute("totalPrice", totalPrice);
        return "goods/orderConfirmAll";
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

    @GetMapping("/ordersDone")
    public String ordersDone(String userid, String username, String ordername, String post, String addr1, String addr2, String phone, String paymethod, int totalPrice, HttpSession session, Model m) {
        OrdererDTO order = OrdererDTO.builder()
                .userid(userid)
                .username(username)
                .ordername(ordername)
                .post(post)
                .addr1(addr1)
                .addr2(addr2)
                .phone(phone)
                .paymethod(paymethod)
                .build();

        List<CartDTO> carts = (List<CartDTO>) session.getAttribute("carts");

        orderService.orderDoneAll(carts, order);
        orderService.deleteCarts(carts);

        m.addAttribute("carts", carts);
        m.addAttribute("order", order);
        m.addAttribute("totalPrice", totalPrice);
        return "goods/orderDoneAll";
    }


}
