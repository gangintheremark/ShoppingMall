package com.shop.miniShoppingMall.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QGoodsEntity is a Querydsl query type for GoodsEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QGoodsEntity extends EntityPathBase<GoodsEntity> {

    private static final long serialVersionUID = 927372900L;

    public static final QGoodsEntity goodsEntity = new QGoodsEntity("goodsEntity");

    public final StringPath gcategory = createString("gcategory");

    public final StringPath gcode = createString("gcode");

    public final StringPath gcontent = createString("gcontent");

    public final StringPath gimage = createString("gimage");

    public final StringPath gname = createString("gname");

    public final NumberPath<Integer> gprice = createNumber("gprice", Integer.class);

    public QGoodsEntity(String variable) {
        super(GoodsEntity.class, forVariable(variable));
    }

    public QGoodsEntity(Path<? extends GoodsEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QGoodsEntity(PathMetadata metadata) {
        super(GoodsEntity.class, metadata);
    }

}

