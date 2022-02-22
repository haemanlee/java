package whiteship.list;

import java.util.LinkedList;

public class LinkedList3 {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(4);
        linkedList.add(5);
        System.out.println(findFromLast(linkedList,2));
    }
    /**
     * 끝에서 n번째 위치한 노드를 찾는 함수를 구현하라.
     * 시간복잡도 : 
     * 공간복잡도 : 
     */

    private static Integer findFromLast(LinkedList list, int number){
        if(list.size() - number < 0){
            return 0;
        }
        return (Integer) list.get(list.size()-number);
    }
    
}
