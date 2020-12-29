package com.meme.banglaixe.sqlite;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.google.gson.Gson;
import com.meme.banglaixe.model.TopWrong;

import java.util.ArrayList;
import java.util.List;

import static com.meme.banglaixe.sqlite.SQLiteConstant.ID;
import static com.meme.banglaixe.sqlite.SQLiteConstant.QUESTION;
import static com.meme.banglaixe.sqlite.SQLiteConstant.TABLERECORD;


public class RecordWrongDAO {

    private SQLiteDatabase sqLiteDatabase;
    private SQLiteHelper sqliteHelper;

    public RecordWrongDAO(SQLiteHelper sqliteHelper) {
        this.sqliteHelper = sqliteHelper;
    }

    public long insertRecord(String record) {
        if (record != null && !record.isEmpty())
            sqLiteDatabase = sqliteHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(QUESTION, record);
        long result = sqLiteDatabase.insert(TABLERECORD, null, values);
        sqLiteDatabase.close();
        return result;
    }

    public List<TopWrong> getAllRecord() {
        sqLiteDatabase = sqliteHelper.getWritableDatabase();
        List<TopWrong> records = new ArrayList<>();
        String GETALLRECORD = "SELECT * FROM " + TABLERECORD;
        Cursor cursor = sqLiteDatabase.rawQuery(GETALLRECORD, null);
        if (cursor != null & cursor.getCount() > 0) {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                int id = cursor.getInt(cursor.getColumnIndex(ID));
                String data = cursor.getString(cursor.getColumnIndex(QUESTION));
                TopWrong topWrong = new Gson().fromJson(data, TopWrong.class);
                records.add(topWrong);
                cursor.moveToNext();
            }
            cursor.close();
            sqLiteDatabase.close();
        }
        return records;
    }

}
