package com.kpsoftwaresolutions.mathtable;

import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.firebase.analytics.FirebaseAnalytics;

import java.util.Locale;

public class MathTableActivity extends AppCompatActivity {

    private ImageButton home;
    private TextView one, two, three, four, five, six, seven, eight, nine, ten, eleven, twelve, thirteen, fourteen, fifteen, sixteen, seventeen, eighteen, nineteen, twenty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math_table);

        FirebaseAnalytics mFirebaseAnalytics;
        String log = "MathTableActivity Started";
        // Obtain the FirebaseAnalytics instance.
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);

        Bundle bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.VALUE, log);
        mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle);

        initComponent();

        setFont();

        performTextViewClickListener();

        //Banner
        MobileAds.initialize(this, "ca-app-pub-5910423341335020/2996818457");

        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }

    private void setFont() {
        AssetManager assetManager = getAssets();

        Typeface typePeeps = Typeface.createFromAsset(assetManager,
                String.format(Locale.US, "fonts/%s", "main.ttf"));

        one.setTypeface(typePeeps);
        two.setTypeface(typePeeps);
        three.setTypeface(typePeeps);
        four.setTypeface(typePeeps);
        five.setTypeface(typePeeps);
        six.setTypeface(typePeeps);
        eight.setTypeface(typePeeps);
        nine.setTypeface(typePeeps);
        ten.setTypeface(typePeeps);
        eleven.setTypeface(typePeeps);
        twelve.setTypeface(typePeeps);
        thirteen.setTypeface(typePeeps);
        fourteen.setTypeface(typePeeps);
        fifteen.setTypeface(typePeeps);
        sixteen.setTypeface(typePeeps);
        seventeen.setTypeface(typePeeps);
        eighteen.setTypeface(typePeeps);
        nineteen.setTypeface(typePeeps);
        twenty.setTypeface(typePeeps);
        seven.setTypeface(typePeeps);
    }

    private void performTextViewClickListener() {
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();

            }
        });

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MathTableActivity.this, TableActivity.class);
                intent.putExtra("id", 1);
                startActivity(intent);
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MathTableActivity.this, TableActivity.class);
                intent.putExtra("id", 2);
                startActivity(intent);
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MathTableActivity.this, TableActivity.class);
                intent.putExtra("id", 3);
                startActivity(intent);
            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MathTableActivity.this, TableActivity.class);
                intent.putExtra("id", 4);
                startActivity(intent);
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MathTableActivity.this, TableActivity.class);
                intent.putExtra("id", 5);
                startActivity(intent);
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MathTableActivity.this, TableActivity.class);
                intent.putExtra("id", 6);
                startActivity(intent);
            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MathTableActivity.this, TableActivity.class);
                intent.putExtra("id", 7);
                startActivity(intent);
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MathTableActivity.this, TableActivity.class);
                intent.putExtra("id", 8);
                startActivity(intent);
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MathTableActivity.this, TableActivity.class);
                intent.putExtra("id", 9);
                startActivity(intent);
            }
        });
        ten.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MathTableActivity.this, TableActivity.class);
                intent.putExtra("id", 10);
                startActivity(intent);
            }
        });
        eleven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MathTableActivity.this, TableActivity.class);
                intent.putExtra("id", 11);
                startActivity(intent);
            }
        });
        twelve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MathTableActivity.this, TableActivity.class);
                intent.putExtra("id", 12);
                startActivity(intent);
            }
        });
        thirteen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MathTableActivity.this, TableActivity.class);
                intent.putExtra("id", 13);
                startActivity(intent);
            }
        });
        fourteen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MathTableActivity.this, TableActivity.class);
                intent.putExtra("id", 14);
                startActivity(intent);
            }
        });
        fifteen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MathTableActivity.this, TableActivity.class);
                intent.putExtra("id", 15);
                startActivity(intent);
            }
        });
        sixteen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MathTableActivity.this, TableActivity.class);
                intent.putExtra("id", 16);
                startActivity(intent);
            }
        });
        seventeen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MathTableActivity.this, TableActivity.class);
                intent.putExtra("id", 17);
                startActivity(intent);
            }
        });
        eighteen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MathTableActivity.this, TableActivity.class);
                intent.putExtra("id", 18);
                startActivity(intent);
            }
        });
        nineteen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MathTableActivity.this, TableActivity.class);
                intent.putExtra("id", 19);
                startActivity(intent);
            }
        });
        twenty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MathTableActivity.this, TableActivity.class);
                intent.putExtra("id", 20);
                startActivity(intent);
            }
        });
    }

    private void initComponent() {
        one = (TextView) findViewById(R.id.txt_one);
        two = (TextView) findViewById(R.id.txt_two);
        three = (TextView) findViewById(R.id.txt_three);
        four = (TextView) findViewById(R.id.txt_four);
        five = (TextView) findViewById(R.id.txt_five);
        six = (TextView) findViewById(R.id.txt_six);
        seven = (TextView) findViewById(R.id.txt_seven);
        eight = (TextView) findViewById(R.id.txt_eight);
        nine = (TextView) findViewById(R.id.txt_nine);
        ten = (TextView) findViewById(R.id.txt_ten);
        eleven = (TextView) findViewById(R.id.txt_eleven);
        twelve = (TextView) findViewById(R.id.txt_twelve);
        thirteen = (TextView) findViewById(R.id.txt_thirteen);
        fourteen = (TextView) findViewById(R.id.txt_fourteen);
        fifteen = (TextView) findViewById(R.id.txt_fifteen);
        sixteen = (TextView) findViewById(R.id.txt_sixteen);
        seventeen = (TextView) findViewById(R.id.txt_seventeen);
        eighteen = (TextView) findViewById(R.id.txt_eightteen);
        nineteen = (TextView) findViewById(R.id.txt_nineteen);
        twenty = (TextView) findViewById(R.id.txt_twenty);

        home = (ImageButton) findViewById(R.id.btn_home);
    }
}
