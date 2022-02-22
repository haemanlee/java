package whiteship.list;

import java.util.HashMap;

public class LRUCache {
    HashMap<Integer,Node> map = new HashMap<Integer,Node>();
   
    // assume that max 10 pages can be stored in a cache   
    int capacity;
    // number of pages that are currently present in cache
    int count = 0;
    Node head = null;
    Node end = null;
    LRUCache(int capacity){
      this.capacity = capacity;
    }
    void deQueueNode(){  
      // check if queue empty
      if(count == 0){
         return ;
      }
      // if there is only one Node in the queue
      if(count == 1){
        head = end = null;
      }
      end = end.prev;
      end.next = null;
      count--;
    }
    // updates the head of the doubly linked list queue (i.e. cache)
    void setHead(Node n){
      n.next = head;
      n.prev = null;
      if(head != null){
        head.prev = n;
      }
      head = n;
    }
    // add the node to the doubly linked list queue (i.e. cache)
    Node enQueueNode(int key){
      Node temp;
      // the cache is full, remove rear node and add node to front
      if(count == capacity){
       map.remove(end.key);
       deQueueNode();
      }
      temp = new Node(key);
      setHead(temp);
      return temp;
    }
    void remove(Node n){
      n.prev.next = n.next;
      if(n.next != null){
       n.next.prev = n.prev;
      } else{
       end = n.prev;
      }
    }
    Node ReferencePage(int key){
      Node temp;
      // check if the page exists in cache else get it from memory             and update the cache
      if(map.containsKey(key)){
        temp = map.get(key);
        if(temp != head){
         remove(temp);
         setHead(temp);
        }
      } else{
         temp = enQueueNode(key);
         map.put(key, temp);
      }
      return temp;
    }
    public static void main(String args[]){
      LRUCache cache = new LRUCache(4);
      cache.ReferencePage(1);
      cache.ReferencePage(2);
      cache.ReferencePage(3);
      cache.ReferencePage(1);
      cache.ReferencePage(4);
      cache.ReferencePage(5);
      System.out.println("Head of cache " + cache.head.key);
      System.out.println("Next of cache head " + cache.head.next.key);
      System.out.println("End of cache " + cache.end.key);
    }
}
