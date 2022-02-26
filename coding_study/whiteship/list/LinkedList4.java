package whiteship.list;

import java.util.HashSet;
import java.util.Set;

public class LinkedList4 {
    LinkedNode head = null;
    LinkedNode tail = null;

    /**
     * 정렬이 안되어 있는 상태에서 중복을 제거하라
     * @param args
     */
    public static void main(String[] args) {
        LinkedList4 linkedList3 = new LinkedList4();
        linkedList3.add(new LinkedNode(1));
        linkedList3.add(new LinkedNode(2));
        linkedList3.add(new LinkedNode(1));
        linkedList3.add(new LinkedNode(2));
        linkedList3.add(new LinkedNode(3));
        linkedList3.add(new LinkedNode(3));
        linkedList3.print();
        //        linkedList3.removeDuplicate();
        linkedList3.removeDuplicate();
        System.out.println("===========");

        linkedList3.print();
    }
    /*
    정렬된 연결 리스트에서 중복된 노드를 제거하는 함수를 구현하라.
    예) 1 -> 1 -> 1 -> 2 -> 3 -> 3 => 1 -> 2 -> 3
     */
    private void removeDuplicate(){
        Set<Integer> numSet = new HashSet<>();
        LinkedNode curr = this.head;
        LinkedNode prev = null;
        while(curr != null){
            if(numSet.contains(curr.number)){
                prev.next = curr.next;
            }else{
                //보통인 경우
                numSet.add(curr.number);
                prev = curr;
            }
            curr = curr.next;
        }
    }


    private void add(LinkedNode node){
        if(this.head == null){
            head = node;
            tail = node;
        } else if(this.tail != null){
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

}
