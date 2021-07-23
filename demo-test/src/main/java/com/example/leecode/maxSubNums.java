package com.example.leecode;

import java.util.Iterator;
import java.util.List;

public class maxSubNums {

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        maxSubArray(nums);
    }


    public static int maxSubArray(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int max = nums[0];
        for(int i = 0; i < nums.length ; i++){
            int current = nums[i];
            if(current > max){
                max =current;
            }
            for( int j = i+1; j< nums.length ;j++){
                current = current + nums[j];
                if(current > max){
                    max =current;
                }
            }
        }

        return max;
    }

    class Solution {
        public int maxSubArray(int[] nums) {
            int pre = 0, maxAns = nums[0];
            for (int x : nums) {
                pre = Math.max(pre + x, x);
                maxAns = Math.max(maxAns, pre);
            }
            return maxAns;
        }
    }

    public  void itrata(List<String> list){

        Iterator<String> it = list.iterator();
        while (it.hasNext()){
            it.remove();
        }

    }
}
