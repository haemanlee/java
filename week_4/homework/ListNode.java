package homework;

// 과제 2. LinkedList를 구현하세요.
// LinkedList에 대해 공부하세요.
// 정수를 저장하는 ListNode 클래스를 구현하세요.
// ListNode add(ListNode head, ListNode nodeToAdd, int position)를 구현하세요.
// ListNode remove(ListNode head, int positionToRemove)를 구현하세요.
// boolean contains(ListNode head, ListNode nodeTocheck)를 구현하세요.
public class ListNode {
    public int data;
    public ListNode next;

    // 정수를 저장하는 ListNode 클래스를 구현하세요.
    public ListNode(){};

    public ListNode(int data){
        this.data = data;
    }
    // ListNode add(ListNode head, ListNode nodeToAdd, int position)를 구현하세요.
    public ListNode add(ListNode head, ListNode nodeToAdd, int position){
        ListNode target = head;
        for(int i=0 ; i<position-1 ; i++){
            target = target.next;
        }
        nodeToAdd.next = target.next;
        target.next = nodeToAdd;
        return nodeToAdd;
    }
    // ListNode remove(ListNode head, int positionToRemove)를 구현하세요.
    public ListNode remove(ListNode head, int positionToRemove){
        ListNode target = head.next;
        ListNode before = head;
        for(int i =0;i < positionToRemove-1 ;i++){
            before = target;
            target = target.next;
        }
        before.next = target.next;
        return target;
    }
    // boolean contains(ListNode head, ListNode nodeTocheck)를 구현하세요.
    public boolean contains(ListNode head, ListNode nodeTocheck){
        ListNode target = head;
        
        while(target != null){
            target = target.next;
            if(nodeTocheck.equals(target)){
                return true;
            }
        }

        return false;
    }
    
}
