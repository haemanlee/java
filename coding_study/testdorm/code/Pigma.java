package hello.proxy.hyper.coding_study.testdorm.code;

// To run the code at any time, please hit the run button located in the top left corner.

import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) {
        System.out.println(pigLatinize("pig")); // should print out "ig-pay"
    }

    // Implement this method:
    public static String pigLatinize(String phrase) {
        String rtn;
        String append;
        //1) move first char and suffix of "ay"
        String firstDigit = phrase.substring(0,1);

        if(isVowel(firstDigit)){
            append = "way";
        } else {
            append = firstDigit + "ay";
        }
        rtn = phrase.substring(1) + append;
        return rtn + " must be pig-latinized";
    }

    public static boolean isVowel(String digit){
        if(digit.contains("a") || digit.contains("e") || digit.contains("i") || digit.contains("u") || digit.contains("o")){
            return true;
        }
        return false;
    }
}