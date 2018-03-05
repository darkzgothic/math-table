package com.kpsoftwaresolutions.mathtable;

import android.app.Activity;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.os.Handler;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class TableActivity extends AppCompatActivity {

    private TextView txt_id1, txt_id2,txt_id3,txt_id4,txt_id5,txt_id6,txt_id7,txt_id8,txt_id9,txt_id10;
    private TextView txt_t1, txt_t2,txt_t3,txt_t4,txt_t5,txt_t6,txt_t7,txt_t8,txt_t9,txt_t10;
    private EditText txt_v1, txt_v2,txt_v3,txt_v4,txt_v5,txt_v6,txt_v7,txt_v8,txt_v9,txt_v10;
    private LinearLayout lnr_1, lnr_2, lnr_3, lnr_4, lnr_5, lnr_6, lnr_7, lnr_8, lnr_9, lnr_10;

    private ImageButton btnHome, btnEdit, btnCheck;
    private TextView txt_one;
    private int timeCounter = 0;

    private MediaPlayer success;
    private MediaPlayer error;

    private int id;
    private int audioCounter = 1;
    private int one, two, three, four, five, six, seven, eight, nine, ten;
    private String __one, __two, __three, __four, __five, __six, __seven, __eight, __nine, __ten;

    private ImageView img1,img2,img3,img4,img5,img6,img7,img8,img9,img10;
    private CountDownTimer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table);

        id = getIntent().getIntExtra("id", 1);

        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        initComponent();

        setFont();

        setTableValues();


        timer =  new CountDownTimer(40000, 3000){

            @Override
            public void onTick(long l) {
                btnEdit.setEnabled(false);
                if (timeCounter == 0){
                    timeCounter = 1;
                }else if (timeCounter == 1){
                    if (lnr_1.getVisibility() == View.INVISIBLE){
                        lnr_1.setVisibility(View.VISIBLE);
                        if (id < 3){
                            MediaPlayer music = MediaPlayer.create(TableActivity.this, getResources().getIdentifier("num"+one, "raw", getPackageName()));
                            music.start();
                        }
                        return;
                    }
                    else if (lnr_2.getVisibility() == View.INVISIBLE){
                        lnr_2.setVisibility(View.VISIBLE);
                        if (id < 3){
                            MediaPlayer music = MediaPlayer.create(TableActivity.this, getResources().getIdentifier("num"+two, "raw", getPackageName()));
                            music.start();
                        }
                        return;
                    }
                    if (lnr_3.getVisibility() == View.INVISIBLE){
                        lnr_3.setVisibility(View.VISIBLE);
                        if (id < 3){
                            MediaPlayer music = MediaPlayer.create(TableActivity.this, getResources().getIdentifier("num"+three, "raw", getPackageName()));
                            music.start();
                        }
                        return;
                    }
                    else if (lnr_4.getVisibility() == View.INVISIBLE){
                        lnr_4.setVisibility(View.VISIBLE);
                        if (id < 3){
                            MediaPlayer music = MediaPlayer.create(TableActivity.this, getResources().getIdentifier("num"+four, "raw", getPackageName()));
                            music.start();
                        }
                        return;
                    }
                    if (lnr_5.getVisibility() == View.INVISIBLE){
                        lnr_5.setVisibility(View.VISIBLE);
                        if (id < 3){
                            MediaPlayer music = MediaPlayer.create(TableActivity.this, getResources().getIdentifier("num"+five, "raw", getPackageName()));
                            music.start();
                        }
                        return;
                    }
                    else if (lnr_6.getVisibility() == View.INVISIBLE){
                        lnr_6.setVisibility(View.VISIBLE);
                        if (id < 3){
                            MediaPlayer music = MediaPlayer.create(TableActivity.this, getResources().getIdentifier("num"+six, "raw", getPackageName()));
                            music.start();
                        }
                        return;
                    }
                    if (lnr_7.getVisibility() == View.INVISIBLE){
                        lnr_7.setVisibility(View.VISIBLE);
                        if (id < 3){
                            MediaPlayer music = MediaPlayer.create(TableActivity.this, getResources().getIdentifier("num"+seven, "raw", getPackageName()));
                            music.start();
                        }
                        return;
                    }
                    else if (lnr_8.getVisibility() == View.INVISIBLE){
                        lnr_8.setVisibility(View.VISIBLE);
                        if (id < 3){
                            MediaPlayer music = MediaPlayer.create(TableActivity.this, getResources().getIdentifier("num"+eight, "raw", getPackageName()));
                            music.start();
                        }
                        return;
                    }
                    if (lnr_9.getVisibility() == View.INVISIBLE){
                        lnr_9.setVisibility(View.VISIBLE);
                        if (id < 3){
                            MediaPlayer music = MediaPlayer.create(TableActivity.this, getResources().getIdentifier("num"+nine, "raw", getPackageName()));
                            music.start();
                        }
                        return;
                    }
                    else if (lnr_10.getVisibility() == View.INVISIBLE){
                        lnr_10.setVisibility(View.VISIBLE);
                        if (id < 3){
                            MediaPlayer music = MediaPlayer.create(TableActivity.this, getResources().getIdentifier("num"+ten, "raw", getPackageName()));
                            music.start();
                        }
                        btnEdit.setEnabled(true);
                        return;
                    }
                }
            }

            @Override
            public void onFinish() {
            }
        }.start();
    }

    @Override
    protected void onStop() {
        super.onStop();
        timer.cancel();
    }

    private void setFont() {
        AssetManager assetManager = getAssets();

        Typeface typePeeps = Typeface.createFromAsset(assetManager,
                String.format(Locale.US, "fonts/%s", "peeps.TTF"));

        txt_id1.setTypeface(typePeeps);
        txt_id2.setTypeface(typePeeps);
        txt_id3.setTypeface(typePeeps);
        txt_id4.setTypeface(typePeeps);
        txt_id5.setTypeface(typePeeps);
        txt_id6.setTypeface(typePeeps);
        txt_id7.setTypeface(typePeeps);
        txt_id8.setTypeface(typePeeps);
        txt_id9.setTypeface(typePeeps);
        txt_id10.setTypeface(typePeeps);

        txt_t1.setTypeface(typePeeps);
        txt_t2.setTypeface(typePeeps);
        txt_t3.setTypeface(typePeeps);
        txt_t4.setTypeface(typePeeps);
        txt_t5.setTypeface(typePeeps);
        txt_t6.setTypeface(typePeeps);
        txt_t7.setTypeface(typePeeps);
        txt_t8.setTypeface(typePeeps);
        txt_t9.setTypeface(typePeeps);
        txt_t10.setTypeface(typePeeps);

        txt_v1.setTypeface(typePeeps);
        txt_v2.setTypeface(typePeeps);
        txt_v3.setTypeface(typePeeps);
        txt_v4.setTypeface(typePeeps);
        txt_v5.setTypeface(typePeeps);
        txt_v6.setTypeface(typePeeps);
        txt_v7.setTypeface(typePeeps);
        txt_v8.setTypeface(typePeeps);
        txt_v9.setTypeface(typePeeps);
        txt_v10.setTypeface(typePeeps);
    }

    private void setTableValues() {
        one = id * 1;
        two = id * 2;
        three = id * 3;
        four = id * 4;
        five = id * 5;
        six = id * 6;
        seven = id * 7;
        eight = id * 8;
        nine = id * 9;
        ten = id * 10;

        txt_t1.setText(String.valueOf(id));
        txt_t2.setText(String.valueOf(id));
        txt_t3.setText(String.valueOf(id));
        txt_t4.setText(String.valueOf(id));
        txt_t5.setText(String.valueOf(id));
        txt_t6.setText(String.valueOf(id));
        txt_t7.setText(String.valueOf(id));
        txt_t8.setText(String.valueOf(id));
        txt_t9.setText(String.valueOf(id));
        txt_t10.setText(String.valueOf(id));

        txt_v1.setText(String.valueOf(one));
        txt_v2.setText(String.valueOf(two));
        txt_v3.setText(String.valueOf(three));
        txt_v4.setText(String.valueOf(four));
        txt_v5.setText(String.valueOf(five));
        txt_v6.setText(String.valueOf(six));
        txt_v7.setText(String.valueOf(seven));
        txt_v8.setText(String.valueOf(eight));
        txt_v9.setText(String.valueOf(nine));
        txt_v10.setText(String.valueOf(ten));
    }

    private void initComponent() {

        success = MediaPlayer.create(this, R.raw.success);
        error = MediaPlayer.create(this, R.raw.error);

        lnr_1 = (LinearLayout) findViewById(R.id.linear1);
        lnr_2 = (LinearLayout) findViewById(R.id.linear2);
        lnr_3 = (LinearLayout) findViewById(R.id.linear3);
        lnr_4 = (LinearLayout) findViewById(R.id.linear4);
        lnr_5 = (LinearLayout) findViewById(R.id.linear5);
        lnr_6 = (LinearLayout) findViewById(R.id.linear6);
        lnr_7 = (LinearLayout) findViewById(R.id.linear7);
        lnr_8 = (LinearLayout) findViewById(R.id.linear8);
        lnr_9 = (LinearLayout) findViewById(R.id.linear9);
        lnr_10 = (LinearLayout) findViewById(R.id.linear10);

        txt_id1 = (TextView) findViewById(R.id.txt_id1);
        txt_id2 = (TextView) findViewById(R.id.txt_id2);
        txt_id3 = (TextView) findViewById(R.id.txt_id3);
        txt_id4 = (TextView) findViewById(R.id.txt_id4);
        txt_id5 = (TextView) findViewById(R.id.txt_id5);
        txt_id6 = (TextView) findViewById(R.id.txt_id6);
        txt_id7 = (TextView) findViewById(R.id.txt_id7);
        txt_id8 = (TextView) findViewById(R.id.txt_id8);
        txt_id9 = (TextView) findViewById(R.id.txt_id9);
        txt_id10 = (TextView) findViewById(R.id.txt_id10);

        txt_t1 = (TextView) findViewById(R.id.txt_t1);
        txt_t2 = (TextView) findViewById(R.id.txt_t2);
        txt_t3 = (TextView) findViewById(R.id.txt_t3);
        txt_t4 = (TextView) findViewById(R.id.txt_t4);
        txt_t5 = (TextView) findViewById(R.id.txt_t5);
        txt_t6 = (TextView) findViewById(R.id.txt_t6);
        txt_t7 = (TextView) findViewById(R.id.txt_t7);
        txt_t8 = (TextView) findViewById(R.id.txt_t8);
        txt_t9 = (TextView) findViewById(R.id.txt_t9);
        txt_t10 = (TextView) findViewById(R.id.txt_t10);

        txt_v1 = (EditText) findViewById(R.id.txt_v1);
        txt_v2 = (EditText) findViewById(R.id.txt_v2);
        txt_v3 = (EditText) findViewById(R.id.txt_v3);
        txt_v4 = (EditText) findViewById(R.id.txt_v4);
        txt_v5 = (EditText) findViewById(R.id.txt_v5);
        txt_v6 = (EditText) findViewById(R.id.txt_v6);
        txt_v7 = (EditText) findViewById(R.id.txt_v7);
        txt_v8 = (EditText) findViewById(R.id.txt_v8);
        txt_v9 = (EditText) findViewById(R.id.txt_v9);
        txt_v10 = (EditText) findViewById(R.id.txt_v10);

        txt_one = (TextView) findViewById(R.id.txt_one);

        txt_v1.setInputType(InputType.TYPE_CLASS_NUMBER);
        txt_v2.setInputType(InputType.TYPE_CLASS_NUMBER);
        txt_v3.setInputType(InputType.TYPE_CLASS_NUMBER);
        txt_v4.setInputType(InputType.TYPE_CLASS_NUMBER);
        txt_v5.setInputType(InputType.TYPE_CLASS_NUMBER);
        txt_v6.setInputType(InputType.TYPE_CLASS_NUMBER);
        txt_v7.setInputType(InputType.TYPE_CLASS_NUMBER);
        txt_v8.setInputType(InputType.TYPE_CLASS_NUMBER);
        txt_v9.setInputType(InputType.TYPE_CLASS_NUMBER);
        txt_v10.setInputType(InputType.TYPE_CLASS_NUMBER);

        img1 = (ImageView) findViewById(R.id.img_1);
        img2 = (ImageView) findViewById(R.id.img_2);
        img3 = (ImageView) findViewById(R.id.img_3);
        img4 = (ImageView) findViewById(R.id.img_4);
        img5 = (ImageView) findViewById(R.id.img_5);
        img6 = (ImageView) findViewById(R.id.img_6);
        img7 = (ImageView) findViewById(R.id.img_7);
        img8 = (ImageView) findViewById(R.id.img_8);
        img9 = (ImageView) findViewById(R.id.img_9);
        img10 = (ImageView) findViewById(R.id.img_10);

        btnHome = (ImageButton) findViewById(R.id.btn_home);
        btnEdit = (ImageButton) findViewById(R.id.btn_edit);
        btnCheck = (ImageButton) findViewById(R.id.btn_save);

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt_v1.setEnabled(true);
                txt_v2.setEnabled(true);
                txt_v3.setEnabled(true);
                txt_v4.setEnabled(true);
                txt_v5.setEnabled(true);
                txt_v6.setEnabled(true);
                txt_v7.setEnabled(true);
                txt_v8.setEnabled(true);
                txt_v9.setEnabled(true);
                txt_v10.setEnabled(true);

                txt_v1.setText("");
                txt_v2.setText("");
                txt_v3.setText("");
                txt_v4.setText("");
                txt_v5.setText("");
                txt_v6.setText("");
                txt_v7.setText("");
                txt_v8.setText("");
                txt_v9.setText("");
                txt_v10.setText("");

                img1.setVisibility(View.INVISIBLE);
                img2.setVisibility(View.INVISIBLE);
                img3.setVisibility(View.INVISIBLE);
                img4.setVisibility(View.INVISIBLE);
                img5.setVisibility(View.INVISIBLE);
                img6.setVisibility(View.INVISIBLE);
                img7.setVisibility(View.INVISIBLE);
                img8.setVisibility(View.INVISIBLE);
                img9.setVisibility(View.INVISIBLE);
                img10.setVisibility(View.INVISIBLE);

                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_in_right);
                btnCheck.setAnimation(animation);
                btnCheck.setVisibility(View.VISIBLE);
                btnCheck.setBackground(getResources().getDrawable(R.drawable.check40px));
            }
        });

        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                __one = txt_v1.getText().toString();
                __two = txt_v2.getText().toString();
                __three = txt_v3.getText().toString();
                __four = txt_v4.getText().toString();
                __five = txt_v5.getText().toString();
                __six = txt_v6.getText().toString();
                __seven = txt_v7.getText().toString();
                __eight = txt_v8.getText().toString();
                __nine = txt_v9.getText().toString();
                __ten = txt_v10.getText().toString();
                
                if (!__one.isEmpty() && !__two.isEmpty() && !__three.isEmpty() &&
                        !__four.isEmpty() && !__five.isEmpty() && !__six.isEmpty() &&
                        !__seven.isEmpty() && !__eight.isEmpty() && !__nine.isEmpty() &&
                        !__ten.isEmpty()) {

                    int _one = Integer.parseInt(txt_v1.getText().toString());
                    int _two = Integer.parseInt(txt_v2.getText().toString());
                    int _three = Integer.parseInt(txt_v3.getText().toString());
                    int _four = Integer.parseInt(txt_v4.getText().toString());
                    int _five = Integer.parseInt(txt_v5.getText().toString());
                    int _six = Integer.parseInt(txt_v6.getText().toString());
                    int _seven = Integer.parseInt(txt_v7.getText().toString());
                    int _eight = Integer.parseInt(txt_v8.getText().toString());
                    int _nine = Integer.parseInt(txt_v9.getText().toString());
                    int _ten = Integer.parseInt(txt_v10.getText().toString());

                    txt_v1.setTextColor(getResources().getColor(R.color.error));
                    txt_v2.setTextColor(getResources().getColor(R.color.error));
                    txt_v3.setTextColor(getResources().getColor(R.color.error));
                    txt_v4.setTextColor(getResources().getColor(R.color.error));
                    txt_v5.setTextColor(getResources().getColor(R.color.error));
                    txt_v6.setTextColor(getResources().getColor(R.color.error));
                    txt_v7.setTextColor(getResources().getColor(R.color.error));
                    txt_v8.setTextColor(getResources().getColor(R.color.error));
                    txt_v9.setTextColor(getResources().getColor(R.color.error));
                    txt_v10.setTextColor(getResources().getColor(R.color.error));

                    img1.setVisibility(View.INVISIBLE);
                    img2.setVisibility(View.INVISIBLE);
                    img3.setVisibility(View.INVISIBLE);
                    img4.setVisibility(View.INVISIBLE);
                    img5.setVisibility(View.INVISIBLE);
                    img6.setVisibility(View.INVISIBLE);
                    img7.setVisibility(View.INVISIBLE);
                    img8.setVisibility(View.INVISIBLE);
                    img9.setVisibility(View.INVISIBLE);
                    img10.setVisibility(View.INVISIBLE);

                    btnCheck.setBackground(getResources().getDrawable(R.drawable.check40px));

                    if (one == _one &&
                            two == _two && three == _three && four == _four &&
                            five == _five && six == _six && seven == _seven &&
                            eight == _eight && nine == _nine && ten == _ten){

                        success.start();

                        Toast.makeText(TableActivity.this, "Nice job", Toast.LENGTH_SHORT).show();

                        btnCheck.setBackground(getResources().getDrawable(R.drawable.tick40px));
                    }
                    else {
                        error.start();

                        if (one != _one) {
                            txt_v1.setTextColor(Color.RED);
                            img1.setVisibility(View.VISIBLE);
                        }
                        if (two != _two){
                            txt_v2.setTextColor(Color.RED);
                            img2.setVisibility(View.VISIBLE);
                        }
                        if (three != _three){
                            txt_v3.setTextColor(Color.RED);
                            img3.setVisibility(View.VISIBLE);
                        }
                        if (four != _four){
                            txt_v4.setTextColor(Color.RED);
                            img4.setVisibility(View.VISIBLE);
                        }
                        if (five != _five){
                            txt_v5.setTextColor(Color.RED);
                            img5.setVisibility(View.VISIBLE);
                        }
                        if (six != _six){
                            txt_v6.setTextColor(Color.RED);
                            img6.setVisibility(View.VISIBLE);
                        }
                        if (seven != _seven){
                            txt_v7.setTextColor(Color.RED);
                            img7.setVisibility(View.VISIBLE);
                        }
                        if (eight != _eight){
                            txt_v8.setTextColor(Color.RED);
                            img8.setVisibility(View.VISIBLE);
                        }
                        if (nine != _nine){
                            txt_v9.setTextColor(Color.RED);
                            img9.setVisibility(View.VISIBLE);
                        }
                        if (ten != _ten){
                            txt_v10.setTextColor(Color.RED);
                            img10.setVisibility(View.VISIBLE);
                        }
                    }   
                }
                else {
                    error.start();
                    Toast.makeText(TableActivity.this, "Answer All", Toast.LENGTH_SHORT).show();
                }
            }
        });

        txt_v1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                String str = String.valueOf(txt_v1.getText());
                if(!str.isEmpty()){
                    int num =  Integer.parseInt(str);
                    if (one != num){
                        txt_v1.setTextColor(Color.RED);
                        img1.setVisibility(View.VISIBLE);
                    }else {
                        txt_v1.setTextColor(getResources().getColor(R.color.error));
                        img1.setVisibility(View.INVISIBLE);
                    }
                }

                btnCheck.setBackground(getResources().getDrawable(R.drawable.check40px));
            }
        });
        txt_v2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                String str =  String.valueOf(txt_v2.getText());
                if (!str.isEmpty()){
                    int num =  Integer.parseInt(str);
                    if (two != num){
                        txt_v2.setTextColor(Color.RED);
                        img2.setVisibility(View.VISIBLE);
                    }else {
                        txt_v2.setTextColor(getResources().getColor(R.color.error));
                        img2.setVisibility(View.INVISIBLE);
                    }
                }

                btnCheck.setBackground(getResources().getDrawable(R.drawable.check40px));
            }
        });
        txt_v3.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                String str = String.valueOf(txt_v3.getText());
                if (!str.isEmpty()){
                    int num =  Integer.parseInt(str);
                    if (three != num){
                        txt_v3.setTextColor(Color.RED);
                        img3.setVisibility(View.VISIBLE);
                    }else {
                        txt_v3.setTextColor(getResources().getColor(R.color.error));
                        img3.setVisibility(View.INVISIBLE);
                    }
                }
                btnCheck.setBackground(getResources().getDrawable(R.drawable.check40px));
            }
        });
        txt_v4.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                String str = String.valueOf(txt_v4.getText());
                if (!str.isEmpty()) {
                    int num =  Integer.parseInt(str);
                    if (four != num){
                        txt_v4.setTextColor(Color.RED);
                        img4.setVisibility(View.VISIBLE);
                    }else {
                        txt_v4.setTextColor(getResources().getColor(R.color.error));
                        img4.setVisibility(View.INVISIBLE);
                    }
                }
                btnCheck.setBackground(getResources().getDrawable(R.drawable.check40px));
            }
        });
        txt_v5.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                String str = String.valueOf(txt_v5.getText());
                if (!str.isEmpty()){
                    int num =  Integer.parseInt(str);
                    if (five != num){
                        txt_v5.setTextColor(Color.RED);
                        img5.setVisibility(View.VISIBLE);
                    }else {
                        txt_v5.setTextColor(getResources().getColor(R.color.error));
                        img5.setVisibility(View.INVISIBLE);
                    }
                }
                btnCheck.setBackground(getResources().getDrawable(R.drawable.check40px));
            }
        });
        txt_v6.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                String str = String.valueOf(txt_v6.getText());
                if (!str.isEmpty()){
                    int num =  Integer.parseInt(str);
                    if (six != num){
                        txt_v6.setTextColor(Color.RED);
                        img6.setVisibility(View.VISIBLE);
                    }else {
                        txt_v6.setTextColor(getResources().getColor(R.color.error));
                        img6.setVisibility(View.INVISIBLE);
                    }
                }
                btnCheck.setBackground(getResources().getDrawable(R.drawable.check40px));
            }
        });
        txt_v7.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                String str = String.valueOf(txt_v7.getText());
                if (!str.isEmpty()){
                    int num =  Integer.parseInt(str);
                    if (seven != num){
                        txt_v7.setTextColor(Color.RED);
                        img7.setVisibility(View.VISIBLE);
                    }else {
                        txt_v7.setTextColor(getResources().getColor(R.color.error));
                        img7.setVisibility(View.INVISIBLE);
                    }
                }
                btnCheck.setBackground(getResources().getDrawable(R.drawable.check40px));
            }
        });
        txt_v8.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                String str = String.valueOf(txt_v8.getText());
                if (!str.isEmpty()){
                    int num =  Integer.parseInt(str);
                    if (eight != num){
                        txt_v8.setTextColor(Color.RED);
                        img8.setVisibility(View.VISIBLE);
                    }else {
                        txt_v8.setTextColor(getResources().getColor(R.color.error));
                        img8.setVisibility(View.INVISIBLE);
                    }
                }
                btnCheck.setBackground(getResources().getDrawable(R.drawable.check40px));
            }
        });
        txt_v9.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                String str = String.valueOf(txt_v9.getText());
                if (!str.isEmpty()){
                    int num =  Integer.parseInt(str);
                    if (nine != num){
                        txt_v9.setTextColor(Color.RED);
                        img9.setVisibility(View.VISIBLE);
                    }else {
                        txt_v9.setTextColor(getResources().getColor(R.color.error));
                        img9.setVisibility(View.INVISIBLE);
                    }
                }
                btnCheck.setBackground(getResources().getDrawable(R.drawable.check40px));
            }
        });
        txt_v10.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                String str = String.valueOf(txt_v10.getText());
                if (!str.isEmpty()){
                    int num =  Integer.parseInt(str);
                    if (ten != num){
                        txt_v10.setTextColor(Color.RED);
                        img10.setVisibility(View.VISIBLE);
                    }else {
                        txt_v10.setTextColor(getResources().getColor(R.color.error));
                        img10.setVisibility(View.INVISIBLE);
                    }
                }
                btnCheck.setBackground(getResources().getDrawable(R.drawable.check40px));
            }
        });
    }
}
