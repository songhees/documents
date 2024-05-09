package com.zerock.mallapi.service;

import com.zerock.mallapi.dto.CartItemDTO;
import com.zerock.mallapi.dto.CartItemListDTO;
import jakarta.transaction.Transactional;

import java.util.List;

public interface CartService {

    List<CartItemListDTO> addOrModify(CartItemDTO cartItemDTO);

    List<CartItemListDTO> getCartItem(String email);

    List<CartItemListDTO> remove(Long cino);
}
