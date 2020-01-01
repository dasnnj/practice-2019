package com.dasnnj.practice.medium;

/**
 * Description <P> DO : Z字形排列字符串 <P>
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * <p>
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 * <p>
 * L   C   I   R<br>
 * E T O E S I I GR<br>
 * E   D   H   N<br>
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zigzag-conversion
 *
 * @author DASNNJ
 * @date 2020-01-01 17:52
 */
public class ZigZagConversion {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        char[] arr = s.toCharArray();
        int endIndex = arr.length;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            //若行数超过字符串长度了，就该退出
            if (i >= endIndex) {
                return sb.toString();
            }
            //第一行的字符串
            sb.append(arr[i]);
            int index = i;
            int splitNum;
            //第一行或最后一行时
            if (i == 0 || i == (numRows - 1)) {
                //右边的数与当前间隔的索引的数值为 （总行数减去当前所在行）*2
                splitNum = (numRows - 1) * 2;
                while ((index = index + splitNum) < endIndex) {
                    sb.append(arr[index]);
                }
            } else {
                int j = 1;
                while (true) {
                    //为偶数 偶数与1相与 == 0
                    if ((1 & j) == 0) {
                        //当前位为第i+1行的 第奇偶数个数值时，右边的数值与当前间隔的索引的数值为 当前“行索引“*2
                        splitNum = i * 2;
                    } else {

                        // 当前为第i+1行的 第奇数个数值时，那么右边的数与当前间隔的索引的数值为 （总行数减去当前所在行）*2
                        splitNum = (numRows - i - 1) * 2;
                    }
                    if ((index += splitNum) < endIndex) {
                        sb.append(arr[index]);
                        j += 1;
                    } else {
                        break;
                    }
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        ZigZagConversion zigZagConversion = new ZigZagConversion();
        System.out.println(zigZagConversion.convert("a", 4));
    }
}
