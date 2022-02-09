package whiteship;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SearchOnlyNum {
    public static void main(String[] args) {
        SearchOnlyNum searchOnlyNum = new SearchOnlyNum();
        int result1 = searchOnlyNum.solution1(new int[]{1,2,2,3,3,4,4});
        int result2 = searchOnlyNum.solution2(new int[]{1,2,2,3,3,4,4});
        int result3 = searchOnlyNum.solution3(new int[]{1,2,2,3,3,4,4});
        
        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);

    }
    /**
     * 시간복잡도 : O(n2)
     * 공간복잡도 : O(n)
     */
    private int solution1(int[] elements){
        List<Integer> list = new ArrayList<>();
        for(int element : elements){
            // contains가 결국 *n을 시간복잡도를 하게됨.
            if(list.contains(element)){
                list.remove((Integer)element);
            }else{
                list.add(element);
            }
        }
        return list.get(0);
    }

    /**
     * 시간복잡도 : O(n)
     * 공간복잡도 : O(n)
     */
    private int solution2(int[] elements){
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : elements){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for(int num : elements){
            if(map.get(num) == 1){
                return num;
            }
        }
        return 0;
    }
    /**
    *  XOR 비트 연산자 (^)를 사용하는 방법
    *  XOR 비트 연산자: 두 비트가 서로 다를 때 1
    *  시간복잡도 : O(n) : 모두 순회한다.
    *  공간복잡도 : O(1) : 1개만 사용해서 리턴한다.
    */

    private int solution3(int[] elements){
        int rtnValue = 0;
        for (int num : elements){
            rtnValue ^= num;
        }
        return rtnValue;
    }
}
