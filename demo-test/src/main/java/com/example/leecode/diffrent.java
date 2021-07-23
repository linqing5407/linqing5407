package com.example.leecode;

import java.util.*;

public class diffrent {

    public static void main(String[] args) {

        //abcabcbb
        String s ="abcabcbb";
      System.out.println(lengthOfLongestSubstringMove(s));
    }


    public static int lengthOfLongestSubstring(String m) {
        int maxLength = 0;
        int size = m.length();
        List<Character> list = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            list.add(m.charAt(i));
            for (int j = i + 1; j < size; j++) {
                if (list.contains(m.charAt(j))) {
                    break;
                } else {
                    list.add(m.charAt(j));
                }
            }
            if (maxLength < list.size()) {
                maxLength = list.size();
            }
            list.clear();
        }
        return maxLength;
    }


    public static int lengthOfLongestSubstringMap(String m) {
        int maxLength = 0;
        int size = m.length();
        Set<Character> map = new HashSet<>();
        for (int i = 0; i < size; i++) {
            if (maxLength >= size - i) {
                return maxLength;
            }
            map.add(m.charAt(i));
            for (int j = i + 1; j < size; j++) {
                if (!map.add(m.charAt(j))) {
                    break;
                }
            }
            if (maxLength < map.size()) {
                maxLength = map.size();
            }
            map.clear();
        }
        return maxLength;
    }

    //abcabcbb
    //01234567
    //滑动窗口方法  left左边下班  right右边下标
    public static int lengthOfLongestSubstringMove(String str) {
        int maxLength = 0;
        int size = str.length();
        Set<Character> map = new HashSet<>();
        for(int left=0, right=0;right<size;){
            if(map.contains(str.charAt(right))){
                if(maxLength<map.size()){
                    maxLength = map.size();
                }
                map.remove(str.charAt(left));
                left++;
            }else{
                map.add(str.charAt(right));
                right++;
            }
        }
        if(maxLength<map.size()){
            maxLength = map.size();
        }
        return maxLength;
    }

}
