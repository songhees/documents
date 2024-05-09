package com.zerock.mallapi.controller;

import com.zerock.mallapi.dto.CartItemDTO;
import com.zerock.mallapi.dto.CartItemListDTO;
import com.zerock.mallapi.service.CartService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/cart")
@RestController
public class CartController {

    private final CartService service;

    @PreAuthorize("#cartItemDTO.email == authentication.name")
    @PostMapping("/change")
    public List<CartItemListDTO> changeCart(@RequestBody CartItemDTO cartItemDTO) {
        if (cartItemDTO.getQty() <= 0) {
            return service.remove(cartItemDTO.getCino());
        }

        return service.addOrModify(cartItemDTO);
    }

    @PreAuthorize("hasAnyRole('ROLE_USER')")
    @GetMapping("/items")
    public List<CartItemListDTO> getCartItems(Principal principal) {
        return service.getCartItem(principal.getName());
    }

    @PreAuthorize("hasAnyRole('ROLE_USER')")
    @DeleteMapping("/{cino}")
    public List<CartItemListDTO> removeFromCart(@PathVariable("cino") Long cino) {
        return service.remove(cino);
    }
}
