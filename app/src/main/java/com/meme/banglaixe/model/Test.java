package com.meme.banglaixe.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Test implements Serializable {
    public static Test test;
    private ArrayList<Piece> pieceArrayList;

    public Test() {
        pieceArrayList = new ArrayList<Piece>();
    }

    public ArrayList<Piece> getPieceArrayList() {
        return pieceArrayList;
    }

    public void setPieceArrayList(ArrayList<Piece> pieceArrayList) {
        this.pieceArrayList = pieceArrayList;
    }
}
