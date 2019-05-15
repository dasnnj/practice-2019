package com.dasnnj.practice.weixinsell.dataobject;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

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
@DynamicUpdate
@DynamicInsert
public class ProductCategory {
    /**
     * The Category id.
     * strategy很重要，否则hibernate不知道你的策略，然后用错策略，然后报错-_-
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;
    /**
     * The Category name.
     */
    private String categoryName;
    /**
     * The Category type.
     */
    private Integer categoryType;

    /**
     * The Create time.
     */
    private Date createTime;

    /**
     * The Update time.
     * 由于一些操作会将记录先查出来，在更新，那个时候updateTime还是更新为查出来的时候的，
     * 并没有按照原本数据库设置的currentTime变化，这个时候就需要@DynamicUpdate 放在对象上
     */
    private Date updateTime;
}
