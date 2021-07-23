package com.example.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeAdd {


    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        int[] mm = {-1,0,1,2,-1,-4};
        //int[] mm = {-2,-3,0,0,-2};
        threeSum(mm);
    }


    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int len = nums.length;
        // 长度小于上直接返回
        if(len < 3) {
            return result;
        }
        Arrays.sort(nums);
        // 第一层循环获取目标值
        for (int i = 0; i<len ; i++){

            if (i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            // 后面的两数之和 等于总和减去首位 后面通过双指针找到所有复合条件的和为target
            int target = 0 - nums[i];
            // 获取左右指针
            int right = len - 1;
            int left = i + 1;
            while (left < right){
                // 如果相等记录数组
                if(nums[left] + nums[right] == target){
                    List<Integer> currentList = new ArrayList<Integer>();
                    currentList.add(nums[i]);
                    currentList.add(nums[left]);
                    currentList.add(nums[right]);
                    result.add(currentList);
                    while (left < right && nums[right] == nums[right-1]){
                        right--;
                    }
                    right--;
                    continue;
                }
                // 如果大于目标说明值过大 右边指针左移取小点的值 过滤掉重复的
                if (nums[left] + nums[right] > target){
                    while (left < right && nums[right] == nums[right-1]){
                        right--;
                    }
                    right--;
                    continue;
                }
                // 如果小于目标值说明和太小 左指针右移获得大的数 过滤掉重复的
                if (nums[left] + nums[right] < target){
                    while (left < right && nums[left] == nums[left+1]){
                        left++;
                    }
                    left++;
                    continue;
                }
            }

        }

        return result;
    }
}
