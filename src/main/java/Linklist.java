public class Linklist {

    public ListNode middleNode(ListNode head) {
        int count =0;
        ListNode temphead=head;
        while(temphead !=null)
        {
            temphead=temphead.next;
            count++;
        }
        int i=0;
        while(head !=null)
        {
            if(i==count/2)
            {
                return head;
            }
            head=head.next;
            i++;
        }
        return null;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int sizeA=0;
        int sizeB=0;

        for(ListNode temp=headA;temp!=null;temp=temp.next)
        {
            sizeA++;
        }

        for(ListNode temp=headB;temp!=null;temp=temp.next)
        {
            sizeB++;
        }

        while(sizeB > sizeA)
        {
            headB=headB.next;
            sizeB--;
        }

        while(sizeA > sizeB)
        {
            headA=headA.next;
            sizeA--;
        }

        while(headA != headB)
        {
            headA=headA.next;
            headB=headB.next;
        }

        return headA;

    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode current=new ListNode();
        ListNode dummy=current;
        while(list1 != null && list2 != null)
        {
            if(list1.val < list2.val)
            {
                current.next=list1;
                list1=list1.next;
            }
            else
            {
                current.next=list2;
                list2=list2.next;
            }
            current=current.next;
        }

        while(list1 !=null)
        {
            current.next=list1;
            list1=list1.next;
        }

        while(list2 !=null)
        {
            current.next=list2;
            list2=list2.next;
        }

        return dummy.next;

    }

    public ListNode reverseList(ListNode head) {
        ListNode prev=null;
        ListNode current=head;
        while(current !=null)
        {
            ListNode temp = current.next;
            current.next=prev;
            prev=current;
            current=temp;
        }
        return prev;


    }

    public boolean isPalindrome(ListNode head) {
        ListNode prev = reverseList(head);
        while(head !=null && prev !=null)
        {
            if(head.val != prev.val)
            {
                return false;
            }
            head=head.next;
            prev= prev.next;
        }
        return true;

    }

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode current = dummy;

        while(current.next !=null)
        {
            if(current.next.val == val)
            {
                current.next= current.next.next;
            }
            else
            {
                current=current.next;
            }
        }
        return dummy.next;
    }

    public boolean hasCycle(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;

        while(fast !=null && fast.next !=null)
        {
            slow=slow.next;
            fast=fast.next.next;
            if(slow == fast)
            {
                return true;
            }
        }
        return false;


    }

    /**
     * Convert Binary Number in a Linked List to Integer
     * @param head
     * @return
     */
    public int getDecimalValue(ListNode head) {
        StringBuilder binaryStr = new StringBuilder();
        while(head !=null)
        {
            binaryStr.append(head.val);
            head=head.next;
        }

        return Integer.parseInt(binaryStr.toString(),2);
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode list = head;

        while(list != null) {
            if (list.next == null) {
                break;
            }
            if (list.val == list.next.val) {
                list.next = list.next.next;
            } else {
                list = list.next;
            }
        }

        return head;
    }
}
