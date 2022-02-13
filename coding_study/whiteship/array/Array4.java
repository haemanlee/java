package whiteship.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  1부터 100까지 숫자 중에 50개의 랜덤한 숫자가 들어있는 배열이 있다. 이 배열을 O(n)의 시간 복잡도로 정렬하라.
 */
public class Array4 {
    public static void main(String[] args) {
        Array4 array4 = new Array4();
        System.out.println(Arrays.toString(array4.solution2(new int[]{13,5,8,7,9})));
    }
    
    private List<Integer> solution1(int[] numbers){
        int[] sortedArray = new int[100];
        for(int num : numbers){
            sortedArray[num] = num;
        }
        List<Integer> list = new ArrayList<>();
        for(int num : sortedArray){
            if(num != 0){
                list.add(num);
            }
        }
        return list;
    }

    private int[] solution2(int[] numbers) {
        boolean[] booleans = new boolean[100];
        for(int num: numbers){
            booleans[num] = true;
        }

        int index = 0;
        for(int i = 0; i<booleans.length; i++){
            if(booleans[i]){
                numbers[index++] = i;
            }
        }
        return numbers;
    }
}
