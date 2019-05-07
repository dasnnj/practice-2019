package com.dasnnj.practice.medium;

/**
 * Description <p> TODO:
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例：
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 * </p>
 *
 * @author DASNNJ <a href="mailto:dasnnj@outlook.com"> dasnnj@outlook.com </a>
 * @date 2019-05-06 09:07
 */
public class TwoAdd {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode(0);
        int m = 0;
        //进位
        int n = 0;
        ListNode l = l3;
        while (l1 != null || l2 != null) {
            l.next = new ListNode(0);
            l = l.next;
            if (l1 == null) {
                //则l2必然不为null
                //                l.val = l2.val + n;
                m = l2.val + n;
            } else if (l2 == null) {
                //则l1必然不为null
                //                l.val = l1.val + n;
                m = l1.val + n;
            } else {
                m = (l1.val + l2.val) + n;
            }
            n = m / 10;
            if (n > 0) {
                l.val = m % 10;
                //此步为了最后一个位置的两个数字加了之后需要进位
                l.next = new ListNode(n);
                //                l3.next.val = n;
            } else {
                l.val = m;
            }
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;

        }
        return l3.next;

    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(8);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(0);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(7);
        TwoAdd t = new TwoAdd();
        ListNode l3 = t.addTwoNumbers(l1, l2);
        System.out.println(l3);

    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) { val = x; }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ListNode{");
        sb.append("val=").append(val);
        sb.append(", next=").append(next);
        sb.append('}');
        return sb.toString();
    }
}