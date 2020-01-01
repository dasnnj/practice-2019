package com.dasnnj.practice.simple;

/**
 * Description <P> DO : 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。 <P>
 * 示例 1:
 *
 * 输入: 123
 * 输出: 321
 *  示例 2:
 *
 * 输入: -123
 * 输出: -321
 * 示例 3:
 *
 * 输入: 120
 * 输出: 21
 * 注意:
 *
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author DASNNJ
 * @date 2020-01-01 20:35
 */
public class ReverseInteger {
    public int reverse(int x) {

        /*String numStr = String.valueOf(x);
        char[] arr = numStr.toCharArray();
        StringBuilder res = new StringBuilder();
        for (int i = arr.length-1; i >= 0; i--) {
            if (i != arr.length - 1 || arr[i] != 0) {
                if (i != 0 || '-' != arr[0]) {
                    res.append(arr[i]);
                }
            }
        }
        long num;
        if('-' != arr[0]){
            num = Long.parseLong(res.toString());
        }else{
            num = Long.parseLong("-"+res.toString());
        }
        if(num > Integer.MAX_VALUE || num < Integer.MIN_VALUE){
            return 0;
        }else{
            String s = String.valueOf(num);
            return Integer.parseInt(s);
        }*/
        long rst=0;
        while(x!=0){
            rst= rst*10+ x%10;
            x=x/10;

        }
        //rst 是long型 记录实际值 （int）rst 将rst 强制转换为int 型如果值过大会变成溢出之后的值 ，实际值不在与 long型相等 ，如果没有溢出 两者会相等
        if((int)rst!=rst){
            return 0;

        }else{
            return (int)rst;
        }
    }

    public static void main(String[] args) {
        ReverseInteger reverseInteger = new ReverseInteger();
        System.out.println(reverseInteger.reverse(1));
    }
}
