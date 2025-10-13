package com.song.springjpatest.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

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
