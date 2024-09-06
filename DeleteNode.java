class Solution {
    public ListNode modifiedList(int[] nums, ListNode head) {
       Set<Integer> valuesToRemove = new HashSet<>();
        for (int num : nums) {
            valuesToRemove.add(num);
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
      ListNode current = head;
        ListNode prev = dummy;
        while (current != null) {
            if (valuesToRemove.contains(current.val)) {
                prev.next = current.next;
            } else {
                prev = current;
            }
            current = current.next; 
        }
        return dummy.next;
    }
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println(); 
    }
}