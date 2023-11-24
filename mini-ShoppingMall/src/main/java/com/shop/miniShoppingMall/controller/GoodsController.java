package com.shop.miniShoppingMall.controller;

import com.shop.miniShoppingMall.dto.GoodsDTO;
import com.shop.miniShoppingMall.service.GoodsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequiredArgsConstructor
@Controller
public class GoodsController {
    private final GoodsService goodsService;

    @GetMapping("/goodsRetrieve")
    public String goodsRetrieve(@RequestParam String gcode, Model m) {
        GoodsDTO good = goodsService.findGoodsByCode(gcode);
        m.addAttribute("good", good);
        return "goods/goodsRetrieve";
    }
}
