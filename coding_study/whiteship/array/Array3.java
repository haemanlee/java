package whiteship.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Array3 {
    public static void main(String[] args) {
        Array3 array3 = new Array3();
        System.out.println(Arrays.toString(array3.solution2(new int[]{2,3,5,7}, 8)));
        
    }
    /**
     * 시간복잡도 : O(N2)
     * 공간복잡도 : O(1)
     */
    private int[] solution1(int[] numbers, int target){
        for(int i=0; i<numbers.length; i++){
            for(int j=i+1; j<numbers.length; j++){
                if(numbers[i]+numbers[j] == target){
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }
    /**
     * 시간복잡도 : O(N)
     * 공간복잡도 : O(N)
     */
    private int[] solution2(int[] numbers, int target){
        Map<Integer, Integer> numberMap = new HashMap<>();
        for(int i=0; i<numbers.length; i++){
            numberMap.put(numbers[i],i);
        }
        for(int i=0; i<numbers.length; i++){
            int numberToFind = target - numbers[i];
            if(numberMap.containsKey(numberToFind) && numberMap.get(numberToFind) != i){
                return new int[]{i, numberMap.get(numberToFind)};
            }
        }
        return null;
    }
}

