package com.meme.banglaixe.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import static com.meme.banglaixe.sqlite.SQLiteConstant.CREATETABLERECORD;
import static com.meme.banglaixe.sqlite.SQLiteConstant.TABLERECORD;
import static com.meme.banglaixe.sqlite.SQLiteConstant.isDEBUG;


public class SQLiteHelper extends SQLiteOpenHelper {
    public SQLiteHelper(Context context) {
        super(context, "DB.Record", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATETABLERECORD);
        if (isDEBUG) Log.e("TABLERECORD", CREATETABLERECORD);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLERECORD);
    }
}
