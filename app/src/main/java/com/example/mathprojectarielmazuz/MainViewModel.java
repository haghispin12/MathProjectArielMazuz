package com.example.mathprojectarielmazuz;

import androidx.lifecycle.MutableLiveData;

import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {
    MutableLiveData<Integer> vNum1;
    MutableLiveData<Integer> vNum2;
    Exercise exercise2;
    User NUser;
    MutableLiveData<Integer> vScore;



    public MainViewModel(){
        NUser = new User();
        exercise2 = new Exercise();
        vNum1 = new MutableLiveData<>();
        vNum2 = new MutableLiveData<>();
        vScore = new MutableLiveData<>();

    }


    public boolean vCheck(String str, int state){
        boolean bool = exercise2.isGoodAnswer(str);
        if (bool){
            if (state == 1){
                NUser.setScore(NUser.getScore()+5);}
            else if (state == 2){
                NUser.setScore(NUser.getScore()+10);}
            else if (state == 3){
                NUser.setScore(NUser.getScore()+20);}

        }
        vScore.setValue(NUser.getScore());

        return bool;
    }


    public void vEtgar(){
        exercise2.random3();
        vNum1.setValue(exercise2.getNum1());
        vNum2.setValue(exercise2.getNum2());

    }

    public void vUp20(){
        exercise2.random2();
        vNum1.setValue(exercise2.getNum1());
        vNum2.setValue(exercise2.getNum2());
    }

    public void vluachKefel(){
        exercise2.random1();
        vNum1.setValue(exercise2.getNum1());
        vNum2.setValue(exercise2.getNum2());
    }

    public void setUserName(String name){
        NUser.setUser_Name(name);
    }

    public User getNUser() {
        return NUser;
    }

    public void setNUser(User NUser) {
        this.NUser = NUser;
    }

    public MutableLiveData<Integer> getvNum1() {
        return vNum1;
    }

    public void setvNum1(MutableLiveData<Integer> vNum1) {
        this.vNum1 = vNum1;
    }

    public MutableLiveData<Integer> getvNum2() {
        return vNum2;
    }

    public void setvNum2(MutableLiveData<Integer> vNum2) {
        this.vNum2 = vNum2;
    }

    public Exercise getExercise2() {
        return exercise2;
    }

    public void setExercise2(Exercise exercise2) {
        this.exercise2 = exercise2;
    }
}
