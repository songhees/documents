package com.zerock.mallapi.domain;

import jakarta.persistence.*;
import lombok.*;

@Getter
@ToString(exclude = "cart")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "tb_cart_item", indexes = {
            @Index(name="idx_cartitem_cart", columnList = "cart_cno"),
            @Index(name="idx_cartitem_pno_cart", columnList = "product_pno, cart_cno")
        })
@Entity
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cino;

    @ManyToOne
    @JoinColumn(name="product_pno")
    private Product product;

    @ManyToOne
    @JoinColumn(name="cart_cno")
    private Cart cart;

    private int qty;

    public void changeQty(int qty) {
        this.qty = qty;
    }
}
