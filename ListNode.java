

public class ListNode {
    //정수를 저장하는 ListNode 클래스를 구현하세요.
    private ListNode head;
    private ListNode tail;
    private int size = 0;
    

    private int data;
    private ListNode prev;
    private ListNode next;
    //객체를 초기화해야 함.
    public ListNode(ListNode prev, int data, ListNode next){
        this.data = data;
        this.prev = prev;
        this.next = next;
    }

    public void addFirst(int data){
        ListNode h = head;
        ListNode newNode = new ListNode(null, data, h);
        newNode.next = head;
        head = newNode;
        size++;
        if(head.next==null){
            tail = newNode;
        }else{
            h.prev = newNode;
        }
    }

    public void addLast(int data){
        ListNode t = tail;
        ListNode newNode = new ListNode(t, data, null);
        if(size==0){
            addFirst(data);
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
            size++;
        }
    }
    //내부 API
    ListNode node(int index){
        ListNode node = head;
        for(int i=0; i <index; i++){
            node = node.next;
        }
        return node;
    }

    public void add(int k, int data){
        if(k==0){
            addFirst(data);
        } else {
            ListNode newNode = new ListNode(null,data,null);
            ListNode temp1 = node(k-1);
            ListNode temp2 = temp1.next;
            temp1.next = newNode;
            newNode.prev = temp1;
            newNode.next = temp2;
            size++;
            if(newNode.next ==null){
                tail = newNode;
            }
        }
    }

    public String toString(){
        if(head == null){
            return "[]";
        }
        ListNode temp = head;
        String str = "[";

        while(temp.next != null){
            str += temp.data + ", ";
            temp = temp.next;
        }
        str += temp.data;

        return str+"]";
    }

    

//ListNode add(ListNode head, ListNode nodeToAdd, int position)를 구현하세요.
    public void add(ListNode head, ListNode nodeToAdd, int position){
        ListNode temp1 = head;
        while(--position!=0){
            temp1 = temp1.next;
        }
        ListNode temp2 = temp1.next;
        temp1.next = nodeToAdd;
        nodeToAdd.prev = temp1;
        nodeToAdd.next = temp2;
    }

//ListNode remove(ListNode head, int positionToRemove)를 구현하세요.
//boolean contains(ListNode head, ListNode nodeTocheck)를 구현하세요.-



     
}
