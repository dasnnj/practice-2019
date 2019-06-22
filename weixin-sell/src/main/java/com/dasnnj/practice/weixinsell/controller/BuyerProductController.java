package com.dasnnj.practice.weixinsell.controller;

import com.dasnnj.practice.weixinsell.dataobject.ProductCategory;
import com.dasnnj.practice.weixinsell.dataobject.ProductInfo;
import com.dasnnj.practice.weixinsell.service.ProductCategoryServiceImpl;
import com.dasnnj.practice.weixinsell.service.ProductInfoService;
import com.dasnnj.practice.weixinsell.utils.ResultVOUtil;
import com.dasnnj.practice.weixinsell.vo.ProductInfoVO;
import com.dasnnj.practice.weixinsell.vo.ProductVO;
import com.dasnnj.practice.weixinsell.vo.ResultVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Description <P> DO : 买家商品 <P>
 *
 * @author DASNNJ  <a href="mailto:dasnnj@outlook.com"> dasnnj@outlook.com </a>
 * @date 2019-06-16 21:27
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Autowired
    private ProductInfoService productInfoService;
    @Autowired
    private ProductCategoryServiceImpl categoryService;

    @GetMapping("/result")
    public ResultVO testResultVo() {
        ResultVO<ProductVO> r = new ResultVO<>();
        ProductVO p = new ProductVO();
        ProductInfoVO p1 = new ProductInfoVO();
        p.setProductInfoVOList(Collections.singletonList(p1));
        r.setCode(0);
        r.setMsg("result");
        r.setData(p);
        return r;
    }

    @GetMapping("/list")
    public ResultVO list() {
        //1. 查询所有上架商品
        List<ProductInfo> upAll = productInfoService.findUpAll();
        //2. 查询商品所属的类目
        Set<Integer> categories = upAll.stream().map(ProductInfo::getCategoryType).collect(Collectors.toSet());
        List<ProductCategory> categoryList = categoryService.getProductCategoriesByCategoryTypeIn(categories);
        //3. 拼装对象
        List<ProductVO> returns = new ArrayList<>();
        ProductVO vo;
        ProductInfoVO productInfoVO;
        List<ProductInfoVO> productInfoVOList;
        for (ProductCategory productCategory : categoryList) {
            if(productCategory == null ) continue;
            vo = new ProductVO();
            vo.setCategoryName(productCategory.getCategoryName());
            vo.setCategoryType(productCategory.getCategoryType());
            productInfoVOList = new ArrayList<>();
            for (ProductInfo productInfo : upAll) {
                if(productInfo == null) continue;
                if(Objects.equals(productCategory.getCategoryType(), productInfo.getCategoryType())){
                    productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo, productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }

            vo.setProductInfoVOList(productInfoVOList);
            returns.add(vo);
        }
        //4. 返回
        return ResultVOUtil.success(returns);
    }
}
