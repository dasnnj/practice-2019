package com.dasnnj.practice.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Description <p> TODO:
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。</p>
 *
 * @author DASNNJ <a href="mailto:dasnnj@outlook.com.com"> dasnnj@outlook.com </a>
 * @date 2019-05-08 13:17
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters l = new LongestSubstringWithoutRepeatingCharacters();
        System.out.println(l.lengthOfLongestSubstring(""));
    }

    public int lengthOfLongestSubstring(String s) {
        //One
        /*char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>(8);
        //计算非重复字符的长度
        Integer len = 0;
        int max = 0;
        //索引
        Integer index;
        for (int i = 0; i < chars.length; i++) {
            //如果是正常进行
            //如果重复
            if ((index = map.get(chars[i])) != null) {
                //回退到重复的位置，从重复位置的下一位重新算，相当于舍弃两个重复字符中的第一个
                i = index;
                //长度归零
                len = 0;
                //将map中第一个重复的 去掉  -- 关键所在。不去掉的话再怎么回退每次走到backpoint都会再次发生重复
//                map.remove(chars[i]);
                map.clear();
            } else {
                //没重复当然正常put  正常++
                map.put(chars[i], i);
                len++;
            }
            //每次循环都保持max最大
            if (len > max) {
                max = len;
            }
        }
        return max;*/

        //Two
        /*while (j < chars.length && k < chars.length) {
            if ((ele = sets.get(chars[k])) != null) {
                if (j < ele + 1) {
                    j = ele + 1;
                }
            }
            sets.put(chars[k], k);
            k++;

            if (max < k - j) {
                max = k - j;
            }
        }*/
        //Three
        if ("".equals(s)) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int j = 0, k = 0, max = 0;
        Integer ele;
        Map<Character, Integer> sets = new HashMap<>(16);
        for (int m = 0; m < chars.length; m++) {
            if ((ele = sets.get(chars[m])) != null) {
                if (j < ele + 1) {
                    j = ele + 1;
                }
            }
            sets.put(chars[m], m);

            if (max < m - j) {
                max = m - j;
            }
        }
        return max + 1;
    }
}
