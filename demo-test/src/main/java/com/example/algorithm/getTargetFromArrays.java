package com.example.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class getTargetFromArrays {


    public int[] getTargetFromArrays(int[] nums, int target){
        int right = nums.length - 1;
        int left = 0;
        int start = -1;
        int end = -1;

        if(right == -1){
            return new int[] {start,end};
        }
        while (left <= right) {
            int mid = (left + right) / 2;
            // 找到
            if(nums[mid] == target){
                start = mid;
                end = mid;
                // 数据可能重复都在周边遍历周报的值
                while((end + 1) <= right){
                    if(nums[end + 1] == target){
                        end ++;
                    }else{
                        break;
                    }
                }


                while(start - 1 >= left){
                    if(nums[start - 1] == target){
                        start--;
                    }else{
                        break;
                    }
                }

                  return new int[] {start,end};
            } else if(nums[mid] < target ){
                left = mid + 1;
            }else {
                right = mid - 1;
            }

        }


        return new int[] {-1,-1};

    }
}
