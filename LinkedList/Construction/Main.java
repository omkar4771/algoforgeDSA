class Node{
    int data;
    Node next;
    public Node(int data){
          this.data=data;
    }
}


class LinkedList{
    
    Node head;
    Node tail;
    int size;

    public LinkedList(){
        this.head=null;
        this.tail=null;
        this.size=0;
    }

    // add a node at the end of linkedList
    public void addLast(int val){
        Node n1 = new Node(val);
        
        if (size==0) {
            head=n1;
            tail=n1;
        }else{
            tail.next=n1;
            tail=n1;    
        }
        size++;
    }

    //add first 
    public void addFirst(int val){

        Node n1 = new Node(val);
        
        //check if linkedlist is not null
        if(head == null){
            head=n1;
            tail=n1;
        }else{
            
            n1.next=head;
            head=n1;

            //Node temp = head;
            //head=n1;
            //head.next=temp;
        }
        size++;
    }

    //display
    public void displayList(){
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data+",");
            temp=temp.next;
        }
    }

    //display by omkar
    public void display(){
        Node temp= head;

        for(int i=0; i<size; i++){
            if (temp == null) {
                return ;
            }
            System.out.print(temp.data+",");
            temp=temp.next;
        }

    }

    //get node at 
    public Node getNodeAt(int idx){
        Node tempnode = head;

        if(idx < 0 || idx > size){
            System.out.println("Invalid IDX..");
            return null;
        }

        for(int i=0 ;i<size;i++){
            if(i==idx){
                return tempnode;
            }else{
                tempnode=tempnode.next;
            }
        }
        
        return null;
    }

    //addNode at
    public void addNodeAt(int idx, int val){

        Node n1 = new Node(val);

        Node idxNode = getNodeAt(idx-1);
        if(idxNode == null){
            head=n1;
            tail=n1;
        }else{
            Node temp = idxNode.next;
            idxNode.next=n1;
            n1.next=temp;
        }
        size++;
    }

    //reverse linkedlist
    public void reverseLinedListDataIteratively(){

        int i=0;
        int j=size-1;

        while (i<j) {
            
            //get ith node 
            Node ith = getNodeAt(i);

            //get jth node
            Node jth = getNodeAt(j);

            //swap both data
            int temp = ith.data;
            ith.data = jth.data;
            jth.data = temp;

            //next step condition
            i++;
            j--;

        }

    }

    //reverse lined list o(n)
    public void reverseLinkedList(){

        Node prev = null;
        Node current =  head;
        Node currentkanext = head.next;

        for(int i=1 ; i<size; i++){

            currentkanext = prev;
            
            //change position
            prev = current;
            current = currentkanext;

            currentkanext = currentkanext.next;
        }

    }

    //remove last element 
    public void removeLast(){
        if(head == null){
            System.out.println("Nothing to remove ...");
            return ;
        }else if (head == tail) {
            head = null;
            tail = null;
            size = 0;
        }else{
            Node current = head;
            //remove last 
            for(int i=0; i<size-1; i++){
                if(current.next == tail){
                    current.next = null;
                    tail = current;
                    size--;
                }
                current = current.next;
            }
        }
    }

    //remove first element
    public void removeFirst(){

        if(head == null){
            System.out.println("Nothing to their for removing...");
            return ;
        }else if(head == tail){
            head = null;
            size= 0;
            tail = null;
        }else{
            head = head.next;
            size ++;
        }

    }

    //remove node at
    public void removeNodeAt(int idx){

        if( idx < 0 || idx >= size){
            System.out.println("Invalid idx...");
            return ;
        }

        if(idx == 0 ){
            removeFirst();
            return ;
        }

        if(idx == size-1){
            removeLast();
            return ;
        }

        Node temp = getNodeAt(idx-1);

        temp.next = temp.next.next;
        size--;
    }
}


public class Main {

    public static void main(String[] args) {
        
        LinkedList ll = new LinkedList();

        ll.addLast(5);
        ll.addLast(10);
        ll.addLast(15);
        ll.addLast(20);
        ll.addFirst(1);

        ll.displayList();
        System.out.println("");
        ll.display();
        ll.addNodeAt(3,47);
        System.out.println("");
        ll.display();
        Node n= ll.getNodeAt(3);
        System.out.println("");
        System.out.println(n.data);
        System.out.println("Display --");
        ll.display();
        ll.reverseLinedListDataIteratively();
        System.out.println("");
        ll.display();
        System.out.println("");
        // ll.reverseLinkedList();
        System.out.println("");
        ll.removeLast();
        System.out.println("");
        ll.display();
        System.out.println("");
        ll.removeFirst();
        ll.display();
        System.out.println("");
        ll.removeNodeAt(2);
        ll.display();

    }
    
}
