package com.example.sbadmin01;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class 약수 {

    @Test
    public static void main(String[] args) {
        long test = 12345;

        for(int i =0; i < 5; i++){
            log.info(""+String.valueOf(test).charAt(i));

        }
    }

    public int 약수합구하기(int n){
        int answer = 0;
        for(int i=1; i <= n; i++){
            if(n % i == 0) {
                answer+= i;
            }
        }
        return answer;
    }
}
