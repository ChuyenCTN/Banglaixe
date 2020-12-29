package com.meme.banglaixe.ui.lamde;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.google.gson.Gson;
import com.meme.banglaixe.R;
import com.meme.banglaixe.common.Constant;
import com.meme.banglaixe.common.MyData;
import com.meme.banglaixe.model.Key;
import com.meme.banglaixe.model.Piece;
import com.meme.banglaixe.model.StateQuestion;
import com.meme.banglaixe.model.Test;
import com.meme.banglaixe.model.TopWrong;
import com.meme.banglaixe.sqlite.RecordWrongDAO;
import com.meme.banglaixe.sqlite.SQLiteHelper;
import com.meme.banglaixe.ui.result.ReviewResultAcivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LamDeThiActivity extends AppCompatActivity implements View.OnClickListener {

    private DrawerLayout drawer;
    private Toolbar toolbar;
    public static TextView tvDoneQuestion;
    private TextView tvTime;
    private ViewPager viewpager;
    private Button btnPrevious;
    private Button btnNext;
    private Button ketthuc;
    private DrawerLayout drawerLayout;
    public ViewPager viewPager;
    private RecyclerView rcvStateQuestion;

    private int widthItem = 0;
    private List<StateQuestion> stateQuestionList;
    private StateQuestionAdapter stateQuestionAdapter;
    private ArrayList<Button> buttonArrayListBig;
    private ArrayList<Button> buttonArrayListSmall;
    private int positionCurrent;
    private int diemCurrent;
    private boolean[] booleen = new boolean[30];

    private int timeCount = 1200;
    private int mintue = timeCount / 60;
    private int second = timeCount % 60;

    private ArrayList<Fragment> fragmentArrayList;
    private Test test;
    private String title;
    private MenuItem menuDiem;

    private String mType = "";

    public static int indexQuestion = 0;
    public static int current = 0;
    private List<String> WrongQuestions;
    private ChangeStatesListener statesListener;


    public void initGUI() {
        rcvStateQuestion = (RecyclerView) findViewById(R.id.rcvStateQuestion);
        Button btnQuestionNav1;
        Button btnQuestionNav2;
        Button btnQuestionNav3;
        Button btnQuestionNav4;
        Button btnQuestionNav5;
        Button btnQuestionNav6;
        Button btnQuestionNav7;
        Button btnQuestionNav8;
        Button btnQuestionNav9;
        Button btnQuestionNav10;
        Button btnQuestionNav11;
        Button btnQuestionNav12;
        Button btnQuestionNav13;
        Button btnQuestionNav14;
        Button btnQuestionNav15;
        Button btnQuestionNav16;
        Button btnQuestionNav17;
        Button btnQuestionNav18;
        Button btnQuestionNav19;
        Button btnQuestionNav20;
        Button btnQuestionNav21;
        Button btnQuestionNav22;
        Button btnQuestionNav23;
        Button btnQuestionNav24;
        Button btnQuestionNav25;
        Button btnQuestionNav26;
        Button btnQuestionNav27;
        Button btnQuestionNav28;
        Button btnQuestionNav29;
        Button btnQuestionNav30;

        drawer = (DrawerLayout) findViewById(R.id.drawer);
        toolbar = (Toolbar) findViewById(R.id.toolbar);

        tvDoneQuestion = (TextView) findViewById(R.id.tvDoneQuestion);
        tvTime = (TextView) findViewById(R.id.tvTime);
        viewpager = (ViewPager) findViewById(R.id.viewpager);
        btnPrevious = (Button) findViewById(R.id.btnPrevious);
        btnNext = (Button) findViewById(R.id.btnNext);
        btnQuestionNav1 = (Button) findViewById(R.id.btnQuestionNav1);
        btnQuestionNav2 = (Button) findViewById(R.id.btnQuestionNav2);
        btnQuestionNav3 = (Button) findViewById(R.id.btnQuestionNav3);
        btnQuestionNav4 = (Button) findViewById(R.id.btnQuestionNav4);
        btnQuestionNav5 = (Button) findViewById(R.id.btnQuestionNav5);
        btnQuestionNav6 = (Button) findViewById(R.id.btnQuestionNav6);
        btnQuestionNav7 = (Button) findViewById(R.id.btnQuestionNav7);
        btnQuestionNav8 = (Button) findViewById(R.id.btnQuestionNav8);
        btnQuestionNav9 = (Button) findViewById(R.id.btnQuestionNav9);
        btnQuestionNav10 = (Button) findViewById(R.id.btnQuestionNav10);
        btnQuestionNav11 = (Button) findViewById(R.id.btnQuestionNav11);
        btnQuestionNav12 = (Button) findViewById(R.id.btnQuestionNav12);
        btnQuestionNav13 = (Button) findViewById(R.id.btnQuestionNav13);
        btnQuestionNav14 = (Button) findViewById(R.id.btnQuestionNav14);
        btnQuestionNav15 = (Button) findViewById(R.id.btnQuestionNav15);
        btnQuestionNav16 = (Button) findViewById(R.id.btnQuestionNav16);
        btnQuestionNav17 = (Button) findViewById(R.id.btnQuestionNav17);
        btnQuestionNav18 = (Button) findViewById(R.id.btnQuestionNav18);
        btnQuestionNav19 = (Button) findViewById(R.id.btnQuestionNav19);
        btnQuestionNav20 = (Button) findViewById(R.id.btnQuestionNav20);
        btnQuestionNav21 = (Button) findViewById(R.id.btnQuestionNav21);
        btnQuestionNav22 = (Button) findViewById(R.id.btnQuestionNav22);
        btnQuestionNav23 = (Button) findViewById(R.id.btnQuestionNav23);
        btnQuestionNav24 = (Button) findViewById(R.id.btnQuestionNav24);
        btnQuestionNav25 = (Button) findViewById(R.id.btnQuestionNav25);
        btnQuestionNav26 = (Button) findViewById(R.id.btnQuestionNav26);
        btnQuestionNav27 = (Button) findViewById(R.id.btnQuestionNav27);
        btnQuestionNav28 = (Button) findViewById(R.id.btnQuestionNav28);
        btnQuestionNav29 = (Button) findViewById(R.id.btnQuestionNav29);
        btnQuestionNav30 = (Button) findViewById(R.id.btnQuestionNav30);
        ketthuc = (Button) findViewById(R.id.ketthuc);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        viewPager = (ViewPager) findViewById(R.id.viewpager);


        btnQuestionNav1.setOnClickListener(this::onClick);
        btnQuestionNav2.setOnClickListener(this::onClick);
        btnQuestionNav3.setOnClickListener(this::onClick);
        btnQuestionNav4.setOnClickListener(this::onClick);
        btnQuestionNav5.setOnClickListener(this::onClick);
        btnQuestionNav6.setOnClickListener(this::onClick);
        btnQuestionNav7.setOnClickListener(this::onClick);
        btnQuestionNav8.setOnClickListener(this::onClick);
        btnQuestionNav9.setOnClickListener(this::onClick);
        btnQuestionNav10.setOnClickListener(this::onClick);
        btnQuestionNav11.setOnClickListener(this::onClick);
        btnQuestionNav12.setOnClickListener(this::onClick);
        btnQuestionNav13.setOnClickListener(this::onClick);
        btnQuestionNav14.setOnClickListener(this::onClick);
        btnQuestionNav15.setOnClickListener(this::onClick);
        btnQuestionNav16.setOnClickListener(this::onClick);
        btnQuestionNav17.setOnClickListener(this::onClick);
        btnQuestionNav18.setOnClickListener(this::onClick);
        btnQuestionNav19.setOnClickListener(this::onClick);
        btnQuestionNav20.setOnClickListener(this::onClick);
        btnQuestionNav21.setOnClickListener(this::onClick);
        btnQuestionNav22.setOnClickListener(this::onClick);
        btnQuestionNav23.setOnClickListener(this::onClick);
        btnQuestionNav24.setOnClickListener(this::onClick);
        btnQuestionNav25.setOnClickListener(this::onClick);
        btnQuestionNav26.setOnClickListener(this::onClick);
        btnQuestionNav27.setOnClickListener(this::onClick);
        btnQuestionNav28.setOnClickListener(this::onClick);
        btnQuestionNav29.setOnClickListener(this::onClick);
        btnQuestionNav30.setOnClickListener(this::onClick);

        buttonArrayListSmall.add(btnQuestionNav1);


        buttonArrayListSmall.add(btnQuestionNav2);


        buttonArrayListSmall.add(btnQuestionNav3);


        buttonArrayListSmall.add(btnQuestionNav4);


        buttonArrayListSmall.add(btnQuestionNav5);


        buttonArrayListSmall.add(btnQuestionNav6);

        buttonArrayListSmall.add(btnQuestionNav7);

        buttonArrayListSmall.add(btnQuestionNav8);

        buttonArrayListSmall.add(btnQuestionNav9);


        buttonArrayListSmall.add(btnQuestionNav10);

        buttonArrayListSmall.add(btnQuestionNav11);


        buttonArrayListSmall.add(btnQuestionNav12);


        buttonArrayListSmall.add(btnQuestionNav13);

        buttonArrayListSmall.add(btnQuestionNav14);


        buttonArrayListSmall.add(btnQuestionNav15);

        buttonArrayListSmall.add(btnQuestionNav16);

        buttonArrayListSmall.add(btnQuestionNav17);

        buttonArrayListSmall.add(btnQuestionNav18);

        buttonArrayListSmall.add(btnQuestionNav19);

        buttonArrayListSmall.add(btnQuestionNav20);


        buttonArrayListSmall.add(btnQuestionNav21);


        buttonArrayListSmall.add(btnQuestionNav22);

        buttonArrayListSmall.add(btnQuestionNav23);

        buttonArrayListSmall.add(btnQuestionNav24);

        buttonArrayListSmall.add(btnQuestionNav25);

        buttonArrayListSmall.add(btnQuestionNav26);

        buttonArrayListSmall.add(btnQuestionNav27);

        buttonArrayListSmall.add(btnQuestionNav28);

        buttonArrayListSmall.add(btnQuestionNav29);

        buttonArrayListSmall.add(btnQuestionNav30);

        Button kethuc = (Button) findViewById(R.id.ketthuc);
        kethuc.setOnClickListener(this);
    }

    public void timeDown() {
        final TextView dongho = (TextView) findViewById(R.id.tvTime);
        new CountDownTimer(timeCount * 1000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeCount -= 1;
                mintue = timeCount / 60;
                second = timeCount % 60;
                if (second < 10) {
                    dongho.setText(mintue + ":" + "0" + second);
                } else {
                    dongho.setText(mintue + ":" + second);
                }
            }

            @Override
            public void onFinish() {
                finishTest();
            }
        }.start();
    }

    public void initData() {
        indexQuestion = 0;
        WrongQuestions = new ArrayList<>();
        int position = new Random().nextInt(14) + 1;
        mType = getIntent().getStringExtra(Constant.DATA_TYPE);
        if (mType.equals(Constant.TYPE_MAIN_01))
            title = getString(R.string.txt_de_ngau_nhien);
        title = getIntent().getStringExtra(Constant.DATA_TITLE);
        toolbar.setTitle(title);
        test = MyData.getInstance().getTestArrayList().get(position);


        stateQuestionList = new ArrayList<>();
        for (int i = 0; i < test.getPieceArrayList().size(); i++)
            stateQuestionList.add(new StateQuestion(Constant.STATE_QUESTION_NORMAL));

        stateQuestionAdapter = new StateQuestionAdapter();


        rcvStateQuestion.post(new Runnable() {
            @Override
            public void run() {
                widthItem = rcvStateQuestion.getWidth();
                stateQuestionAdapter.setWidth((widthItem / 15));
                stateQuestionAdapter.notifyDataSetChanged();
            }
        });
        rcvStateQuestion.setLayoutManager(new GridLayoutManager(this, 15));
        rcvStateQuestion.setAdapter(stateQuestionAdapter);
        stateQuestionAdapter.setData(stateQuestionList);
        statesListener = new ChangeStatesListener() {
            @Override
            public void changeColor(int position, String state) {
                stateQuestionAdapter.changeState(position, state);
            }
        };
    }

    public boolean isCheckPiece(ArrayList<CheckBox> checkBoxes) {
        for (int i = 0; i < checkBoxes.size(); i++) {
            if (checkBoxes.get(i).isChecked()) {
                return true;
            }
        }
        return false;

    }

    void initQuestioncolor() {
//        stateQuestionAdapter.changeState(positionCurrent,);

    }

    @Override
    public void onClick(View v) {
        int n = v.getId();
        switch (n) {
            case R.id.btnQuestionNav1:
                viewPager.setCurrentItem(0);
                break;
            case R.id.btnQuestionNav2:
                viewPager.setCurrentItem(1);
                break;
            case R.id.btnQuestionNav3:
                viewPager.setCurrentItem(2);
                break;
            case R.id.btnQuestionNav4:
                viewPager.setCurrentItem(3);
                break;
            case R.id.btnQuestionNav5:
                viewPager.setCurrentItem(4);
                break;
            case R.id.btnQuestionNav6:
                viewPager.setCurrentItem(5);
                break;
            case R.id.btnQuestionNav7:
                viewPager.setCurrentItem(6);
                break;
            case R.id.btnQuestionNav8:
                viewPager.setCurrentItem(7);
                break;
            case R.id.btnQuestionNav9:
                viewPager.setCurrentItem(8);
                break;
            case R.id.btnQuestionNav10:
                viewPager.setCurrentItem(9);
                break;
            case R.id.btnQuestionNav11:
                viewPager.setCurrentItem(10);
                break;
            case R.id.btnQuestionNav12:
                viewPager.setCurrentItem(11);
                break;
            case R.id.btnQuestionNav13:
                viewPager.setCurrentItem(12);
                break;
            case R.id.btnQuestionNav14:
                viewPager.setCurrentItem(13);
                break;
            case R.id.btnQuestionNav15:
                viewPager.setCurrentItem(14);
                break;
            case R.id.btnQuestionNav16:
                viewPager.setCurrentItem(15);
                break;
            case R.id.btnQuestionNav17:
                viewPager.setCurrentItem(16);
                break;
            case R.id.btnQuestionNav18:
                viewPager.setCurrentItem(17);
                break;
            case R.id.btnQuestionNav19:
                viewPager.setCurrentItem(18);
                break;
            case R.id.btnQuestionNav20:
                viewPager.setCurrentItem(19);
                break;
            case R.id.btnQuestionNav21:
                viewPager.setCurrentItem(20);
                break;
            case R.id.btnQuestionNav22:
                viewPager.setCurrentItem(21);
                break;
            case R.id.btnQuestionNav23:
                viewPager.setCurrentItem(22);
                break;
            case R.id.btnQuestionNav24:
                viewPager.setCurrentItem(23);
                break;
            case R.id.btnQuestionNav25:
                viewPager.setCurrentItem(24);
                break;
            case R.id.btnQuestionNav26:
                viewPager.setCurrentItem(25);
                break;
            case R.id.btnQuestionNav27:
                viewPager.setCurrentItem(26);
                break;
            case R.id.btnQuestionNav28:
                viewPager.setCurrentItem(27);
                break;
            case R.id.btnQuestionNav29:
                viewPager.setCurrentItem(28);
                break;
            case R.id.btnQuestionNav30:
                viewPager.setCurrentItem(29);
                break;
            case R.id.ketthuc:
                finishTest();
                break;
            case R.id.btnPrevious:
                if (current != 0) {
                    showQuestion(current - 1);
                }
                break;
            case R.id.btnNext:
                if (current != 29) {
                    showQuestion(current + 1);
                }

                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);


    }

    public static void setTextTVDone(String text) {
        if (tvDoneQuestion != null && text != null)
            tvDoneQuestion.setText(text);
    }


    private void showQuestion(int position) {
        viewPager.setCurrentItem(position);
        Piece piece = test.getPieceArrayList().get(positionCurrent);
        current = position;
        tvDoneQuestion.setText(position + 1 + "/30");
        Key key = piece.getPart_key();
        String answer = "";
        positionCurrent = position;
        Log.d("qazxcvb ", " " + positionCurrent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menulamde, menu);
        menuDiem = menu.findItem(R.id.menu_diem);
        menuDiem.setTitle("0");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onPause() {
        super.onPause();
        current = 0;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lam_de_thi);
        buttonArrayListSmall = new ArrayList<Button>();
        buttonArrayListBig = new ArrayList<Button>();
        initGUI();
        timeDown();
        initData();
        setSupportActionBar(toolbar);
        initNavigationDrawer();

        positionCurrent = 0;
        fragmentArrayList = new ArrayList<Fragment>();
        for (int i = 0; i < test.getPieceArrayList().size(); i++) {
            fragmentArrayList.add(new QuestionFragment(positionCurrent, test.getPieceArrayList().get(i), i + 1, null, null, statesListener));

        }
        AdapterViewPager adapterViewPager = new AdapterViewPager(getSupportFragmentManager(), fragmentArrayList);
        viewPager.setAdapter(adapterViewPager);

        stateQuestionAdapter.changeState(positionCurrent, Constant.STATE_QUESTION_IN_PROCESS);
        diemCurrent = 0;
        for (int i = 0; i < 30; i++) {
            booleen[i] = false;
        }


        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {

                QuestionFragment questionFragment = (QuestionFragment) fragmentArrayList.get(position);
                questionFragment.setmPosition(position);
                stateQuestionAdapter.changeState(position, Constant.STATE_QUESTION_IN_PROCESS);
                Piece piece = test.getPieceArrayList().get(positionCurrent);

                Key key = piece.getPart_key();
                String answer = "";
                if (booleen[positionCurrent] == false) {
                    if (isCheckPiece(piece.getCheckBoxes())) {
                        for (int i = 0; i < piece.getCheckBoxes().size(); i++) {
                            if (piece.getCheckBoxes().get(i).isChecked()) {
                                answer += (i + 1);
                            }
                            piece.getCheckBoxes().get(i).setEnabled(false);
                        }
                        if (answer.equals(key.getKey())) {
                            diemCurrent++;
//                            buttonArrayListSmall.get(positionCurrent).setBackgroundColor(Color.GREEN);
//                            buttonArrayListBig.get(positionCurrent).setBackgroundColor(Color.GREEN);

                        } else {
//                            buttonArrayListSmall.get(positionCurrent).setBackgroundColor(Color.RED);
//                            buttonArrayListBig.get(positionCurrent).setBackgroundColor(Color.RED);

                            List<TopWrong.AnswerWrong> answerWrongs = new ArrayList<>();
                            if (key != null && key.getKey() != null && !key.getKey().isEmpty() && piece != null && piece.getPart_answer() != null && piece.getPart_answer().getStringArrayList() != null && piece.getPart_answer().getStringArrayList().size() > 0) {
                                char[] digist = key.getKey().toCharArray();
                                for (int i = 0; i < piece.getPart_answer().getStringArrayList().size(); i++)
                                    answerWrongs.add(new TopWrong.AnswerWrong(piece.getPart_answer().getStringArrayList().get(i), false));

                                for (int i = 0; i < answerWrongs.size(); i++)
                                    for (int j = 0; j < digist.length; j++)
                                        if (answerWrongs.get(i).getAnswer().trim().substring(0, 3).contains(String.valueOf(digist[j])))
                                            answerWrongs.get(i).setRight(true);


                                TopWrong topWrong = new TopWrong(piece.getPart_question().getText(), piece.getPart_question().getImage(), answerWrongs);
                                String json = new Gson().toJson(topWrong);
                                WrongQuestions.add(json);
                            }
                        }
                        booleen[positionCurrent] = true;
                    }
                    menuDiem.setTitle(diemCurrent + "");

                }
                positionCurrent = position;

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


    }

    public boolean onOptionsItemSelected(MenuItem item) {

        int n = item.getItemId();
        switch (n) {
            case R.id.check:
                finishTest();
        }
        return super.onOptionsItemSelected(item);
    }

    // hàm xử lý sau khi kết thúc bài
    public void finishTest() {
        int diem = 0;
        ArrayList<String> stringArrayList = new ArrayList<String>();
        for (int i = 0; i < test.getPieceArrayList().size(); i++) {
            String key = "";
            for (int j = 0; j < test.getPieceArrayList().get(i).getCheckBoxes().size(); j++) {
                if (test.getPieceArrayList().get(i).getCheckBoxes().get(j).isChecked()) {
                    key += (j + 1);
                }
            }

            stringArrayList.add(key);
        }

        for (int i = 0; i < test.getPieceArrayList().size(); i++) {
            if (test.getPieceArrayList().get(i).getPart_key().getKey().equals(stringArrayList.get(i))) {
                diem++;
            }
        }
        ArrayList<String> listKey = new ArrayList<String>();
        Intent intent = new Intent(this, ReviewResultAcivity.class);
        for (int i = 0; i < test.getPieceArrayList().size(); i++) {
            listKey.add(test.getPieceArrayList().get(i).getPart_key().getKey());

        }
        if (WrongQuestions != null && WrongQuestions.size() > 0) {
            RecordWrongDAO dao = new RecordWrongDAO(new SQLiteHelper(this));
            for (int i = 0; i < WrongQuestions.size(); i++) {
                Log.d("mklop ", " " + dao.insertRecord(WrongQuestions.get(i)));
            }
        }
        Test.test = test;
        intent.putExtra("timedo", 1200 - timeCount);
        intent.putExtra("title", title);
        intent.putExtra("key", listKey);
        intent.putExtra("dapan", stringArrayList);

        startActivity(intent);
        finish();

    }

    public void initNavigationDrawer() {
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer);

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close) {

            @Override
            public void onDrawerClosed(View v) {
                super.onDrawerClosed(v);
            }

            @Override
            public void onDrawerOpened(View v) {
                super.onDrawerOpened(v);
            }
        };
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
    }


    public interface ChangeStatesListener {
        void changeColor(int position, String state);
    }


}