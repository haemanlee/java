
public class Main2 {
    public static void main(String[] args) {
        System.out.println("hello world");
        ListNode listNode = new ListNode(null,5,null);
        listNode.addFirst(6);        
        listNode.addLast(7);        
        listNode.addFirst(5);        
        listNode.addLast(9);        
        System.out.println(listNode.toString());

        listNode.add(2, 10);
        System.out.println(listNode.toString());

    }
}
