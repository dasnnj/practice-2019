package com.dasnnj.practice.weixinsell.enums;

import lombok.Getter;

/**
 * Description <P> DO : 订单状态 <P>
 *
 * @author DASNNJ <a href="mailto:dasnnj@outlook.com"> dasnnj@outlook.com </a>
 * @date 2019 -06-21 22:38
 */
@Getter
public enum OrderStatusEnum {
    /**
     * New order status enum.
     */
    NEW(0, "新订单"),
    /**
     * Finished order status enum.
     */
    FINISHED(1, "完结"),
    /**
     * Cancel order status enum.
     */
    CANCEL(2, "已取消"),
    ;

    private Integer code;

    private String message;

    OrderStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
