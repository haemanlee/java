package whiteship.list;
/**
 * 단일 연결 리스트를 뒤집는 함수를 구현하여라.
 * 1 ->2 ->3  => 3 ->2 ->1
 */
public class LinkedList2 {

    private LinkedNode head;
    private LinkedNode tail;

    public static void main(String[] args) {
        LinkedList2 list = new LinkedList2();
        list.add(new LinkedNode(1));
        list.add(new LinkedNode(2));
        list.add(new LinkedNode(3));

        list.print();
//        list.reverse();

        list.print();
    }

    private void print() {
        LinkedNode nodeToPrint = this.head;
        while(nodeToPrint != null) {
            System.out.println(nodeToPrint.number);
            nodeToPrint = nodeToPrint.next;
        }
    }

    private void add(LinkedNode node) {
        if(head == null){
            this.head = node;
            this.tail = node;
        }else if(tail != null){
            tail.next = node;
            tail = tail.next;
        }

    }

    /**
     * TODO 단일 연결 리스트를 뒤집는 함수를 구현하라.
     *  예) 1 -> 2 -> 3   =>   3 -> 2 -> 1
     * @return
     * 시간 복잡도 O(N)
     * 공간 복잡도 O(1)
     * 문제를 작게 보자
     * 1. current의 next의 next는 화살표가 자기 자신을 바라보게 한다.
     * 2. current의 next를 null로 만든다.
     * 종료 조건를 확인
     */
    private void reverse() {
        LinkedNode head = this.head;
        this.head = reverseRecursive(head);
        this.tail = head;

    }

    private LinkedNode reverseRecursive(LinkedNode node){
        if(node == null || node.next == null){
            return node;
        }
        LinkedNode newHead = reverseRecursive(node.next);
        node.next.next = node;
        node.next = null;
        return newHead;
    }

}
