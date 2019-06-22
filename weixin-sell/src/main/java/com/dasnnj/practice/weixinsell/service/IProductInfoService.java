package com.dasnnj.practice.weixinsell.service;

import com.dasnnj.practice.weixinsell.dataobject.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Description <P> DO : 商品信息service <P>
 *
 * @author DASNNJ  <a href="mailto:dasnnj@outlook.com"> dasnnj@outlook.com </a>
 * @date 2019-06-13 21:45
 */
public interface IProductInfoService {
    ProductInfo findOne(String productId);

    List<ProductInfo> findUpAll();

    List<ProductInfo> findAll();

    Page<ProductInfo> findList(Pageable pageable);

    //加库存

    //减库存
}
