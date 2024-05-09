package com.zerock.mallapi.service;

import com.zerock.mallapi.domain.Cart;
import com.zerock.mallapi.domain.CartItem;
import com.zerock.mallapi.domain.Member;
import com.zerock.mallapi.domain.Product;
import com.zerock.mallapi.dto.CartItemDTO;
import com.zerock.mallapi.dto.CartItemListDTO;
import com.zerock.mallapi.repository.CartItemRepository;
import com.zerock.mallapi.repository.CartRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@Transactional
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {
    private final CartRepository repository;
    private final CartItemRepository itemRepository;

    @Override
    public List<CartItemListDTO> addOrModify(CartItemDTO cartItemDTO) {
        String email = cartItemDTO.getEmail();
        Long pno = cartItemDTO.getPno();
        int qty = cartItemDTO.getQty();
        // 이미 있는 장바구니 아이템
        if (cartItemDTO.getCino() != null) {
            Optional<CartItem> result = itemRepository.findById(cartItemDTO.getCino());
            CartItem cartItem = result.orElseThrow();
            cartItem.changeQty(cartItemDTO.getQty());

            itemRepository.save(cartItem);
            return getCartItem(email);
        }

        Cart cart = getCart(email);
        CartItem cartItem = itemRepository.getCartItemByEmailAndProuct(email, pno);

        if (cartItem == null) {
            cartItem = CartItem.builder()
                    .product(Product.builder().pno(pno).build())
                    .cart(cart)
                    .qty(qty)
                    .build();
        } else {
            cartItem.changeQty(qty);
        }

        itemRepository.save(cartItem);
        return getCartItem(email);
    }

    private Cart getCart(String email) {
        Cart cart;
        Optional<Cart> result = repository.getCartOfMember(email);

        if (result.isEmpty()) {
            Cart tempCart = Cart.builder().owner(Member.builder().email(email).build()).build();
            cart = repository.save(tempCart);
        } else {
            cart = result.orElseThrow();
        }

        return cart;
    }

    @Override
    public List<CartItemListDTO> getCartItem(String email) {
        return itemRepository.getCartItemListDTOByEmail(email);
    }

    @Override
    public List<CartItemListDTO> remove(Long cino) {
        Long cno = itemRepository.getCartNo(cino);
        itemRepository.deleteById(cino);
        return itemRepository.getCartItemListDTOByCart(cno);
    }
}
