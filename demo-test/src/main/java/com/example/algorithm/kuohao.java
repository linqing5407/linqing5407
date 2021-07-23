package com.example.algorithm;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class kuohao {


    public static void main(String[] args) {
        Queue queue = new LinkedList();
        Map<Character,Character> example = new HashMap<Character,Character>();
        example.put('(',')');
        example.put('{','}');
        example.put('[',']');
        example.put(')','(');
        example.put('}','{');
        example.put(']','[');

        Map<Character,Character> exampleExcept = new HashMap<Character,Character>();
        exampleExcept.put(')',')');
        exampleExcept.put('}','}');
        exampleExcept.put(']',']');
        isValid("(([]){})",example,exampleExcept);
    }

    public static boolean isValid(String s,Map<Character,Character> example,Map<Character,Character> exampleExcept) {
        int len = s.length();
        // 判断是否越界
        if (len < 2){
            return false;
        }
        // 判断是否奇数
        if ((len % 2) > 0){
            return false;
        }

        if (example.get(s.charAt(0)).equals(s.charAt(1))){
            for (int i = 0; i < len; i = i + 2){
                if(exampleExcept.containsKey(s.charAt(i))||!example.get(s.charAt(i)).equals(s.charAt(i+1))){
                    return false;
                }
            }
        }else{

            // 双指针判断
            int left = 0;
            int right = len - 1;
            while (left < right){
                char mm = s.charAt(left);
                boolean flag = exampleExcept.containsKey(mm);
                if(flag||!example.get(s.charAt(left)).equals(s.charAt(right))){
                    return false;
                }
                left++;
                right--;
            }


        }
        return true;
    }
}
