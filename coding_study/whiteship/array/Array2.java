package whiteship.array;

public class Array2 {
    public static void main(String[] args) {
        Array2 array2 = new Array2();
        String message = "hello java";

        System.out.println(array2.solution2(message.toCharArray()));
    }


    /**
     * 시간복잡도 : O(N)
     * 공간복잡도 : O(N)
     */
    private char[] solution1(char[] input){
        char[] reverseChar = new char[input.length];
        for(int i=0; i<input.length ;i++){
            reverseChar[input.length-1-i] = input[i];
        }

        return reverseChar;
    }   
    /**
     * 시간복잡도 : O(N) n/2이자만 커지면 의미가 없음.
     * 공간복잡도 : O(1)
     */
    private char[] solution2(char[] input){
        // if(input.length % 2 == 1){
        //     for(int i=0; i< input.length / 2 - 1; i++){
        //         char temp = input[i];
        //         input[i] = input[input.length - 1 - i];
        //         input[input.length -1 -i] = temp;
        //     }
        // } else {
            for(int i=0; i< input.length / 2; i++){
                char temp = input[i];
                input[i] = input[input.length - 1 - i];
                input[input.length -1 -i] = temp;
            }            
        // }
        return input;
    }

    
}
