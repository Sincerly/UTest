package com.ysxsoft.common_base.utils;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * create by Sincerly on 2019/3/1 0001
 **/
public class AndroidUtils {
    /**
     * 系统总内存
     */
    public static float getTotalMemory() {
        String str1 = "/proc/meminfo";
        String str2;
        String[] arrayOfString;
        long initial_memory = 0;
        try {
            FileReader fileReader = new FileReader(str1);
            BufferedReader bufferedReader = new BufferedReader(fileReader, 8192);
            str2 = bufferedReader.readLine();
            arrayOfString = str2.split("\\s+");
            initial_memory = Integer.valueOf(arrayOfString[1]);
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (float) (initial_memory / 1024);
    }
}
