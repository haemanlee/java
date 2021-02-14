package homework;

//정적인 어레이
//+구현이 쉽다 -고정된 Queue 크기

//동적인 어레이
//+자유로운 크기 -구현이 어려움

//Enqueue : Queue에서 값을 집어넣는다.
//Dequeue : Queue에서 값을 꺼내는 함수
//Empty : Queue가 비었는지 확인한다.

//Queue의 다른 형식
//1.Circular Queue
//2.Priorty Queue

//과제 5. Queue를 구현하세요.
public class Queue implements Queueable {
    //배열을 사용해서 한번
    int[] queue;
    int head, tail;
    
    public Queue(int capacity) {
        this.queue = new int[capacity];
        this.head = -1;
        this.tail = 0;
      }
    
      @Override
      public void enqueue(int data) {
        this.queue[++this.head] = data;
      }
    
      @Override
      public int dequeue() {
        if (this.tail > this.head) throw new IndexOutOfBoundsException();
        return this.queue[this.tail++];
      }
}
