package org.example;

import java.math.BigInteger;

/**
 * almost working solution, missing if list are inconsistent lengths.
 */
public class solutionTwo {

    public static void main(String[] args){
        solutionTwo solutionTwo = new solutionTwo();

        ListNode l1 = new ListNode(3);
        ListNode l2 = new ListNode(4,l1);
        ListNode a = new ListNode(2,l2);

        ListNode l3 = new ListNode(4);
        ListNode l4 = new ListNode(6,l3);
        ListNode b = new ListNode(5,l4);

        System.out.println(solutionTwo.getResultFromListNode(solutionTwo.addTwoNumbers(a, b)));
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        BigInteger s = new BigInteger(getResultFromListNode(l1));
        BigInteger b = new BigInteger(getResultFromListNode(l2));
       return stringToListNode(s.add(b).toString());
    }

    private ListNode stringToListNode(String output) {
        ListNode root = new ListNode(Integer.parseInt(String.valueOf(output.charAt(output.length() - 1))));
        ListNode temp = root;

        for (int i = output.length() -2; i >= 0; --i) {
            temp.next = new ListNode(Integer.parseInt(String.valueOf(output.charAt(i))));
            temp = temp.next;
        }
        return root;
    }

    public String getResultFromListNode(ListNode node){
        StringBuilder s = new StringBuilder();
        while(node.next != null){
            s.append(node.val);
            node = node.next;
        }
        s.append(node.val);

        return s.toString();
    }
}
