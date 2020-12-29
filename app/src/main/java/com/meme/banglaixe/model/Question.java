package com.meme.banglaixe.model;

import java.io.Serializable;

public class Question implements Serializable {
    private String text;
    private String image;//link của bức ảnh

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
