package com.kpsoftwaresolutions.mathtable;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.firebase.analytics.FirebaseAnalytics;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class ExamActivity extends AppCompatActivity {

    private TextView timerTxt;
    private TextView txt_num1, txt_num2, txt_result, txt_multi;
    private TextView txt_ans1, txt_ans2, txt_ans3, txt_ans4;
    private ImageButton home;
    private int num1, num2, result;

    private int questions = 0;
    private int correctAns = 0;

    private View line;
    private MediaPlayer success, error;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam);

        FirebaseAnalytics mFirebaseAnalytics;
        String log = "ExamActivity Started";
        // Obtain the FirebaseAnalytics instance.
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);

        Bundle bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.VALUE, log);
        mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle);

        initCOmponent();

        setFont();

        //Banner
        MobileAds.initialize(this, "ca-app-pub-5910423341335020/2996818457");

        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

    }

    private void setFont() {
        AssetManager assetManager = getAssets();

        Typeface typePeeps = Typeface.createFromAsset(assetManager,
                String.format(Locale.US, "fonts/%s", "peeps.TTF"));

        txt_num1.setTypeface(typePeeps);
        txt_num2.setTypeface(typePeeps);
        txt_result.setTypeface(typePeeps);
        txt_ans1.setTypeface(typePeeps);
        txt_ans2.setTypeface(typePeeps);
        txt_ans3.setTypeface(typePeeps);
        txt_ans4.setTypeface(typePeeps);
        txt_multi.setTypeface(typePeeps);
        timerTxt.setTypeface(typePeeps);
    }

    private void initCOmponent() {
        success = MediaPlayer.create(this, R.raw.success);
        error = MediaPlayer.create(this, R.raw.error);
        timerTxt = (TextView) findViewById(R.id.txt_timer);

        txt_num1 = (TextView) findViewById(R.id.txt_num1);
        txt_num2 = (TextView) findViewById(R.id.txt_num2);
        txt_result = (TextView) findViewById(R.id.txt_num_result);
        txt_multi = (TextView) findViewById(R.id.txt_plus);

        line = (View) findViewById(R.id.line);

        txt_ans1 = (TextView) findViewById(R.id.txt_ans1);
        txt_ans2 = (TextView) findViewById(R.id.txt_ans2);
        txt_ans3 = (TextView) findViewById(R.id.txt_ans3);
        txt_ans4 = (TextView) findViewById(R.id.txt_ans4);

        home = (ImageButton) findViewById(R.id.btn_home);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        txt_result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                questions = 0;
                correctAns = 0;

                timerTxt.setTextColor(getResources().getColor(R.color.color_green));

                setMath();

                new CountDownTimer(90000, 1000){

                    @Override
                    public void onTick(long timeUntilFinish) {
                        timerTxt.setText(String.valueOf(timeUntilFinish / 1000));

                        int time = (int) timeUntilFinish / 1000;

                        if (time <= 10){
                            timerTxt.setTextColor(getResources().getColor(R.color.color_red));
                        }
                    }

                    @Override
                    public void onFinish() {
                        timerTxt.setText("Finished");

                        txt_num1.setTextSize(24f);
                        txt_result.setTextSize(24f);

                        txt_num1.setText("You got "+correctAns+" out of "+questions+"");
                        txt_num2.setText("");
                        txt_multi.setText("");
                        line.setVisibility(View.INVISIBLE);
                        txt_result.setText("Start Again");
                        txt_ans1.setText("");
                        txt_ans2.setText("");
                        txt_ans3.setText("");
                        txt_ans4.setText("");

                    }
                }.start();
            }
        });
        txt_ans1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int _result = Integer.parseInt(txt_ans1.getText().toString());
                questions++;

                if (result == _result){
                    txt_result.setText(String.valueOf(result));
                    success.start();
                    correctAns++;
                    setMath();
                }else {
                    txt_ans1.setTextColor(getResources().getColor(R.color.color_red));
                    error.start();
                    setMath();
                }
            }
        });
        txt_ans2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int _result = Integer.parseInt(txt_ans2.getText().toString());
                questions++;

                if (result == _result){
                    txt_result.setText(String.valueOf(result));
                    success.start();
                    correctAns++;
                    setMath();
                }else {
                    txt_ans2.setTextColor(getResources().getColor(R.color.color_red));
                    error.start();
                    setMath();
                }
            }
        });
        txt_ans3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int _result = Integer.parseInt(txt_ans3.getText().toString());
                questions++;

                if (result == _result){
                    txt_result.setText(String.valueOf(result));
                    success.start();
                    correctAns++;
                    setMath();
                }else {
                    txt_ans3.setTextColor(getResources().getColor(R.color.color_red));
                    error.start();
                    setMath();
                }
            }
        });
        txt_ans4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int _result = Integer.parseInt(txt_ans4.getText().toString());
                questions++;

                if (result == _result){
                    txt_result.setText(String.valueOf(result));
                    success.start();
                    correctAns++;
                    setMath();
                }else {
                    txt_ans4.setTextColor(getResources().getColor(R.color.color_red));
                    error.start();
                    setMath();
                }
            }
        });

    }

    private void setMath() {

        txt_multi.setText("x");
        txt_num1.setTextSize(34f);
        line.setVisibility(View.VISIBLE);
        txt_result.setTextSize(34f);

        txt_ans1.setTextColor(getResources().getColor(R.color.color_green));
        txt_ans2.setTextColor(getResources().getColor(R.color.color_green));
        txt_ans3.setTextColor(getResources().getColor(R.color.color_green));
        txt_ans4.setTextColor(getResources().getColor(R.color.color_green));

        txt_result.setText("");

        Random random = new Random();
        num1 = random.nextInt(21 - 1) + 1;
        num2 = random.nextInt(21 - 1) + 1;

        txt_num1.setText(String.valueOf(num1));
        txt_num2.setText(String.valueOf(num2));

        result = num1 * num2;

        int ans1 = result;
        int ans2 = result + (random.nextInt(10 - 1) + 1);
        int ans3 = (result - (result - 1)) + (random.nextInt(10 - 1) + 1);
        int ans4 = (result + 2)  + (random.nextInt(10 - 1) + 1);

        List<Integer> list = new ArrayList<>();
        list.add(ans1);
        list.add(ans2);
        list.add(ans3);
        list.add(ans4);

        shuffleList(list);

        txt_ans1.setText(String.valueOf(list.get(0)));
        txt_ans2.setText(String.valueOf(list.get(1)));
        txt_ans3.setText(String.valueOf(list.get(2)));
        txt_ans4.setText(String.valueOf(list.get(3)));
    }

    public void shuffleList(List<Integer> a){
        int n = a.size();
        Random random = new Random();
        random.nextInt();
        for (int i = 0; i < n; i++) {
            int change = i + random.nextInt(n - i);
            swap(a, i, change);
        }
    }
    public void swap(List<Integer> a, int i, int change){
        int helper = a.get(i);
        a.set(i, a.get(change));
        a.set(change, helper);
    }
}
