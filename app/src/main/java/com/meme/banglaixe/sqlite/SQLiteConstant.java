package com.meme.banglaixe.sqlite;

public class SQLiteConstant {

    public final static boolean isDEBUG = true;

    public final static String QUESTION = "question";
    public final static String ID = "id";
    public final static String TABLERECORD = "record_question_wrong";

    public final static String CREATETABLERECORD = "CREATE TABLE " + TABLERECORD + " (" +
            "" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT ," +
            "" + QUESTION + " TEXT " +
            ")";
}
