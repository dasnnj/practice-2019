package com.dasnnj.practice.weixinsell.service;

import com.dasnnj.practice.weixinsell.dataobject.ProductInfo;
import com.dasnnj.practice.weixinsell.enums.ProductStatusEnum;
import com.dasnnj.practice.weixinsell.repository.ProductInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description <P> DO : 商品信息service <P>
 *
 * @author DASNNJ  <a href="mailto:dasnnj@outlook.com"> dasnnj@outlook.com </a>
 * @date 2019-06-13 21:56
 */
@Service
public class ProductInfoService implements IProductInfoService {
    @Autowired
    private ProductInfoRepository repository;
    @Override
    public ProductInfo findOne(String productId) {
        return repository.findById(productId).orElse(null);
    }

    /**
     * Description <p> DO :  获取上架的商品信息</p>
     *
     * @param
     * @return java.util.List<com.dasnnj.practice.weixinsell.dataobject.ProductInfo>
     *
     * @author dasnnj
     * @date 2019-06-13 10:02
     */
    @Override
    public List<ProductInfo> findUpAll() {
        return repository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public List<ProductInfo> findAll() {
        return repository.findAll();
    }

    @Override
    public Page<ProductInfo> findList(Pageable pageable) {
        return repository.findAll(pageable);
    }
}
