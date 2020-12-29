package com.meme.banglaixe.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.demo.banglaixe.ui.main.MainActivity;
import com.meme.banglaixe.R;
import com.meme.banglaixe.common.Constant;
import com.meme.banglaixe.common.MyData;
import com.meme.banglaixe.model.Answer;
import com.meme.banglaixe.model.Key;
import com.meme.banglaixe.model.Piece;
import com.meme.banglaixe.model.Question;
import com.meme.banglaixe.model.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class SplashActivity extends AppCompatActivity {

    private ArrayList<Test> testArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Thread(new Runnable() {
            @Override
            public void run() {
                LoadDataForArrayTest();
            }
        }).start();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                finish();
            }
        }, Constant.SPLASH_DURATION);

    }

    public void LoadDataForArrayTest() {
        init();
        String data = null;
        String key = null;
        InputStreamReader inputStreamReaderquestion = null;
        InputStreamReader inputStreamReaderkey = null;

        BufferedReader bufferedReaderquestion = null;
        BufferedReader bufferedReaderkey = null;
        try {
            inputStreamReaderquestion = new InputStreamReader(getAssets().open("data/questions.csv"));
            inputStreamReaderkey = new InputStreamReader(getAssets().open("data/dapan.txt"));
            bufferedReaderquestion = new BufferedReader(inputStreamReaderquestion);
            bufferedReaderkey = new BufferedReader(inputStreamReaderkey);
            for (int i = 0; i < 30; i++) {
                for (int j = 0; j < 15; j++) {
                    data = bufferedReaderquestion.readLine();
                    key = bufferedReaderkey.readLine();
                    assignData(data, key, j);
                }
            }
            bufferedReaderquestion.close();
            inputStreamReaderquestion.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void init() {
        testArrayList = new ArrayList<Test>();
        for (int i = 0; i < 15; i++)
            testArrayList.add(new Test());
        MyData.getInstance().setTestArrayList(testArrayList);
    }

    public void assignData(String data, String key, int x) {
        String[] arrayData = data.split("[|]");
        Question question = new Question();
        Answer answer = new Answer();
        Piece piece = new Piece();
        Key _key = new Key();
        _key.setKey(key);
        question.setText(arrayData[0]);
        question.setImage(arrayData[5]);
        int i;
        for (i = 1; i < arrayData.length; i++) {
            if (arrayData[i].length() > 3)
                answer.getStringArrayList().add(arrayData[i]);
        }
        piece.setPart_question(question);
        piece.setPart_answer(answer);
        piece.setPart_key(_key);
        testArrayList.get(x).getPieceArrayList().add(piece);

    }

}