package com.shop.miniShoppingMall.service;

import com.shop.miniShoppingMall.dto.GoodsDTO;
import com.shop.miniShoppingMall.model.GoodsEntity;
import com.shop.miniShoppingMall.repository.GoodsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class GoodsService {
    private final GoodsRepository goodsRepository;

    public List<GoodsDTO> findGoodsByCateogory(String gcategory) {
        List<GoodsEntity> goods = goodsRepository.findByGcategory(gcategory);
        return goods.stream().map((good) -> GoodsDTO.builder()
                .gcode(good.getGcode())
                .gcategory(good.getGcategory())
                .gname(good.getGname())
                .gcontent(good.getGcontent())
                .gprice(good.getGprice())
                .gimage(good.getGimage())
                .build()).toList();
    }

    public GoodsDTO findGoodsByCode(String gcode) {
        GoodsEntity good = goodsRepository.findById(gcode).orElseThrow();

        return GoodsDTO.builder()
                .gcode(good.getGcode())
                .gcategory(good.getGcategory())
                .gname(good.getGname())
                .gcontent(good.getGcontent())
                .gprice(good.getGprice())
                .gimage(good.getGimage())
                .build();
    }
}
