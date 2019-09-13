package com.rester.resterday.javaTest;

import com.alibaba.fastjson.JSON;

/**
 * @author ResterDay
 * @version 1.0
 * @date 2019/9/10 18:04
 * 输入8 输出[5,10]数组
 */
public class Test {
    /**
     * 数组固定值 5
     */
    private static int i = 5;
    public static void main(String[] args) {
        System.out.println(JSON.toJSONString(getIntArray(4)));
    }

    /**
     * n作为输入的值
     *
     * @param n
     * @return
     */
    public static int[] getIntArray(int n) {
        //根据输入值求出数组长度
        int j = n / 5;//求余数
        int m = n % 5;//求模
        int[] arrayX;
        //模不为0时，则j为数组长度，模为0，则j-1为数组长度,n小于等于5时，长度为1
        if (n <= 5) {
            arrayX=new int[]{5};
            return arrayX;
        } else if (m == 0) {
            arrayX=new int[j];
            for (int k = 0; k < j; k++) {
                arrayX[k] = i * k + 5;
            }
            return arrayX;
        } else {
            arrayX=new int[j+1];
            for (int k = 0; k < j+1; k++) {
                arrayX[k] = i * k +5;
            }
            return arrayX;
        }
    }
}
