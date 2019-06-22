package com.dasnnj.practice.weixinsell.repository;

import com.dasnnj.practice.weixinsell.dataobject.ProductInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

/**
 * Description <P> DO :  <P>
 *
 * @author DASNNJ  <a href="mailto:dasnnj@outlook.com"> dasnnj@outlook.com </a>
 * @date 2019-06-12 21:36
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class ProductInfoRepositoryTest {
    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Test
    public void saveTest() {
        ProductInfo p = new ProductInfo();
        p.setCategoryType(1);
        p.setProductDescription("type6");
        p.setProductId("6");
        p.setProductName("name6");
        p.setProductPrice(new BigDecimal("10.25"));
        p.setProductStatus(1);
        p.setProductStock(998);
        p = productInfoRepository.save(p);
        System.out.println(p);
//        log.info(p.getUpdateTime().toString());
    }
    @Test
    public void update() {
        ProductInfo p = productInfoRepository.findById("6").orElse(new ProductInfo());
        p.setProductDescription("type6");
        p.setProductId("6");
        p.setProductName("name6");
        productInfoRepository.save(p);
//        log.info(p.getCreateTime().toString());
    }
    @Test
    public void findByProductStatusTest() {

        List<ProductInfo> list = productInfoRepository.findByProductStatus(1);
        log.info(Arrays.toString(list.toArray()));
    }

    @Test
    public void findAll(){
        List<ProductInfo> all = productInfoRepository.findAll();
        for (ProductInfo productInfo : all) {
            System.out.println(productInfo);
        }

    }
}