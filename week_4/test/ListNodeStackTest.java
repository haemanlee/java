package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import homework.ListNodeStack;

public class ListNodeStackTest {
    ListNodeStack stack;

    @Test
    public void pushTest(){
        this.stack = new ListNodeStack();

        stack.push(3);
        stack.push(2);
        stack.push(1);
        
        assertEquals(1, stack.pop());
        assertEquals(2, stack.pop());
        assertEquals(3, stack.pop());
    }

    @Test
    public void popTest(){
        this.stack = new ListNodeStack();

        stack.push(100);
        stack.push(200);
        stack.push(300);
        
        assertEquals(300, stack.pop());
        assertEquals(200, stack.pop());
        assertEquals(100, stack.pop());
    }
}
