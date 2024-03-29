package whiteship.list;

public class LinkedList3 {
    LinkedNode head = null;
    LinkedNode tail = null;

    public static void main(String[] args) {
        LinkedList3 linkedList3 = new LinkedList3();
        linkedList3.add(new LinkedNode(1));
        linkedList3.add(new LinkedNode(1));
        linkedList3.add(new LinkedNode(1));
        linkedList3.add(new LinkedNode(2));
        linkedList3.add(new LinkedNode(3));
        linkedList3.add(new LinkedNode(3));
        linkedList3.print();
        //        linkedList3.removeDuplicate();
        linkedList3.removeDuplicate2();
        System.out.println("===========");

        linkedList3.print();
    }
    /*
    정렬된 연결 리스트에서 중복된 노드를 제거하는 함수를 구현하라.
    예) 1 -> 1 -> 1 -> 2 -> 3 -> 3 => 1 -> 2 -> 3
     */
    private void removeDuplicate(){
        LinkedNode curr = this.head;
        while (curr != null){
            // temp는 중복되는 구간까지 while loop를 돈다.
            LinkedNode temp = curr;
            while (temp != null && temp.number == curr.number){
                temp = temp.next;
            }
            curr.next = temp;
            curr = curr.next;
        }
    }

    private void removeDuplicate2(){
        removeDuplicateRecursive(this.head);
    }

    private LinkedNode removeDuplicateRecursive(LinkedNode node){
        if(node == null){
            return null;
        }

        if(node.next != null){
            if(node.number == node.next.number){
                node.next = node.next.next;
                removeDuplicateRecursive(node);
            }else{
                removeDuplicateRecursive(node.next);
            }
        }
        return node;
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
