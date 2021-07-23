package com.example.algorithm.tree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LonggestNums {

    public static void main(String[] args) {
        int[] mm = {5,6,10,2,4,3};
        getLonggestNum(mm);
        HashMap<String, String> kk = new HashMap<>();
    }


    public static int longestConsecutive(int[] nums) {
        Set<Integer> num_set = new HashSet<Integer>();
        for (int num : nums) {
            num_set.add(num);
        }

        int longestStreak = 0;

        for (int num : num_set) {
            if (!num_set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (num_set.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }
    public int singleNums(int[] nums){

        Set<Integer> mapResult = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            if(!mapResult.add(nums[i])){
                mapResult.remove(nums[i]);
            }
        }
        return  mapResult.iterator().next();

    }

    public static int getLonggestNum(int[] nums){

        HashMap<Integer, Integer> maps = new HashMap<>(nums.length);
        int len =nums.length;
        if(len == 0){
            return 0;
        }
        for(int i = 0; i < len; i++){
            maps.put(nums[i], nums[i]);
        }
        int max =1;
        for(int i =0; i < len; i++){
            int current = nums[i];
            // 存在左边界不可能是联系递增的
            if(maps.get(current - 1) != null){
                continue;
            }
            int currentLong = 0;
            for(;;){
                current = current +1;
                currentLong = currentLong + 1;
                if(maps.get(current) == null){
                    max = Math.max((currentLong), max);
                    break;
                }
            }
        }
        return max;
    }


}
