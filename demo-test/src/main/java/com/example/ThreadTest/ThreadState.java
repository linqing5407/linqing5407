package com.example.ThreadTest;

import java.util.Arrays;
import java.util.Collection;

public class ThreadState {

    /**
     *
     * 快速排序算法 {6,9,3,4,2,1,7,5}
     *
     * 找一个作为比较的基准值任取 , 我们这边取第一个
     * 进行分区 将第一个值放中间 左边放小于他的数，右边放大于他的数 区分开来
     * 继续分别对左右两边的数组重复上述操作，直到遍历完成排序结束
     * @params arrys 入参待排序数组
     * @params low 低位
     * @params hight 高位
     * @return arrys 排序后的结果
     */
    public static void quickSort (int[] array, int low, int hight) {
        // 递归中跳出的位置
        if(low >= hight){
            return ;
        }
        int pos = low;
        // 根据起始值分区 左边小于自己右边大于自己
        pos = partition(array, low, hight);
        // 左边的继续递归区分
        quickSort(array, low, pos - 1);
        // 右边的继续递归区分
        quickSort(array, pos + 1, hight);

    }
/**
 *
 *
 * @params arrys 入参待排序数组
 * @params low 低位
 * @params hight 高位
 *
 */
    public static int partition (int[] array, int low, int hight) {
        // 取第一位作为空位 占坑
        int posVal = array[low];

        while(hight > low){
            // 从高位开始遍历 ，发现大于自己的继续遍历， 直到小于自己的退出 将该值赋给低位 这时高位留空
            while(hight > low && array[hight] >= posVal) {
                hight--;
            }
            // 这时高为变为空位 要从低位开始遍历
            if(hight > low){
                array[low] = array[hight];
                low++;
            }
            // 从低位开始遍历 发现小于自己的继续遍历， 大于自己的与之前留空的高位交换 ，低位留空
            while(hight >low && array[low] <= posVal){
                low++;
            }
            //  大于自己的与之前留空的高位交换 ，低位留空
            if(hight > low){
                array[hight] = array[low];
                hight--;
            }
        }
        //补上之前寄存的位置
        if(hight == low){
            array[hight] = posVal;
        }
        return hight;
    }

    public static void main(String[] args) {
         int[] array = {6,9,3,4,2,1,7,5};
          //int[] array = {6,9,3,4};
        quickSort(array, 0, array.length-1);
        System.out.println(Arrays.toString(array));
    }
}
