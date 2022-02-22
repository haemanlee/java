package whiteship.list;
/**
 * 단일 연결 리스트를 뒤집는 함수를 구현하여라.
 * 1 ->2 ->3  => 3 ->2 ->1
 */

import java.util.HashMap;
import java.util.Map;

public class LinkedList {
    LinkedNode head;
    LinkedNode tail;
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(new LinkedNode(1));
        linkedList.add(new LinkedNode(2));
        linkedList.add(new LinkedNode(3));
        linkedList.add(new LinkedNode(4));
        linkedList.add(new LinkedNode(5));

        linkedList.print();

        System.out.println(linkedList.findLastNumberNode(2).number);

        System.out.println(linkedList.findLastNumberNode1(2).number);

        System.out.println(linkedList.findLastNumberNode2(2).number);

        System.out.println(linkedList.getMidNode().number);

    }
    private void add(LinkedNode node){
        if(head == null){
            head = node;
            tail = node;
        }else if(tail != null){
            tail.next = node;
            tail = tail.next;
        }
    }
    private void print(){
        LinkedNode nodeToNext = this.head;
        while(nodeToNext != null){
            System.out.println(nodeToNext.number);
            nodeToNext = nodeToNext.next;
        }
    }
    private void reverse(){
        LinkedNode newHead = this.head;
        this.head = reverseRecursive(newHead);
        this.tail = this.head;
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

    /**
     * 공간복잡도 : O(N)
     * 시간복잡도 : O(N)
     */
    private LinkedNode findLastNumberNode(int num){
        Map<Integer, LinkedNode> nodeMap = new HashMap<>();
        LinkedNode curr = this.head;
        int count = 0;
        while(curr != null){
            nodeMap.put(count++, curr);
            curr = curr.next;
        }
        return nodeMap.get(nodeMap.size()-num);
    }

    /**
     * 공간복잡도 : O(N)
     * 시간복잡도 : O(N)
     */
    private LinkedNode findLastNumberNode1(int num){
        LinkedNode curr = this.head;
        int length = 0;
        while(curr != null){
            length++;
            curr = curr.next;
        }
        int targetIndex = length - num;
        LinkedNode target = this.head;
        while (targetIndex > 0){
            targetIndex--;
            target = target.next;
        }
        return target;
    }


    /**
     * 공간복잡도 : O(N)
     * 시간복잡도 : O(1)
     */
    private LinkedNode findLastNumberNode2(int num){
        LinkedNode right = this.head;
        LinkedNode left = this.head;
        int count = 0;
        // right 노드가 끝에 다다를때까지
        while (right.next != null){
            // 차이가 num이 되면 그때부터 같은 속도로 출발한다.
            if(count == num - 1){
                left = left.next;
                right = right.next;
            }else if (count < num){
                // 차이가 num만큼 나기 전까지는 먼저 가는 node만 count++를 한다.
                right= right.next;
                count++;
            }
        }
        return left;
    }
    /**
     * 공간복잡도 : O(N)
     * 시간복잡도 : O(1)
     */
    private LinkedNode getMidNode(){
        LinkedNode fast = this.head;
        LinkedNode slow = this.head;
        while (fast != null && fast.next !=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
