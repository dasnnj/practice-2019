package com.dasnnj.practice.weixinsell.service;

import com.dasnnj.practice.weixinsell.dataobject.ProductCategory;
import com.dasnnj.practice.weixinsell.repository.ProductCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description <P> DO : 商品类目service实现 <P>
 *
 * @author DASNNJ <a href="mailto:dasnnj@outlook.com"> dasnnj@outlook.com </a>
 * @date 2019 -05-15 21:27
 */
@Service("productCategoryService")
public class ProductCategoryServiceImpl implements IProductCategoryService {

    /**
     * The Repository.
     */
    @Autowired
    private ProductCategoryRepository repository;

    /**
     * Gets one.
     *
     * @param categoryId the category id
     * @return the one
     */
    @Override
    public ProductCategory getOne(Integer categoryId) {
        return repository.getOne(categoryId);
    }

    /**
     * Find all list.
     *
     * @return the list
     */
    @Override
    public List<ProductCategory> findAll() {
        return repository.findAll();
    }

    /**
     * Gets product categories by category type in.
     *
     * @param types the types
     * @return the product categories by category type in
     */
    @Override
    public List<ProductCategory> getProductCategoriesByCategoryTypeIn(List<Integer> types) {
        return repository.getProductCategoriesByCategoryTypeIn(types);
    }

    /**
     * Save product category.
     *
     * @param productCategory the product category
     * @return the product category
     */
    @Override
    public ProductCategory save(ProductCategory productCategory) {
        return repository.save(productCategory);
    }
}
