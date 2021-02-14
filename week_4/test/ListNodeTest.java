package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;

import homework.ListNode;
    
public class ListNodeTest {

    @Test
    public void addTest() {
        ListNode headNode = new ListNode();
        ListNode dataNode = new ListNode(10);
        ListNode newDataNode = new ListNode(20);

        assertEquals(10, headNode.add(headNode,dataNode,1).data );
        assertEquals(20, headNode.add(headNode,newDataNode,1).data );
    }

    @Test
    public void removeTest(){
        ListNode headNode = new ListNode();
        for(int i=1; i<5; i++){
            headNode.add(headNode, new ListNode(i-1), (i-1));
        }
        assertEquals(2, headNode.remove(headNode,2).data);

    }

    @Test
    public void containsTest(){
        ListNode headNode = new ListNode();
        ListNode containNode1 = new ListNode(5);

        headNode.add(headNode,containNode1,1);

        assertTrue(headNode.contains(headNode, containNode1 ));
        assertFalse(headNode.contains(headNode, new ListNode(5)));

    }
}
    