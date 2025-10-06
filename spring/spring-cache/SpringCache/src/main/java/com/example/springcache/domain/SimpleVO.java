package com.example.springcache.domain;

import lombok.*;

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SimpleVO {
    private int id;
    private String url;
    private String role;
    private String title;
    private String validation;
}
