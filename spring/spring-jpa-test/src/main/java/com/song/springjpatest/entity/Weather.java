package com.song.springjpatest.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@ToString
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "tb_weather")
@Entity
public class Weather {

    @EmbeddedId
    private WeatherId weatherId;

    private BigDecimal temperature;

    @Enumerated(EnumType.STRING)
    private QcFlag qcFlag;
}
