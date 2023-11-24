package com.shop.miniShoppingMall.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QCartEntity is a Querydsl query type for CartEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCartEntity extends EntityPathBase<CartEntity> {

    private static final long serialVersionUID = -757969352L;

    public static final QCartEntity cartEntity = new QCartEntity("cartEntity");

    public final NumberPath<Long> cartid = createNumber("cartid", Long.class);

    public final NumberPath<Integer> gamount = createNumber("gamount", Integer.class);

    public final StringPath gcode = createString("gcode");

    public final StringPath gcolor = createString("gcolor");

    public final StringPath gimage = createString("gimage");

    public final StringPath gname = createString("gname");

    public final NumberPath<Integer> gprice = createNumber("gprice", Integer.class);

    public final StringPath gsize = createString("gsize");

    public final StringPath userid = createString("userid");

    public QCartEntity(String variable) {
        super(CartEntity.class, forVariable(variable));
    }

    public QCartEntity(Path<? extends CartEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCartEntity(PathMetadata metadata) {
        super(CartEntity.class, metadata);
    }

}

