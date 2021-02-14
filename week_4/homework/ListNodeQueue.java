package homework;

public class ListNodeQueue implements Queueable {
    public ListNode head;

    public ListNodeQueue(){
        this.head = new ListNode();
    };

    public void enqueue(int data){
        ListNode listNode = new ListNode(data);
        ListNode curNode = this.head;

        while(curNode.next != null){
            curNode = curNode.next;
        }
        curNode.next = listNode;
    }
    public int dequeue(){
        int value = this.head.next.data;
        head = this.head.next;
        return value;
    }
    
}
