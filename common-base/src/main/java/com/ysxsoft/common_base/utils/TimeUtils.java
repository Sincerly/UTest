package com.ysxsoft.common_base.utils;

public class TimeUtils {
    public static void main(String[] args){
        System.out.println(getGenreByYear(2019));
    }

    /**
     * 根据年限获取属相
     * @param year
     * @return
     */
    public static String getGenreByYear(int year) {
        String sx = null;
        switch (year % 12) {
            case 4:
                sx = "鼠";
                break;
            case 5:
                sx = "牛";
                break;
            case 6:
                sx = "虎";
                break;
            case 7:
                sx = "兔";
                break;
            case 8:
                sx = "龙";
                break;
            case 9:
                sx = "蛇";
                break;
            case 10:
                sx = "马";
                break;
            case 11:
                sx = "羊";
                break;
            case 0:
                sx = "猴";
                break;
            case 1:
                sx = "鸡";
                break;
            case 2:
                sx = "狗";
                break;
            case 3:
                sx = "猪";
                break;
        }
        return sx;
    }

}
