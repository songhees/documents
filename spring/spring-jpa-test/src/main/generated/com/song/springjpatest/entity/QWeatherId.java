package com.song.springjpatest.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.dsl.StringTemplate;

import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.annotations.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QWeatherId is a Querydsl query type for WeatherId
 */
@SuppressWarnings("this-escape")
@Generated("com.querydsl.codegen.DefaultEmbeddableSerializer")
public class QWeatherId extends BeanPath<WeatherId> {

    private static final long serialVersionUID = 824471998L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QWeatherId weatherId = new QWeatherId("weatherId");

    public final QRegion region;

    public final DateTimePath<java.time.LocalDateTime> time = createDateTime("time", java.time.LocalDateTime.class);

    public QWeatherId(String variable) {
        this(WeatherId.class, forVariable(variable), INITS);
    }

    public QWeatherId(Path<WeatherId> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QWeatherId(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QWeatherId(PathMetadata metadata, PathInits inits) {
        this(WeatherId.class, metadata, inits);
    }

    public QWeatherId(Class<? extends WeatherId> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.region = inits.isInitialized("region") ? new QRegion(forProperty("region")) : null;
    }

}

