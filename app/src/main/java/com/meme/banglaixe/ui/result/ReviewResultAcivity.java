package com.meme.banglaixe.ui.result;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.meme.banglaixe.R;
import com.meme.banglaixe.model.Test;

import java.util.ArrayList;

public class ReviewResultAcivity extends AppCompatActivity {

    private Test test;
    private Button btnSum;
    private Button btnTrue;
    private Button btnFalse;
    private Button btnMiss;
    private TextView time;
    private TextView danhgia;
    private TextView diem;
    private ArrayList<String> listKey;
    private ArrayList<String> listAnwer;
    private FragmentTransaction fragmentTransaction;
//    private ReviewFragment reviewFragment;



    private TextView tvReviewTime;
    private TextView tvReviewDanhGia;
    private TextView tvReviewDiem;
    private Button tvReviewSum;
    private Button tvReviewTrue;
    private Button tvReviewFalse;
    private Button tvReviewMiss;
    private FrameLayout containerFragment;





    public void initiView() {

        tvReviewTime = (TextView) findViewById(R.id.tvReviewTime);
        tvReviewDanhGia = (TextView) findViewById(R.id.tvReviewDanhGia);
        tvReviewDiem = (TextView) findViewById(R.id.tvReviewDiem);
        tvReviewSum = (Button) findViewById(R.id.tvReviewSum);
        tvReviewTrue = (Button) findViewById(R.id.tvReviewTrue);
        tvReviewFalse = (Button) findViewById(R.id.tvReviewFalse);
        tvReviewMiss = (Button) findViewById(R.id.tvReviewMiss);
        containerFragment = (FrameLayout) findViewById(R.id.containerFragment);

        btnSum.setText("30");
        btnTrue.setText(getCountTrue() + "");
        btnFalse.setText(getCountFalse() + "");
        btnMiss.setText(getCountMiss() + "");
    }

    public String getTime() {
        int time = getIntent().getIntExtra("timedo", 0);
        int minute = time / 60;
        int second = time % 60;
        return minute + ":" + second;
    }

    public int getCountTrue() {
        int diem = 0;
        for (int i = 0; i < listAnwer.size(); i++) {
            if (listAnwer.get(i).equals(listKey.get(i))) {
                diem++;
            }
        }
        return diem;
    }

    public int getCountFalse() {
        return 30 - getCountTrue() - getCountMiss();
    }

    public int getCountMiss() {
        int diem = 0;
        for (int i = 0; i < listAnwer.size(); i++) {
            if (listAnwer.get(i).equals("")) {
                diem++;
            }
        }
        return diem;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_result_acivity);
        listKey = getIntent().getStringArrayListExtra("key");
        listAnwer = getIntent().getStringArrayListExtra("dapan");
        initiView();
        time.setText(getTime());
        if (getCountTrue() >= 26) {
            danhgia.setText("Bạn đạt yêu cầu");
        } else {
            danhgia.setText("Bạn không đạt yêu cầu");
        }
        diem.setText(getCountTrue() + "/30");
        test = Test.test;
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
//        reviewFragment = new ReviewFragment(test, "sum", listKey, listAnwer);
//        fragmentTransaction.add(R.id.containerFragment, reviewFragment);
        fragmentTransaction.commit();
//        btnSum.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                fragmentTransaction = getSupportFragmentManager().beginTransaction();
//                fragmentTransaction.replace(R.id.containerFragment, new ReviewFragment(test, "sum", listKey, listAnwer));
//                fragmentTransaction.commit();
//            }
//        });
//        btnTrue.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                fragmentTransaction = getSupportFragmentManager().beginTransaction();
//                fragmentTransaction.replace(R.id.containerFragment, new ReviewFragment(test, "true", listKey, listAnwer));
//                fragmentTransaction.commit();
//            }
//        });
//        btnFalse.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                fragmentTransaction = getSupportFragmentManager().beginTransaction();
//                fragmentTransaction.replace(R.id.containerFragment, new ReviewFragment(test, "false", listKey, listAnwer));
//                fragmentTransaction.commit();
//            }
//        });
//        btnMiss.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                fragmentTransaction = getSupportFragmentManager().beginTransaction();
//                fragmentTransaction.replace(R.id.containerFragment, new ReviewFragment(test, "miss", listKey, listAnwer));
//                fragmentTransaction.commit();
//            }
//        });


    }

}
