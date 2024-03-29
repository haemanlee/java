/*
A TrainComposition is built by attaching and detaching wagons from the left and the right sides.

For example, if we start by attaching wagon 7 from the left followed by attaching wagon 13,
again from the left, we get a composition of two wagons (13 and 7 from left to right).
Now the first wagon that can be detached from the right is 7 and the first that can be detached from the left is 13.
Implement a TrainComposition that models this problem.

solution : using deque called double-ended queue
 */

package testdorm.algorithm;


import java.util.Deque;
import java.util.LinkedList;

public class TrainComposition2 {
    private final Deque<Integer> wagons = new LinkedList<>();

    public void attachWagonFromLeft(int wagonId) {
        wagons.addFirst(wagonId);
    }

    public void attachWagonFromRight(int wagonId) {
        wagons.addLast(wagonId);
    }

    public int detachWagonFromLeft() {
        if(!wagons.isEmpty()){
            return wagons.removeFirst();
        } else {
            throw new IndexOutOfBoundsException("No wagons available");
        }
    }

    public int detachWagonFromRight() {
        if(!wagons.isEmpty()){
            return wagons.removeLast();
        } else {
            throw new IndexOutOfBoundsException("No wagons available");
        }
    }

    public static void main(String[] args) {
        TrainComposition2 train = new TrainComposition2();
        train.attachWagonFromLeft(7);
        train.attachWagonFromLeft(13);
        System.out.println(train.detachWagonFromRight()); // 7
        System.out.println(train.detachWagonFromLeft()); // 13
    }
}
