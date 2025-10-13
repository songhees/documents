package com.song.springjpatest.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;

@Embeddable
record WeatherId(@JoinColumn(name = "region_id") @ManyToOne Region region,
                 @Column LocalDateTime time) {}