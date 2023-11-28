package com.example.mathprojectarielmazuz;

import java.util.Random;

public class Exercise {
    private int num1;
    private int num2;
    private int result;

    public Exercise(){}

    public void random1(){
        Random r1 = new Random();
        this.num1 = r1.nextInt(10)+ 0;
        this.num2 = r1.nextInt(10)+ 0;
        result = num1*num2;
    }
    public void random2(){
        Random r1 = new Random();
        this.num1 = r1.nextInt(10);
        this.num2 = r1.nextInt(10)+ 10;
        result = num1*num2;
    }

    public void random3(){
        Random r1 = new Random();
        this.num1 = r1.nextInt(10);
        this.num2 = r1.nextInt(90)+ 10;
        result = num1*num2;
    }

    public boolean isGoodAnswer(String answer){
        int ans = Integer.valueOf(answer);
        if(ans == result) {
            return true;
        }
        else {
            return false;
        }
    }

    public int getNum1() {
        return num1;
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public int getNum2() {
        return num2;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }
}
