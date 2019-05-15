package com.dasnnj.practice.weixinsell.repository;

import com.dasnnj.practice.weixinsell.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Description <P> DO :  商品类目接口测试<P>
 *
 * @author DASNNJ  <a href="mailto:dasnnj@outlook.com"> dasnnj@outlook.com </a>
 * @date 2019-05-13 22:01
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {
    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Test
    public void findOneTest() {
        //https://stackoverflow.com/questions/4423026/about-error-using-java-generics-type-parameter-s-is-not-within-its-bound
        System.out.println(productCategoryRepository.findById(1).orElse(new ProductCategory()));
    }

    @Test
    public void saveTest() {
        ProductCategory p = new ProductCategory();
        p.setCategoryName("name2");
        p.setCategoryType(2);
        Assert.assertNotNull(productCategoryRepository.save(p).getCategoryId());
    }

    @Test
    public void updateTest() {
        ProductCategory p = new ProductCategory();
        p.setCategoryId(3);
        p.setCategoryName("update name2");
        p.setCategoryType(3);
        //更新
        productCategoryRepository.save(p);

        Assert.assertEquals("update name2", productCategoryRepository.findById(2).orElse(new ProductCategory()).getCategoryName());
    }

    /**
     * 更新 ,如果{@link ProductCategory}对象上面不加@DynamicUpdate注解，
     * 此时updateTime不会更新为当前最新时间
     *
     * @date 2019-05-14 19:23
     */
    @Test
    public void update2Test() {
        ProductCategory p = productCategoryRepository.findById(2).orElse(new ProductCategory());
        p.setCategoryType(7);
        productCategoryRepository.save(p);
    }

    /**
     * 这边的Transactional注解不同于service中的，这边是测试完成，完全回滚不造成脏数据
     *
     * @date 2019-05-14 19:47
     */
    @Test
    @Transactional
    public void save2Test() {
        ProductCategory p = new ProductCategory();
        p.setCategoryType(3);
        p.setCategoryName("name3");
        Date d = new Date();
        p.setCreateTime(d);
        p.setUpdateTime(d);
        ProductCategory res = productCategoryRepository.save(p);
        Assert.assertNotNull(res);
        System.out.println(res);
    }

    @Test
    public void getProductCategoriesByCategoryTypeInTest() {
        List<Integer> l = Arrays.asList(1, 2, 3, 4);
        List res = productCategoryRepository.getProductCategoriesByCategoryTypeIn(l);
        Assert.assertTrue(res.size() > 0);
    }
}