package com.zerock.mallapi.dto;

import lombok.Data;

@Data
public class CartItemDTO {
    private String email;
    private Long pno;
    private Long cino;
    private int qty;
}
