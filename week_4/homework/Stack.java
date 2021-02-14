package homework;

import java.util.ArrayList;
import java.util.List;

// 과제 3. Stack을 구현하세요.
//1.1차원 배열 : 구현이 상대적으로 쉬우나 인풋 사이즈를 미리 알아야함.
//2.리스트 : 구현이 상대적으로 어려우나 제한된 사이즈로부터 자유로움

// int 배열을 사용해서 정수를 저장하는 Stack을 구현하세요.
// void push(int data)를 구현하세요.
// int pop()을 구현하세요.
public class Stack implements Stackable{
    // int 배열을 사용해서 정수를 저장하는 Stack을 구현하세요.
    List<Integer> stack;

    public Stack(){
        this.stack = new ArrayList<>();
    }

    // void push(int data)를 구현하세요.
    @Override
    public void push(int data){
        this.stack.add(data);
    };
    // int pop()을 구현하세요.
    @Override
    public int pop(){
        int data;
        data =this.stack.get(this.stack.size()-1);
        this.stack.remove(this.stack.size()-1);
        return data;
    }
}
