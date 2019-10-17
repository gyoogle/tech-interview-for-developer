class LinkedList{
    
    Node head;

    static class Node {
        int data;
        Node next;
        Node(int d) { // 생성자
            data = d; next = null;
        }
    }

    public void printList() 
    { 
        Node n = head; 
        while (n != null) 
        { 
            System.out.print(n.data+" "); 
            n = n.next; 
        } 
    }

    public static void main(String[] args){

        LinkedList llist = new LinkedList();

        llist.head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);

        /*
          llist.head        second              third 
             |                |                  | 
             |                |                  | 
         +----+------+     +----+------+     +----+------+ 
         | 1  | null |     | 2  | null |     |  3 | null | 
         +----+------+     +----+------+     +----+------+ 
        */
    
        llist.head.next = second; // 첫번째 노드에 두번째 노드 연결
        second.next = third; // 두번째 노드에 세번째 노드 연결
        
        /*
  
         llist.head        second              third 
            |                |                  | 
            |                |                  | 
        +----+------+     +----+------+     +----+------+ 
        | 1  |  o-------->| 2  |  o-------->|  3 | null | 
        +----+------+     +----+------+     +----+------+ 
        
        */
        llist.printList(); 
    }
}