package com.zerock.mallapi.repository;

import com.zerock.mallapi.domain.CartItem;
import com.zerock.mallapi.dto.CartItemListDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {


    @Query( "select new com.zerock.mallapi.dto.CartItemListDTO(cartItem.cino, cartItem.qty, product.pno, product.pname, product.price, image.fileName) " +
            "from CartItem cartItem inner join cartItem.cart cart " +
            "left join cartItem.product product " +
            "left join product.imageList image " +
            "where cart.owner.email=:email " +
            "and image.ord=0 " +
            "order by cartItem.cino desc " )
    public List<CartItemListDTO> getCartItemListDTOByEmail(@Param("email") String email);

    @Query( "select cartItem " +
            "from CartItem cartItem inner join cartItem.cart cart " +
            "where cart.owner.email=:email " +
            "and cartItem.product.pno=:pno ")
    public CartItem getCartItemByEmailAndProuct(@Param("email") String email, @Param("pno") Long pno);

    @Query("select cart.cno " +
            "from CartItem cartItem inner join cartItem.cart cart " +
            "where cartItem.cino=:cino ")
    public Long getCartNo(@Param("cino")Long cino);

    @Query("select new com.zerock.mallapi.dto.CartItemListDTO(cartItem.cino, cartItem.qty, product.pno, product.pname, product.price, image.fileName) " +
            "from CartItem cartItem inner join cartItem.cart cart " +
            "left join cartItem.product product " +
            "left join product.imageList image " +
            "where cart.cno=:cno " +
            "and image.ord=0 " +
            "order by cartItem.cino desc " )
    public List<CartItemListDTO> getCartItemListDTOByCart(@Param("cno") Long cno);
}
