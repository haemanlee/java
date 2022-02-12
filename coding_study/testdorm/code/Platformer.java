package testdorm.code;


import java.util.Arrays;

public class Platformer {

    private int position;
    private int[] positionArr;

    public Platformer(int n, int position) {
        this.position = position;
        positionArr = new int[n];
        for(int x=0; x<n; x++) positionArr[x] = x;

//        int[] arrDestination = new int[positionArr.length - 1];
//        int remainingElements = positionArr.length - ( this.position + 1 );
//        System.arraycopy(positionArr, 0, arrDestination, 0, this.position);
//        System.arraycopy(positionArr, this.position + 1, arrDestination, this.position, remainingElements);
//        positionArr = arrDestination;
    }

    public void jumpLeft() {
//        int count = positionArr.length;


        this.position = this.position - 2;

        int[] arrDestination = new int[positionArr.length - 1];
        int remainingElements = positionArr.length - ( this.position + 1 );
        System.arraycopy(positionArr, 0, arrDestination, 0, this.position);
        System.arraycopy(positionArr, this.position + 1, arrDestination, this.position, remainingElements);
        positionArr = arrDestination;


        //        for(int i=0; i<count; i++){
//            if(i == this.position){
//                for(int j=i; j<count-1;j++){
//                    positionArr[j] = positionArr[j+1];
//                }
//                count--;
//                break;
//            }
//        }
    }

    public void jumpRight() {
        this.position = this.position + 2;

        int[] arrDestination = new int[positionArr.length - 1];
        int remainingElements = positionArr.length - ( this.position + 1 );
        System.arraycopy(positionArr, 0, arrDestination, 0, this.position);
        System.arraycopy(positionArr, this.position + 1, arrDestination, this.position, remainingElements);
        positionArr = arrDestination;

    }

    public int position() {
        return this.position;
    }

    public static void main(String[] args) {
        Platformer platformer = new Platformer(6, 3);
        System.out.println(platformer.position()); // should print 3
        System.out.println(platformer.positionArr[platformer.position()]);

        platformer.jumpLeft();
        System.out.println(platformer.position()); // should print 1
        System.out.println(platformer.positionArr[platformer.position()]);


        platformer.jumpRight();
        System.out.println(platformer.position()); // should print 4
        System.out.println(platformer.positionArr[platformer.position()]);
        System.out.println(Arrays.toString(platformer.positionArr));

    }
}
