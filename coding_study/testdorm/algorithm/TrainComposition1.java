/*
A TrainComposition is built by attaching and detaching wagons from the left and the right sides.

For example, if we start by attaching wagon 7 from the left followed by attaching wagon 13,
again from the left, we get a composition of two wagons (13 and 7 from left to right).
Now the first wagon that can be detached from the right is 7 and the first that can be detached from the left is 13.
Implement a TrainComposition that models this problem.
 */

package testdorm.algorithm;


public class TrainComposition1 {
    Wagon head;
    Wagon finalwagon;

    public void attachWagonFromLeft(int wagonId) {
        Wagon wagon = new Wagon(wagonId);
        if( head == null ){
            head = wagon;
            if(finalwagon == null){
                finalwagon = wagon;
            }
        } else {
            wagon.next = head;
            head.prev = wagon;
            head = wagon;
        }
    }

    public void attachWagonFromRight(int wagonId) {
        Wagon wagon = new Wagon(wagonId);
        if( finalwagon == null ){
            finalwagon = wagon;
            if(head == null){
                head = wagon;
            }
        } else {
            finalwagon.next = wagon;
            wagon.prev = finalwagon;
            finalwagon = wagon;
        }
    }

    public int detachWagonFromLeft() {
        int val = head.data;
        Wagon wagon = head.next;
        if(wagon == null) finalwagon = null;
        head = wagon;

        return val;
    }

    public int detachWagonFromRight() {
        int val = finalwagon.data;
        Wagon wagon = finalwagon.prev;
        if(wagon == null) head = null;
        finalwagon = wagon;
        return val;
    }

    public static void main(String[] args) {
        TrainComposition1 train = new TrainComposition1();
        train.attachWagonFromLeft(7);
        train.attachWagonFromLeft(13);
        System.out.println(train.detachWagonFromRight()); // 7
        System.out.println(train.detachWagonFromLeft()); // 13
    }
}

class Wagon {
    int data;
    Wagon prev;
    Wagon next;

    Wagon(int d) { data = d; }
}