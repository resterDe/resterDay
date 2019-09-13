package com.rester.resterday.leetcode;

import java.util.Calendar;

/**
 * @author ResterDay
 * @version 1.0
 * @date 2019/9/11 16:02
 * 面试题
 * 给你一个日期，请你设计一个算法来判断它是对应一周中的哪一天。
 * 输入为三个整数：day、month 和 year，分别表示日、月、年。
 * 您返回的结果必须是这几个值中的一个 {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"}。
 *
 * 解答1：根据Calendar设置年月日，然后获取周几对应数组值输出
 * 解答2：计算输入的时间到1971年1月1日是星期几，再算出从今天距离多少天，取7的模
 */
public class Demo_1 {
    static String[] week=new String[]{"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
    public static void main(String[] args) {
        System.out.println(dayOfTheWeek(11,9,2019));
    }
    public static String dayOfTheWeek(int day,int month,int year){
        //获取Calendar实例，用来操作时间
        Calendar calendar=Calendar.getInstance();
        //设置年
        calendar.set(Calendar.YEAR,year);
        //设置月 注意月份下标从0开始，所以取月份要+1,设置月份要-1
        //比如设置9月份，要8，然后取出来，8+1=9
        calendar.set(Calendar.MONTH,month-1);
        //设置日
        calendar.set(Calendar.DAY_OF_MONTH,day);
        //calendar.get(Calendar.DAY_OF_WEEK)获取周几
        return week[calendar.get(Calendar.DAY_OF_WEEK)-1];
    }
}
