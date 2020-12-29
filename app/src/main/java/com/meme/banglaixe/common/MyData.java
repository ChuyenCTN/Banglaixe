package com.meme.banglaixe.common;

import com.meme.banglaixe.model.Test;

import java.util.ArrayList;

public class MyData {

    private ArrayList<Test> testArrayList;

    private static MyData instance;

    public static MyData getInstance() {
        if (instance == null)
            instance = new MyData();
        return instance;
    }

    public ArrayList<Test> getTestArrayList() {
        return testArrayList;
    }

    public void setTestArrayList(ArrayList<Test> testArrayList) {
        this.testArrayList = testArrayList;
    }
}
