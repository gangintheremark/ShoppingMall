package com.shop.miniShoppingMall.controller;

import com.shop.miniShoppingMall.dto.GoodsDTO;
import com.shop.miniShoppingMall.service.GoodsService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class MainController {

    private final GoodsService goodsService;
    @RequestMapping("/main")
    public String goMain(@RequestParam(value = "gCategory", required = false, defaultValue = "top") String gcategory, Model m, HttpSession session) {
        List<GoodsDTO> goodsList = goodsService.findGoodsByCateogory(gcategory);
        m.addAttribute("goodsList", goodsList);

        return "main";
    }
}
