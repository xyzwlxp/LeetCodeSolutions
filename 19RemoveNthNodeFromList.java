class Solution {
  public ListNode removeNthFromEnd(ListNode head, int n) {
	  ListNode pointer1 = head;
    ListNode pointer2 = head;
	  for (int i = 0; i < n; i++) {
			pointer2 = pointer2.next;
		}
    if(pointer2 != null){
      while (pointer2.next != null) {
        pointer1 = pointer1.next;
        pointer2 = pointer2.next;
      }
    } else {
      return head.next;
    }
		pointer1.next = pointer1.next.next;
		return head;
	}
}
