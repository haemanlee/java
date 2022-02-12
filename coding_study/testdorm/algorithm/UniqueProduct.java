package testdorm.algorithm;

import java.util.Stack;

public class UniqueProduct {
    public static String firstUniqueProduct(String[] products) {
        if(products == null || products.length < 2) return null;
        Stack<String> stack = new Stack<>();
        for (int i=0; i<products.length;i++){
            if(stack.contains(products[i])){
                return stack.pop();
            }
            stack.push(products[i]);
        }

        return null;
    }

    public static void main(String[] args) {
        System.out.println(firstUniqueProduct(new String[] { "Apple", "Computer", "Apple", "Bag"  }));
    }
}