package com.meme.banglaixe.model;

import android.widget.CheckBox;

import java.io.Serializable;
import java.util.ArrayList;

public class Piece implements Serializable {
    private Question part_question;
    private Answer part_answer;
    private Key part_key;
    private ArrayList<CheckBox> checkBoxes;
    public Piece(){
        checkBoxes = new ArrayList<CheckBox>();
    }

    public ArrayList<CheckBox> getCheckBoxes() {
        return checkBoxes;
    }

    public void setCheckBoxes(ArrayList<CheckBox> checkBoxes) {
        this.checkBoxes = checkBoxes;
    }

    public Question getPart_question() {
        return part_question;
    }

    public void setPart_question(Question part_question) {
        this.part_question = part_question;
    }

    public Answer getPart_answer() {
        return part_answer;
    }

    public void setPart_answer(Answer part_answer) {
        this.part_answer = part_answer;
    }

    public Key getPart_key() {
        return part_key;
    }

    public void setPart_key(Key part_key) {
        this.part_key = part_key;
    }
}
