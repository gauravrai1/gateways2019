package com.example.kaksha;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.kaksha.DB.TinyDB;

public class Question extends AppCompatActivity {

    TextView name, q1, q2, q3, q4, q5, q6;
    LinearLayout a1, a3, a4, a5, a6;
    TextView aa1, aa2, aa3, aa4, aa5, aa6, aa7, aa8, aa9, aa10, aa11, aa12, aa13;
    TextView a21, a22, a23, a24, a25, a26, a27, a28, a29, a210;
    TextView a31, a32, a33;
    TextView a41, a42, a43, a44, a45;
    TextView a51, a52, a53, a54, a55;
    TextView next;
    SeekBar a2;
    ScrollView scrollView;
    int quetsion = 1;
    private TinyDB db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        db = new TinyDB(Question.this);

        setViews();

        a2.setVisibility(View.GONE);
        a3.setVisibility(View.GONE);
        a4.setVisibility(View.GONE);
        a5.setVisibility(View.GONE);
        a6.setVisibility(View.GONE);
        q2.setVisibility(View.GONE);
        q3.setVisibility(View.GONE);
        q4.setVisibility(View.GONE);
        q5.setVisibility(View.GONE);
        q6.setVisibility(View.GONE);

        name.setText("Hey, "+db.getString("name"));

    }

    private void setViews() {

        name = findViewById(R.id.name);
        next = findViewById(R.id.next);
        scrollView = findViewById(R.id.scrollView);
        a1 = findViewById(R.id.answer1);
        a2 = findViewById(R.id.answer2);
        a3 = findViewById(R.id.answer3);
        a4 = findViewById(R.id.answer4);
        a5 = findViewById(R.id.answer5);
        a6 = findViewById(R.id.answer6);
        q1 = findViewById(R.id.question1);
        q2 = findViewById(R.id.question2);
        q3 = findViewById(R.id.question3);
        q4 = findViewById(R.id.question4);
        q5 = findViewById(R.id.question5);
        q6 = findViewById(R.id.question6);
        aa1 = findViewById(R.id.a1);
        aa2 = findViewById(R.id.a2);
        aa3 = findViewById(R.id.a3);
        aa4 = findViewById(R.id.a4);
        aa5 = findViewById(R.id.a5);
        aa6 = findViewById(R.id.a6);
        aa7 = findViewById(R.id.a7);
        aa8 = findViewById(R.id.a8);
        aa9 = findViewById(R.id.a9);
        aa10 = findViewById(R.id.a10);
        aa11 = findViewById(R.id.a11);
        aa12 = findViewById(R.id.a12);
        aa13 = findViewById(R.id.a13);
        a21 = findViewById(R.id.a21);
        a22 = findViewById(R.id.a22);
        a23 = findViewById(R.id.a23);
        a24 = findViewById(R.id.a24);
        a25 = findViewById(R.id.a25);
        a26 = findViewById(R.id.a26);
        a27 = findViewById(R.id.a27);
        a28 = findViewById(R.id.a28);
        a29 = findViewById(R.id.a29);
        a210 = findViewById(R.id.a210);
        a31 = findViewById(R.id.a31);
        a32 = findViewById(R.id.a32);
        a33 = findViewById(R.id.a33);
        a41 = findViewById(R.id.a41);
        a42 = findViewById(R.id.a42);
        a43 = findViewById(R.id.a43);
        a44 = findViewById(R.id.a44);
        a45 = findViewById(R.id.a45);
        a51 = findViewById(R.id.a51);
        a52 = findViewById(R.id.a52);
        a53 = findViewById(R.id.a53);
        a54 = findViewById(R.id.a54);
        a55 = findViewById(R.id.a55);

    }

}
