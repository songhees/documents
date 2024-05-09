package com.zerock.mallapi.domain;

import jakarta.persistence.*;
import lombok.*;

@Getter
@ToString(exclude = "owner")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "tb_cart", indexes = { @Index(name="idx_cart_email", columnList = "member_owner")})
@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cno;

    @OneToOne
    @JoinColumn(name = "member_owner")
    private Member owner;
}
