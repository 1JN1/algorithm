package day_09;

/**
 * @author 王文涛
 * @date 2024/9/14
 * @description
 **/
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode createList(int[] nums) {

        ListNode head = new ListNode(nums[0]);
        ListNode r = head;

        for (int i = 1; i < nums.length; i++) {

            r.next = new ListNode(nums[i]);
            r = r.next;

        }

        return head;
    }

    public static void printList(ListNode head) {

        if(head == null){
            System.out.println("List is empty");
            return;
        }

        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }

        System.out.println();

    }

}
