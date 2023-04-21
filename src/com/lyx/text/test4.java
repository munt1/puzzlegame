package com.lyx.text;

import java.util.Random;
//生成随机验证码
public class test4 {
    public static void main(String[] args) {
        //生成验证码
//        放到数组中，然后随机抽取索引。
//        1.大写字母、小写字母放到数组中

        char[] chars = new char[52];
        for (int i = 0; i < chars.length; i++) {
            if (i <= 25) {
                chars[i] =(char)(97 + i);
            }else {
                chars[i] =(char)(65 + i - 26);
            }
        }


        for (int i = 0; i < chars.length; i++) {
            System.out.print(chars[i]);

        }
        System.out.println("\n");
//        2.随机抽取4次
        //记录最终结果
        String result ="";

        //获取随机索引
        Random random = new Random();
        for (int i = 0; i < 4; i++) {
            int randomIndex = random.nextInt(chars.length);
            //利用随机索引获取对应元素
//            System.out.println(chars[randomIndex]);
            result = result + chars[randomIndex];
        }

//        3.随机抽取一个数字

        int number = random.nextInt(99);


        result = result + number;

        System.out.println(result);














    }













}
