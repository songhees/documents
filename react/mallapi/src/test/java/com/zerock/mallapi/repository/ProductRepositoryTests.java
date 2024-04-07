package com.zerock.mallapi.repository;

import com.zerock.mallapi.domain.Product;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Optional;
import java.util.UUID;

@SpringBootTest
@Slf4j
public class ProductRepositoryTests {

    @Autowired
    private ProductRepository repository;

    @Test
    public void testInsert() {
        for (int i = 0; i < 10; i++) {
            Product product = Product.builder()
                    .pname("상품"+i)
                    .price(100*i)
                    .pdesc("상품설명 " + i)
                    .build();

            //2개의 이미지 파일 추가
            product.addImageString("IMAGE1.jpg");
            product.addImageString("IMAGE2.jpg");

            repository.save(product);

            log.info("-------------------");
        }
    }

    @Transactional
    @Test
    public void testRead() {

        Long pno = 1L;

        Optional<Product> result = repository.findById(pno);

        Product product = result.orElseThrow();

        log.info(product.toString()); // --------- 1
        log.info(product.getImageList().toString()); // ---------------------2

    }

    @Test
    public void testRead2() {

        Long pno = 1L;

        Optional<Product> result = repository.selectOne(pno);

        Product product = result.orElseThrow();

        log.info(product.toString());
        log.info(product.getImageList().toString());

    }

    @Commit
    @Transactional
    @Test
    public void testDelte() {

        Long pno = 2L;

        repository.updateToDelete(pno, true);

    }

    @Test
    public void testUpdate(){

        Long pno = 10L;

        Product product = repository.selectOne(pno).get();

        product.changeName("10번 상품");
        product.changeDesc("10번 상품 설명입니다.");
        product.changePrice(5000);

        //첨부파일 수정
        product.clearList();

        product.addImageString(UUID.randomUUID().toString()+"_"+"NEWIMAGE1.jpg");
        product.addImageString(UUID.randomUUID().toString()+"_"+"NEWIMAGE2.jpg");
        product.addImageString(UUID.randomUUID().toString()+"_"+"NEWIMAGE3.jpg");

        repository.save(product);

    }

    @Test
    public void testList() {

        //org.springframework.data.domain 패키지
        Pageable pageable = PageRequest.of(0, 10, Sort.by("pno").descending());

        Page<Object[]> result = repository.selectList(pageable);

        //java.util
        result.getContent().forEach(arr -> log.info(Arrays.toString(arr)));

    }

    @Test
    public void testList2() {

        //org.springframework.data.domain 패키지
        Pageable pageable = PageRequest.of(0, 10, Sort.by("pno").descending());

        Page<Object[]> result = repository.selectList2(pageable);

        //java.util
        result.getContent().forEach(arr -> log.info(Arrays.toString(arr)));

    }

    @Transactional
    @Test
    public void testListWithAll() {

        //org.springframework.data.domain 패키지
        Pageable pageable = PageRequest.of(0, 10, Sort.by("pno").descending());

        Page<Product> result = repository.selectListWitAll(pageable);

        //java.util
        result.getContent().forEach(product ->{

            log.info(product.toString());
            log.info(product.getImageList().toString());

        });

    }
}
