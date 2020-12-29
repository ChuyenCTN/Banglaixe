package com.meme.banglaixe.ui.lamde;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import com.meme.banglaixe.R;
import com.meme.banglaixe.common.Constant;
import com.meme.banglaixe.model.Piece;

import java.io.IOException;
import java.io.InputStream;


public class QuestionFragment extends Fragment {

    private Piece piece;
    private int x;
    private boolean check_cau;
    private boolean[] ischeck;
    private boolean[] enable;
    private Button buttonBig;
    private Button buttonSmall;
    private LamDeThiActivity.ChangeStatesListener mStatesListiner;
    private int mPosition;

    @SuppressLint("ValidFragment")
    public QuestionFragment(int position, Piece piece, int x, Button buttonBig, Button buttonSmall, LamDeThiActivity.ChangeStatesListener statesListiner) {
        this.piece = piece;
        this.x = x;
        this.buttonBig = buttonBig;
        this.buttonSmall = buttonSmall;
        ischeck = new boolean[piece.getPart_answer().getStringArrayList().size()];
        enable = new boolean[piece.getPart_answer().getStringArrayList().size()];
        this.mPosition=position;
        this.mStatesListiner=statesListiner;

    }

    public void setmPosition(int mPosition) {
        this.mPosition = mPosition;
    }

    public QuestionFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_question, container, false);
        return view;

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // hiện thị câu hỏi
        LinearLayout linearLayout = (LinearLayout) getView().findViewById(R.id.fragmentquestion);
        TextView tvQuestion = new TextView(getContext());
        tvQuestion.setText(getContext().getResources().getString(R.string.txt_cau) + x + ":" + piece.getPart_question().getText());
        tvQuestion.setTextColor(Color.BLACK);
        tvQuestion.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
//        tvQuestion.setTextAppearance(R.style.QuestionText);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        tvQuestion.setLayoutParams(layoutParams);
        linearLayout.addView(tvQuestion);

        if (!piece.getPart_question().getImage().equals("")) {
            ImageView imageViewQuestion = new ImageView(getContext());
            LinearLayout.LayoutParams layoutParamsq = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            layoutParamsq.gravity = Gravity.CENTER_HORIZONTAL;
            imageViewQuestion.setLayoutParams(layoutParamsq);
            imageViewQuestion.setScaleType(ImageView.ScaleType.FIT_CENTER);
            layoutParams.setMargins(0, 0, 0, 0);
            InputStream inputStream = null;
            Bitmap bitmap = null;
            try {
                inputStream = getActivity().getAssets().open("images/" + piece.getPart_question().getImage() + ".png");
            } catch (IOException e) {
                e.printStackTrace();
            }
            bitmap = BitmapFactory.decodeStream(inputStream);
            imageViewQuestion.setImageBitmap(bitmap);
            imageViewQuestion.setAdjustViewBounds(true);
            linearLayout.addView(imageViewQuestion);
        }
        // hiện thị phần các câu trả lời
        piece.getCheckBoxes().clear();
        for (int i = 0; i < piece.getPart_answer().getStringArrayList().size(); i++) {
            CheckBox ckbAnswer = new CheckBox(getContext());
            ckbAnswer.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    for (int i = 0; i < piece.getCheckBoxes().size(); i++) {
                        if (mStatesListiner !=null){
                            mStatesListiner.changeColor(mPosition, Constant.STATE_QUESTION_TRUE);
                        }
//                        if (piece.getCheckBoxes().get(i).isChecked()) {
//                            if (!check_cau) {
//                                check_cau = true;
//                                LamDeThiActivity.indexQuestion++;
//                                LamDeThiActivity.tvDoneQuestion.setText(LamDeThiActivity.indexQuestion + "/30");
//                            }
//                            buttonBig.setBackgroundColor(Color.YELLOW);
//                            buttonSmall.setBackgroundColor(Color.YELLOW);
//                            return;
//                        }

                      Log.d("zxcvbnm,"," "+piece.getCheckBoxes().get(i).isChecked());
                      Log.d("zxcvbnm,"," "+piece.getCheckBoxes().get(i).getText());
                      Log.d("zxcvbnm,"," "+piece.getPart_key().getKey());
                    }
//                    if (check_cau) {
//                        check_cau = false;
//                        LamDeThiActivity.indexQuestion--;
//                        LamDeThiActivity.tvDoneQuestion.setText(LamDeThiActivity.indexQuestion + "/30");
//                    }

//                    Log.d("zxcvbnm, ", " "+piece.getCheckBoxes().get(i).isChecked());
//                    buttonBig.setBackgroundColor(Color.parseColor("#FFFFFF"));
//                    buttonSmall.setBackgroundColor(Color.parseColor("#B3E5FC"));
                    return;
                }
            });
            piece.getCheckBoxes().add(ckbAnswer);

//            if (savedInstanceState != null) {
//                ckbAnswer.setChecked(savedInstanceState.getBooleanArray("chẹck")[i]);
//                ckbAnswer.setEnabled(savedInstanceState.getBooleanArray("enable")[i]);
//                buttonBig.setBackgroundColor(savedInstanceState.getInt("colorbig"));
//                buttonSmall.setBackgroundColor(savedInstanceState.getInt("colorsmall"));
//
//            }
            ckbAnswer.setText(piece.getPart_answer().getStringArrayList().get(i));
            ckbAnswer.setTextColor(Color.BLACK);
            ckbAnswer.setTypeface(Typeface.DEFAULT_BOLD);
            LinearLayout.LayoutParams layoutParamsa = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            ckbAnswer.setLayoutParams(layoutParamsa);
            linearLayout.addView(ckbAnswer);
        }


    }
    // Lưu trạng thái của câu hỏi để nạp lại nếu như nó bị reload

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
//        for (int i = 0; i < piece.getPart_answer().getStringArrayList().size(); i++) {
//            ischeck[i] = piece.getCheckBoxes().get(i).isChecked();
//            enable[i] = piece.getCheckBoxes().get(i).isEnabled();
//        }

//        outState.putBooleanArray("chẹck", ischeck);
//        outState.putBooleanArray("enable", enable);
//        ColorDrawable colorDrawableBig = (ColorDrawable) buttonBig.getBackground();
//        ColorDrawable colorDrawableSmall = (ColorDrawable) buttonSmall.getBackground();
//        outState.putInt("colorbig", colorDrawableBig.getColor());
//        outState.putInt("colorsmall", colorDrawableSmall.getColor());

    }
}
