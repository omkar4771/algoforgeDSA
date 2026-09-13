import java.util.List;

class ListNode {
       int val;
       ListNode next;
       ListNode() {}
       ListNode(int val) { this.val = val; }
       ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

    
class Main{

    //Leetcode 876 -> find middle node
    public ListNode middleNode(ListNode head) {
    
        ListNode slow = head;
        ListNode fast = head;

            while(fast !=null && fast.next != null){
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
    }
    
    //Kth from End of Linked List - submited/accepted
    public int getKthFromLast(ListNode head, int k){

        ListNode current = head;
        ListNode prev = null;
        ListNode answerNode = null;
        ListNode tempNode = head;
        int counterk = 1;
        
        while (current != null) {

            if(counterk >= k){
            
                answerNode = tempNode;
                tempNode = tempNode.next;
            }
            // move for next
            counterk++;
            prev=current;
            current= current.next;
        }
        
        if(answerNode == null){
            return -1;
        }else{
            return answerNode.val;
        }
    }

    // Leetcode 234-> Palindrome Linked List
     public boolean isPalindrome(ListNode head) {

        ListNode tempLinkedlist1 = head;
        
        // find mid 
        ListNode midhead = findMiddleNode(head);

        // reverse linked list from mid - return new head(for 2nd linked list)
        ListNode tempLinkedlist2 = revereseLinkedList(midhead);

        //compair both head 
        while (tempLinkedlist1 != null && tempLinkedlist2 != null) {
            
            if(tempLinkedlist1.val == tempLinkedlist2.val){
                tempLinkedlist1 = tempLinkedlist1.next;
                tempLinkedlist2 = tempLinkedlist2.next;
                
            }else{
                return false;
            }

        }
        return true;
    }

    // Leetcode 143-> Reorder List
    public void reorderList(ListNode head) {

        //find two halves
        ListNode midNode =  findMiddleNode(head);

        ListNode secondHalfHead = midNode.next;
        midNode.next = null;

        //reverse second half
        secondHalfHead = revereseLinkedList(secondHalfHead);

        //combine these two
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        ListNode pt1 = head;
        ListNode pt2 = secondHalfHead;

        while (pt1 != null && pt2 != null) {

            //isolated pt1
            ListNode ptr1kanext = pt1.next;
            pt1.next =null;

            //connect to ans linkedList
            curr.next = pt1;

            //move pt1 and curr
            pt1 = ptr1kanext;
            curr = curr.next;

            //isolated pt2
            ListNode ptr2kanext = pt2.next;
            pt2.next =null;

            //connect to ans linkedList
            curr.next = pt2;

            //move pt2 and curr
            pt2 = ptr2kanext;
            curr = curr.next;            
        }

        //odd case 
        if(pt1 != null){
            curr.next = pt1;
        }
    }

    // Leetcode 328-> Odd Even Linked List
    public ListNode oddEvenList(ListNode head) {

        ListNode oddLinkedList = new ListNode(-1);
        ListNode evenLinkedList = new ListNode(-1);

        ListNode odddummy = oddLinkedList;
        ListNode evendummy = evenLinkedList;

        int idx = 1;
        ListNode position = head;

        while (position != null) {
            //isolated
            ListNode newposition = position.next;
            position.next = null;

            if(idx %2 == 0){
                evendummy.next = position;
                evendummy = evendummy.next;
            }else{
                odddummy.next = position;
                odddummy=odddummy.next;
            }
            position = newposition;
            idx++;
        }

        //join odd + even linked list are return 
        odddummy.next = evenLinkedList.next;
        return oddLinkedList.next;
    }

    // Leetcode 25-> Reverse Nodes in k-Group
    public ListNode reverseKGroup(ListNode head, int k) {
        //find the size of linkedList
        int size = getSize(head);


        return null;
    }

    //helper function to find middle of linkedlist (first middle in case of even)
    public ListNode findMiddleNode(ListNode head){
        ListNode slow = head;
        ListNode fast = head;

            while(fast.next != null && fast.next.next != null){
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
    }

    // helper function to reverse linkedlist and return new head
    public ListNode revereseLinkedList(ListNode head){
        ListNode curr = head;
        ListNode prev = null;

        while(curr != null){
            ListNode currKaNext = curr.next;

            curr.next = prev;

            prev = curr;
            curr = currKaNext;
        }

        return prev; // new head
    }

    //find the size of linkedlist
    public int getSize(ListNode head){

        if(head==null){
            return 0;
        }else if(head.next == null){
            return 1;
        }
        ListNode temp = head;
        int size = 0;
        while (temp != null) {
            temp=temp.next;
            size++;
        }
        return size;
    }
    public static void main(String[] args) {
        
        Main obj = new Main();

        // Create linked list: 1 -> 2 -> 3 -> 4 -> 5 -> 6
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        System.out.println("-----------------------");
        ListNode result = obj.oddEvenList(head);
        System.out.print("Odd Even List: ");
        while (result != null) {
            System.out.print(result.val + " -> ");
            result = result.next;
        }

        // Call middleNode()
        ListNode middle = obj.middleNode(head);

        //getKthFromLast
        int kthnode = obj.getKthFromLast(head,  3);
        
        // palindrome
        Boolean ispalindrome =  obj.isPalindrome(head);
        System.out.println();
        System.out.println("Kth last node: "+kthnode);
        System.out.println("Middle node: " + middle.val);
        System.out.println("ispalindrome: "+ispalindrome);

        System.out.println("-----------------------");
    
        

    }

}