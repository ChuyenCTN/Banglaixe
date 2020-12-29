package com.meme.banglaixe.model;

import java.io.Serializable;
import java.util.ArrayList;


public class Answer implements Serializable {
    private ArrayList<String> stringArrayList;
    public Answer(){
        stringArrayList = new ArrayList<String>();
    }

    public ArrayList<String> getStringArrayList() {
        return stringArrayList;
    }

    public void setStringArrayList(ArrayList<String> stringArrayList) {
        this.stringArrayList = stringArrayList;
    }
}
