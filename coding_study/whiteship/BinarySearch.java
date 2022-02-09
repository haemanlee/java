package whiteship;

public class BinarySearch {
    public static void main(String[] args) {
        int[] test = {1,2,4,6,7,8};
        System.out.println(binarySearch(6, test));
    }
    private static int binarySearch(int target, int[] elements){

        int start = 0;
        int end = elements.length-1;
        int index = 0;
        while (start <= end){
            int mid = (start + end) / 2;
            int midNumber = elements[mid];
            if(midNumber < target){
                start = mid + 1;
            }else if(elements[mid] > target){
                end = mid -1;
            }else if(elements[mid] == target){
                index = mid;
                break;
            }
        }
        return index;

    }
}
