package com.song.springjpatest.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.BatchSize;

import java.util.HashSet;
import java.util.Set;

@ToString(exclude = "weathers")
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

    @Builder.Default
    @OneToMany(mappedBy = "weatherId.region")
    @BatchSize(size = 10)
    private Set<Weather> weathers = new HashSet<>();

    public Region(Long id, String name, Integer count) {
        this.id = id;
        this.name = name;
        this.count = count;
    }
}
