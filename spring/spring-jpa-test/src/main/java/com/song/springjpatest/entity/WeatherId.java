package com.song.springjpatest.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Embeddable
public record WeatherId(@JoinColumn(name = "region_id") @ManyToOne(fetch = FetchType.LAZY) Region region,
                        @Column LocalDateTime time) {}