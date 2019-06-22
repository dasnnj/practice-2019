package com.dasnnj.practice.weixinsell.service;

import com.dasnnj.practice.weixinsell.dataobject.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Description <P> DO :  <P>
 *
 * @author DASNNJ  <a href="mailto:dasnnj@outlook.com"> dasnnj@outlook.com </a>
 * @date 2019-06-13 22:02
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoServiceTest {

    @Autowired
    private ProductInfoService service;
    @Test
    public void findOne() {
        ProductInfo p = service.findOne("2");
        Assert.assertNotNull(p);
    }

    @Test
    public void findUpAll() {
        List l = service.findUpAll();
        Assert.assertNotNull(l);
    }

    @Test
    public void findAll() {
        List<ProductInfo> infos = service.findAll();
        Assert.assertEquals(6, infos.size());
    }

    @Test
    public void findList() {
        Pageable p = PageRequest.of(0, 5);
        Page<ProductInfo> list = service.findList(p);
        Assert.assertEquals(5, list.getSize());
    }
}