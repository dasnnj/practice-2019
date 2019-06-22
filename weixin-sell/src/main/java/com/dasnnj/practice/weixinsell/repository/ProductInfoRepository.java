package com.dasnnj.practice.weixinsell.repository;

import com.dasnnj.practice.weixinsell.dataobject.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Description <P> DO : 商品信息DAO <P>
 *
 * @author DASNNJ  <a href="mailto:dasnnj@outlook.com"> dasnnj@outlook.com </a>
 * @date 2019-06-11 23:06
 */
public interface ProductInfoRepository extends JpaRepository<ProductInfo, String> {

    /**
     * Description <p> DO :  获取上架的商品信息</p>
     *
     * @param     status
     * @return java.util.List
     *
     * @author dasnnj
     * @date 2019-06-11 11:09
     */
    List<ProductInfo> findByProductStatus(Integer status);
}
