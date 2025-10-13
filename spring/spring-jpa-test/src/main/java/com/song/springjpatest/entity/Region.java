package com.song.springjpatest.entity;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "tb_region")
@Entity
public class Region {

    @Id
    private Long id;

    private String name;

    @Version
    private Long version;

    @Column(nullable = true)
    private int count;
}
