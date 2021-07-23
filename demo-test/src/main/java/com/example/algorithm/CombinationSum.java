package com.example.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {




    public static void main(String[] args) {
        List<List<Integer>> listResult =combinationSum(new int[]{2,1},3);
        System.out.println(listResult.toString());

//        for(int i = 0; i < 2; i++){
//            mm(i);
//            System.out.println(i);
//        }


    }

//    public static void mm(int i){
//        if(i == 0){
//            return;
//        }
//
//    }
    /**
     *
     * candidates = [2,3,6,7], target = 7,
     *
     * @param candidates 原始数组
     * @param target 目标值
     * 排序 便于后续剪枝 大于目标值的后面剪值
     * dfs 递归 回朔
     * 剪枝
     */
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> listResult = new ArrayList<List<Integer>>();
        if(candidates.length == 0){
            return listResult;
        }
        List<Integer> currentList = new ArrayList<Integer>();
        // 排序便于后续加和数据值 为0  或者超过了就直接剪枝回朔
        Arrays.sort(candidates);
        dfs(listResult, currentList, candidates, target, 0);
        return listResult;
    }
    public static void dfs(List<List<Integer>> listResult, List<Integer> currentList, int[] candidates, int target ,int start) {

        // 目标值小于0
        if(target < 0){
            return;
        }
        if(target == 0){
            listResult.add(new ArrayList<>(currentList));
            return;
        }
        // target 余下的数组是自增的 如果余下的值大于，余下的目标值就没必要继续了 剪枝  i = start 过滤前面已经匹配过的数据但是每次递归还是可以选择自己的
        for(int i =start; i < candidates.length; i++) {
            // 剪枝后面的值比 目标值还大的时候就没必要继续了 剪枝
            if(candidates[i] > target){
                break;
            }
            currentList.add(candidates[i]);

            dfs(listResult, currentList, candidates, target - candidates[i], i);
            // 回朔到上一层
            currentList.remove(currentList.size() - 1);
        }

    }
}
