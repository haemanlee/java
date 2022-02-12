package whiteship.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
1.질문 : 안에 들어오는 배열이 정렬되어 있는지? 중복되어 있는 것이 2번 이상인지?(큰 영향은 없음)


*/



public class Array1 {
    public static void main(String[] args) {
        Array1 array1 = new Array1();
        boolean returnValue1 = array1.solution3(new int[]{1,2,3,4,5,6});
        boolean returnValue2 = array1.solution3(new int[]{1,1,2,2,3,1});

        System.out.println(returnValue1);        
        System.out.println(returnValue2);        

    }

    /**
     *  시간복잡도 : O(n2)
     *  공간복잡도 : O(1)
    */ 
    private boolean solution1(int[] array){
        for(int i=0; i<array.length; i++){
            for(int j=i+1; j<array.length; j++){
                if(array[i] == array[j]){
                    return true;
                }
            }
        }
        return false;
    }
    /**
     * 정렬 후에 for 루프 한번만 돌리면됨.
     * 시간복잡도 : O(NlogN)
     * 공간복잡도 : O(logN)
     */
    private boolean solution2(int[] array){
        Arrays.sort(array); // 시간복잡도 O(NlogN), 공간복잡도 O(logN)

        for(int i=0; i<array.length-1;i++){
            if(array[i] == array[i+1]){
                return true;
            }
        }
        return false;
    }

    private boolean solution3(int[] array){
        Set<Integer> numSet = new HashSet<>();
        for(int num : array){
            if(numSet.contains(num)){
                return true;
            } else {
                numSet.add(num);
            }
        }
        return false;
        
    }

    
    /**
     *  시간복잡도 : O(n)
     *  공간복잡도 : O(n) map이 n만큼만 만들어 졌기 때문에.
     */

    private boolean checkDuplicate(int[] array){
        
        boolean isDuplicate = false;
        Map<Integer,Integer> numberMap = new HashMap<>();

        for(int num : array){
            numberMap.put(num, numberMap.getOrDefault(num, 0) + 1);
            if(numberMap.get(num)>1){
                isDuplicate = true;
            }   
        }

        // for(int num : array){
        //     if(numberMap.get(num)>1){
        //         isDuplicate = true;
        //         break;
        //     }
        // }
        return isDuplicate;
    }
}
