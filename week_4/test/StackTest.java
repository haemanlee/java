package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import homework.Stack;

public class StackTest {

    Stack stack; 

    @Test
    public void pushTest(){
        stack = new Stack(); 
        this.stack.push(3);
        this.stack.push(2);
        this.stack.push(1);
        
        assertEquals(1, stack.pop());
        assertEquals(2, stack.pop());
        assertEquals(3, stack.pop());
    }
    @Test
    public void popTest(){

        stack = new Stack(); 
        this.stack.push(100);
        this.stack.push(200);
        this.stack.push(300);
        
        assertEquals(300, stack.pop());
        assertEquals(200, stack.pop());
        assertEquals(100, stack.pop());
    }
}
