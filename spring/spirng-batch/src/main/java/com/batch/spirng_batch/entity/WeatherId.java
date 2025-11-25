package com.batch.spirng_batch.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Embeddable
public record WeatherId(@JoinColumn(name = "region_id") @ManyToOne(fetch = FetchType.LAZY) Region region,
                        @Column LocalDateTime time) {}