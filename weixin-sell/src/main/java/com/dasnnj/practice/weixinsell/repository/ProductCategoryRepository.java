package com.dasnnj.practice.weixinsell.repository;

import com.dasnnj.practice.weixinsell.dataobject.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Description <P> DO : 商品类目DAO接口 <P>
 *
 * @author DASNNJ  <a href="mailto:dasnnj@outlook.com"> dasnnj@outlook.com </a>
 * @date 2019-05-13 21:58
 */
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {

}
