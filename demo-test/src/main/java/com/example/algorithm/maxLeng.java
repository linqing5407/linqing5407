package com.example.algorithm;

import com.github.pagehelper.util.StringUtil;

import java.util.HashMap;

public class maxLeng {

    public static void main(String[] args) {
        String temp= "pwwpke";
        getDiffLength(temp);
    }
    public static int getDiffLength(String s){


//        if(StringUtil.isEmpty(s)){
//            return 0;
//        }
//
//        int left = 0;
//        int max = 0;
//        HashMap<Character , Integer> curentSet = new HashMap<Character , Integer>();
//        int length =s.length();
//        for(int i = 0; i < length; i++){
//            //"pwwpke";
//            if(curentSet.containsKey(s.charAt(i))){
//
//                left = Math.max(left , curentSet.get(s.charAt(i))+1);
//
//            }
//            max = Math.max(max,i - left +1);
//            curentSet.put(s.charAt(i) , i);
//
//        }
//
//
//        return max;
        int len = s.length();
        if(len == 0 ){
            return 0;
        }

        int left = 0;
        int max = 0;

        HashMap<Character , Integer> map =new HashMap<Character , Integer>(len);
        //pwwpktr
        for(int i = 0; i < len; i++ ){

            if(map.containsKey(s.charAt(i))) {
                //判断是否出现重复的
                //1、出现重复的时候左边位置平移到当前这个位置的后一个
                //2、如果这个位置是出现 当前左边这个位置的左边， 那么当前左边的位置不变 把前面出现过的平移到当前左边的后面

                left  = Math.max(left , map.get(s.charAt(i)+1));
            }
            //计算当前的长度 并取最大的子串
            max = Math.max(max , i - left + 1);
            map.put(s.charAt(i) , i);


        }


        return max;

    }
}
