package com.dasnnj.practice.weixinsell.utils;

import com.dasnnj.practice.weixinsell.enums.CodeEnum;

/**
 * Description <P> DO : 枚举值工具 <P>
 *
 * @author DASNNJ  <a href="mailto:dasnnj@outlook.com"> dasnnj@outlook.com </a>
 * @date 2019-06-11 23:02
 */
public class EnumUtil {
    public static <T extends CodeEnum> T getByCode(Integer code, Class<T> enumClass) {
        for (T each: enumClass.getEnumConstants()) {
            if (code.equals(each.getCode())) {
                return each;
            }
        }
        return null;
    }
}
