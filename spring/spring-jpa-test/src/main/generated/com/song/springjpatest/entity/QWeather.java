package com.song.springjpatest.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.dsl.StringTemplate;

import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.annotations.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QWeather is a Querydsl query type for Weather
 */
@SuppressWarnings("this-escape")
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QWeather extends EntityPathBase<Weather> {

    private static final long serialVersionUID = 219852099L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QWeather weather = new QWeather("weather");

    public final EnumPath<QcFlag> qcFlag = createEnum("qcFlag", QcFlag.class);

    public final NumberPath<java.math.BigDecimal> temperature = createNumber("temperature", java.math.BigDecimal.class);

    public final QWeatherId weatherId;

    public QWeather(String variable) {
        this(Weather.class, forVariable(variable), INITS);
    }

    public QWeather(Path<? extends Weather> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QWeather(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QWeather(PathMetadata metadata, PathInits inits) {
        this(Weather.class, metadata, inits);
    }

    public QWeather(Class<? extends Weather> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.weatherId = inits.isInitialized("weatherId") ? new QWeatherId(forProperty("weatherId"), inits.get("weatherId")) : null;
    }

}

