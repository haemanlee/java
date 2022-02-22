package whiteship.list;

class Node{
   
    int key; 
    
    //pointer to the previous node
    Node prev;
    //pointer to the next node
    Node next;
    Node(int key){
      this.key = key;
    }
 }