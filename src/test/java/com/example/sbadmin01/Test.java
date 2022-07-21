package com.example.sbadmin01;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        for(int i = 0; i < 20; i ++){
            System.out.println("["+i+"] : " + i);
            System.out.println("["+i+"] : " + ((i%2 == 0) ? "짝수" : "홀수"));

            if(i%2 == 0){ // 짝수
                System.out.println((i /2)%5);
            }else{ // 홀수
                // 1,3,5,7,9 홀수 2n+1
                System.out.println(((i-1)/2)%5);
            }
        }
    }

    public int checkWay3(int[] answers){
        int rtnCnt = 0;
        int[] repeatArr = {3,1,2,4,5};

        for(int i = 0; i< answers.length; i++){
            if(i % 2 == 1){ // 홀수
                System.out.println("["+i+"]:"+repeatArr[(i%5 -1)]);
            }else{ // 짝수
                System.out.println("["+i+"]:"+repeatArr[(i%5)]);
            }
        }
        return rtnCnt;
    }
}
