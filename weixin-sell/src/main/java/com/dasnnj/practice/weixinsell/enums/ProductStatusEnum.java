package com.dasnnj.practice.weixinsell.enums;

import lombok.Getter;

/**
 * Description <P> DO : 商品状态 <P>
 *
 * @author DASNNJ  <a href="mailto:dasnnj@outlook.com"> dasnnj@outlook.com </a>
 * @date 2019-06-11 22:59
 */
@Getter
public enum ProductStatusEnum implements CodeEnum{
    UP(0, "在架"),
    DOWN(1, "下架");

    private Integer code;

    private String message;

    ProductStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
