package homework;
// 과제 4. 앞서 만든 ListNode를 사용해서 Stack을 구현하세요.
// ListNode head를 가지고 있는 ListNodeStack 클래스를 구현하세요.
// void push(int data)를 구현하세요.
// int pop()을 구현하세요.
public class ListNodeStack implements Stackable{
    // ListNode head를 가지고 있는 ListNodeStack 클래스를 구현하세요.
    public ListNode head;

    public ListNodeStack(){
        this.head = new ListNode();
    }

    // void push(int data)를 구현하세요.
    public void push(int data){
        
        ListNode listNode = new ListNode(data);
        ListNode curNode = this.head;

        while(curNode.next!=null){
            curNode = curNode.next;
        }
        curNode.next = listNode;

    }
    // int pop()을 구현하세요.
    public int pop(){
        if(this.head.next ==null) throw new IndexOutOfBoundsException();
        ListNode curNode = this.head.next;
        ListNode before = curNode;

        while(curNode.next!=null){
            before = curNode;
            curNode = curNode.next;
        }
        before.next =null;
        return curNode.data;
    }
}
