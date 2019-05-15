package com.dasnnj.practice.weixinsell.repository;

import com.dasnnj.practice.weixinsell.dataobject.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Description <P> DO : 商品类目DAO接口 <P>
 *
 * @author DASNNJ <a href="mailto:dasnnj@outlook.com"> dasnnj@outlook.com </a>
 * @date 2019 -05-13 21:58
 */
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {
    /**
     * Description <p> TDO :  根据类型categoryType查找</p>
     *
     * @param types the types
     * @return java.util.List<com.dasnnj.practice.weixinsell.dataobject.ProductCategory> product categories by category type in
     *
     * @author dasnnj
     * @date 2019 -05-15 09:24
     */
    List<ProductCategory> getProductCategoriesByCategoryTypeIn(List<Integer> types);
}
