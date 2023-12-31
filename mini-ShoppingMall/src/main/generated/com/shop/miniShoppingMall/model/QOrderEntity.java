package com.shop.miniShoppingMall.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QOrderEntity is a Querydsl query type for OrderEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QOrderEntity extends EntityPathBase<OrderEntity> {

    private static final long serialVersionUID = -1890407332L;

    public static final QOrderEntity orderEntity = new QOrderEntity("orderEntity");

    public final StringPath addr = createString("addr");

    public final NumberPath<Integer> gamount = createNumber("gamount", Integer.class);

    public final StringPath gcode = createString("gcode");

    public final StringPath gcolor = createString("gcolor");

    public final StringPath gimage = createString("gimage");

    public final StringPath gname = createString("gname");

    public final NumberPath<Integer> gprice = createNumber("gprice", Integer.class);

    public final StringPath gsize = createString("gsize");

    public final StringPath merchant_uid = createString("merchant_uid");

    public final StringPath orderDay = createString("orderDay");

    public final StringPath phone = createString("phone");

    public final StringPath post = createString("post");

    public final StringPath recipient = createString("recipient");

    public final StringPath userid = createString("userid");

    public QOrderEntity(String variable) {
        super(OrderEntity.class, forVariable(variable));
    }

    public QOrderEntity(Path<? extends OrderEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QOrderEntity(PathMetadata metadata) {
        super(OrderEntity.class, metadata);
    }

}

