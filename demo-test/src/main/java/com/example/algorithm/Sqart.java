package com.example.algorithm;

public class Sqart {

    /**
     *
     * 二分法计算平方根
     *
     * @param num 入参
     *
     */
    public static int squar(int num){
        int left = 0;
        int right = num;
        int ant = 0;
        while(left <= right){
            int mid = (left + right) / 2;
            if(mid * mid <= num){
                left = mid + 1;
                ant = mid;
            }else{
                right = mid - 1;
            }
        }
        return ant;
    }

    public static void main(String[] args) {
        squar(0);
    }

}
