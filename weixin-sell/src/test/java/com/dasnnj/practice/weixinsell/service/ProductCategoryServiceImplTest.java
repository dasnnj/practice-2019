package com.dasnnj.practice.weixinsell.service;

import com.dasnnj.practice.weixinsell.dataobject.ProductCategory;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

/**
 * Description <P> DO :  <P>
 *
 * @author DASNNJ <a href="mailto:dasnnj@outlook.com"> dasnnj@outlook.com </a>
 * @date 2019 -05-15 21:35
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryServiceImplTest {

    /**
     * The Product category service.
     */
    @Autowired
    private IProductCategoryService productCategoryService;

    /**
     * Gets one.
     */
    @Test
    public void getOne() {
        ProductCategory productCategory = productCategoryService.getOne(1);
        Assert.assertTrue(productCategory != null && productCategory.getCategoryId() == 1);
    }

    /**
     * Find all.
     */
    @Test
    public void findAll() {
        List<ProductCategory> list = productCategoryService.findAll();
        Assert.assertTrue(list != null && list.size() > 0);
    }

    /**
     * Gets product categories by category type in.
     */
    @Test
    public void getProductCategoriesByCategoryTypeIn() {
        List<ProductCategory> list = productCategoryService.getProductCategoriesByCategoryTypeIn(Arrays.asList(1, 2, 3));
        Assert.assertTrue(list != null && list.size() > 0);
    }

    /**
     * Save. 此方法当为新增的时候，没有set createTime 和 updateTime，会报错，数据库这两个字段不能为空
     * 在{@link ProductCategory} 中 添加{@link DynamicInsert} 注解 ，则不会将空值插入数据库，这时候数据库对这两个字段设置的currentTimeStamp 配置生效
     * {@link DynamicUpdate} 同理
     */
    @Test
    public void save() {
        ProductCategory saveObj = new ProductCategory();
        saveObj.setCategoryType(6);
        saveObj.setCategoryName("name3");
        ProductCategory productCategory = productCategoryService.save(saveObj);
        Assert.assertNotNull(productCategory);
    }
}