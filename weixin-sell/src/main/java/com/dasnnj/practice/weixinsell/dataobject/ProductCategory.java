package com.dasnnj.practice.weixinsell.dataobject;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Description <P> DO : 商品类目 <P>
 *
 * @author DASNNJ <a href="mailto:dasnnj@outlook.com"> dasnnj@outlook.com </a>
 * @date 2019 -05-13 21:55
 */
@Entity
@Getter
@Setter
@ToString
public class ProductCategory {
    /**
     * The Category id.
     */
    @Id
    @GeneratedValue
    private Integer categoryId;
    /**
     * The Category name.
     */
    private String categoryName;
    /**
     * The Category type.
     */
    private Integer categoryType;
}
