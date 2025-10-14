package com.song.springjpatest.entity;

import jakarta.persistence.*;
import lombok.*;

@ToString
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

    private Integer count;
}
