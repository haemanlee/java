package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import homework.Queue;

public class QueueTest {
    
    Queue queue;

    @Test
    public void enqueueTest(){
        queue = new Queue(3);

        queue.enqueue(3);
        queue.enqueue(2);
        queue.enqueue(1);

        assertEquals(3, queue.dequeue());
        assertEquals(2, queue.dequeue());
        assertEquals(1, queue.dequeue());
    }

    @Test
    public void dequeueTest(){
        queue = new Queue(3);

        queue.enqueue(100);
        queue.enqueue(200);
        queue.enqueue(300);

        assertEquals(100, queue.dequeue());
        assertEquals(200, queue.dequeue());
        assertEquals(300, queue.dequeue());
    }
}
