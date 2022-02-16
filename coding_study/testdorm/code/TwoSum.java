package testdorm.code;


import java.util.HashMap;
import java.util.Map;
public class TwoSum {
    public static int[] findTwoSum(int[] list, int sum) {
        if(list == null || list.length < 2) return null;
        Map<Integer,Integer> twoSumMap = new HashMap<>();
        for(int i=0; i<list.length;i++){
            if(twoSumMap.containsKey(list[i])){
                return new int[]{i, twoSumMap.get(list[i])};
            }
            twoSumMap.put(sum-list[i], i);
        }

        return null;
    }

    public static void main(String[] args) {
        int[] indices = findTwoSum(new int[] { 3, 1, 5, 7, 5, 9 }, 10);
        if(indices != null) {
            System.out.println(indices[0] + " " + indices[1]);
        }
    }
}