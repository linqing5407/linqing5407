package com.example.algorithm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SpiltWord {


    public static void main(String[] args) {
        List<String> wordDict = new ArrayList<>();
        wordDict.add("1");
        wordDict.add("34");
        wordDict.add("12");

        Set<String> dict = new HashSet<>(wordDict);

        boolean mm =  dfs( "1234", dict);
        mm =mm;
    }
    public static boolean dfs(String s,Set<String> set){

        if(s.length() == 0){
            return true;
        }
        StringBuilder strb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            strb.append(s.charAt(i));
            if(set.contains(strb.toString())){
                boolean flag = dfs(s.substring(i + 1),set);
                if(flag){
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean dfs(String s, Set<String> dict,Set<String> memonry){

        if(s.length() == 0){
            return true;
        }
        StringBuilder currentStr =new StringBuilder();
        for(int i =0; i < s.length(); i++){
            currentStr.append(s.charAt(i));
            System.out.println(currentStr.toString());
            if(memonry.contains(currentStr.toString())){
                return false;
            }
            if(dict.contains(currentStr.toString()) && !memonry.contains(s.substring(i + 1))){
                boolean flag = dfs(s.substring(i + 1), dict, memonry);
                if(flag == true){
                    return true;
                }else{
                    memonry.add(s.substring(i + 1));
                }
            }
        }
        memonry.add(s);
        return false;

    }
}
