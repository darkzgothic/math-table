package com.kpsoftwaresolutions.mathtable;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.facebook.FacebookActivity;
import com.facebook.FacebookSdk;
import com.facebook.share.widget.LikeView;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.firebase.analytics.FirebaseAnalytics;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    LikeView likeView;
    Bundle bundle;
    boolean like;
    private static final String TAG = "Facebook Info";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_main);

        FirebaseAnalytics mFirebaseAnalytics;
        String log = "MainActivity Started";
        // Obtain the FirebaseAnalytics instance.
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);

        Bundle bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.VALUE, log);
        mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle);

        TextView exit = (TextView) findViewById(R.id.exit_btn);
        TextView about = (TextView) findViewById(R.id.about_btn);
        TextView exam = (TextView) findViewById(R.id.exam_btn);
        TextView quiz = (TextView) findViewById(R.id.quiz_btn);
        TextView practice = (TextView) findViewById(R.id.practice_btn);

        AssetManager assetManager = getAssets();

        Typeface typeface = Typeface.createFromAsset(assetManager,
                String.format(Locale.US, "fonts/%s", "main.ttf"));
        Typeface typeface1 = Typeface.createFromAsset(assetManager,
                String.format(Locale.US, "fonts/%s", "cartoon.ttf"));
        Typeface typeface2 = Typeface.createFromAsset(assetManager,
                String.format(Locale.US, "fonts/%s", "planetbe.ttf"));
        Typeface typeface3 = Typeface.createFromAsset(assetManager,
                String.format(Locale.US, "fonts/%s", "orange.ttf"));
        Typeface typeface4 = Typeface.createFromAsset(assetManager,
                String.format(Locale.US, "fonts/%s", "shark.otf"));

        exit.setTypeface(typeface3);
        about.setTypeface(typeface3);
        exam.setTypeface(typeface3);
        quiz.setTypeface(typeface3);
        practice.setTypeface(typeface3);

        practice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, MathTableActivity.class));
            }
        });

        quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, QuizActivity.class));
            }
        });

        exam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ExamActivity.class));
            }
        });

        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, AboutActivity.class));
            }
        });

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder1 = new AlertDialog.Builder(MainActivity.this);
                builder1.setMessage("Are You Want To Exit?");
                builder1.setCancelable(true);

                builder1.setPositiveButton(
                        "Yes",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                finish();
                            }
                        });

                builder1.setNegativeButton(
                        "No",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alert11 = builder1.create();
                alert11.show();
            }
        });

        //Banner
        MobileAds.initialize(this, "ca-app-pub-5910423341335020/2996818457");

        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        //Facebook Like Button
        likeView = (LikeView) findViewById(R.id.like_view);
        likeView.setObjectIdAndType("https://www.facebook.com/kpsoftwaresolutions/", LikeView.ObjectType.PAGE);

        likeView.setLikeViewStyle(LikeView.Style.STANDARD);
        likeView.setAuxiliaryViewPosition(LikeView.AuxiliaryViewPosition.INLINE);
        likeView.setHorizontalAlignment(LikeView.HorizontalAlignment.LEFT);
        likeView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, FacebookActivity.class);
                startActivity(intent);
            }
        });
    }
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        try {
//            if (resultCode == RESULT_OK) {
//                // verify we're returning from like action
//                // get action results
//                bundle = data.getExtras().getBundle("com.facebook.platform.protocol.RESULT_ARGS");
//                if (bundle != null) {
//                    like = bundle.getBoolean("object_is_liked");// liked/unliked
//                    bundle.getInt("didComplete");
//                    bundle.getInt("like_count"); // object like count
//                    bundle.getString("like_count_string");
//                    bundle.getString("social_sentence");
//                    bundle.getString("completionGesture"); // liked/cancel/unliked
//                    Log.e(TAG, bundle.getString("social_sentence") + "");
//                    Log.e(TAG, "likeornot" + bundle.getBoolean("object_is_liked") + "");
//                    Log.e(TAG, "lcomplete" + bundle.getString("completionGesture") + "");
//                    Log.e(TAG, "count" + bundle.getInt("like_count") + "");
//                    Log.e(TAG, "countstr" + bundle.getString("like_count_string") + "");
//                    Log.e(TAG, "did" + bundle.getInt("didComplete") + "");
//                }
//            }
//        } catch (Exception e) {
//
//        }
//    }
}
