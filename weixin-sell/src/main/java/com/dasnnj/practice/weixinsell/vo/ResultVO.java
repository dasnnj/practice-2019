package com.dasnnj.practice.weixinsell.vo;

import lombok.Data;

/**
 * Description <P> DO : http返回结果对象 <P>
 *
 * @author DASNNJ  <a href="mailto:dasnnj@outlook.com"> dasnnj@outlook.com </a>
 * @date 2019-06-16 21:32
 */
@Data
public class ResultVO<T> {

    /**
     * 返回码
     */
    private Integer code;
    /**
     * 提示信息
     */
    private String msg;
    /**
     * 返回内容
     */
    private T data;
}
