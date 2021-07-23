package com.example.algorithm;

import java.util.ArrayList;
import java.util.List;

public class AllNums {


    public static void main(String[] args) {
        List<List<Integer>> result =permute(new int[]{1,2,3});
        System.out.println(result);
    }

    public static List<List<Integer>> permute(int[] nums) {

        int len = nums.length;

        List<List<Integer>> listresult = new ArrayList<List<Integer>>();
        if(len == 0){
            return listresult;
        }

        List<Integer> currentList = new ArrayList<Integer>();
        // 构建一个对应数组， 记录已经一条路径上已经被使用的元素 数组初始默认都是false
        boolean[] used = new boolean[len];

        dfs(listresult, currentList, used, nums, 0);
        return listresult;
    }

    public static void dfs(List<List<Integer>> listresult, List<Integer> currentList, boolean[] used, int[] nums, int start){
        // 深度够了直接加入后返回
        if(start == (nums.length)){
            // 构建一个新的对象防止对象引用
            listresult.add(new ArrayList<>(currentList));
            return;
        }

        for(int i = 0; i < nums.length; i++) {
            // 判断数组是否被使用
            if(!used[i]){
                // 已经使用
                used[i] = true;
                currentList.add(nums[i]);
                dfs(listresult, currentList, used, nums, start + 1);
                // 回朔 将某个元素置为可用
                used[i] = false;
                // 移除队尾的元素回朔到上一层
                currentList.remove(currentList.size() - 1);
            }

        }
    }
}
