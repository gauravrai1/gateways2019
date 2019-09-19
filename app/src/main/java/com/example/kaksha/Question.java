package com.example.kaksha;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.kaksha.API.Models.Request.TestRequest;
import com.example.kaksha.API.Models.Response.TestReponse;
import com.example.kaksha.API.Services.ApiClient;
import com.example.kaksha.API.Services.ApiInterface;
import com.example.kaksha.DB.TinyDB;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
    int ans1 = 1, ans3 = 2, ans4 = 3, ans5 = 1, ans6 = 1;
    ScrollView scrollView;
    int quetsion = 1;
    private TinyDB db;
    ApiInterface api;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        db = new TinyDB(Question.this);

        //Initialising Retrofit Interface
        api = ApiClient.getClient().create(ApiInterface.class);


        setViews();

        setOnClicks();

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

    @SuppressLint("SetTextI18n")
    private void setOnClicks() {


        next.setOnClickListener(v-> {

            if(quetsion == 1) {

                scrollView.scrollTo(0, (int) q2.getY());
                quetsion++;

            } else if (quetsion == 2) {

                scrollView.scrollTo(0, (int) q3.getY());
                quetsion++;

            } else if (quetsion == 3) {

                scrollView.scrollTo(0, (int) q4.getY());
                quetsion++;

            } else if (quetsion == 4) {

                scrollView.scrollTo(0, (int) q5.getY());
                quetsion++;

            } else if (quetsion == 5) {

                next.setText("Complete");
                scrollView.scrollTo(0, (int) q6.getY());
                quetsion++;

            } else {

                api.requestAnxietyData(ans1 +","+ans3+","+ans4 +","+ans5+","+ans6).enqueue(new Callback<TestReponse>() {
                    @Override
                    public void onResponse(Call<TestReponse> call, Response<TestReponse> response) {

                        if(response.isSuccessful()) {

                            db.putString("anxiety",response.body().getSocial_anxiety());
                            startActivity(new Intent(Question.this, Home.class));
                            finish();

                        }

                    }

                    @Override
                    public void onFailure(Call<TestReponse> call, Throwable t) {

                    }
                });

            }

        });


        aa1.setOnClickListener(v-> {

            ans1 = 1;

        });

        aa2.setOnClickListener(v-> {

            ans1 = 1;

        });

        aa3.setOnClickListener(v-> {

            ans1 = 1;

        });

        aa4.setOnClickListener(v-> {

            ans1 = 1;

        });

        aa5.setOnClickListener(v-> {

            ans1 = 1;

        });

        aa6.setOnClickListener(v-> {

            ans1 = 1;

        });

        aa7.setOnClickListener(v-> {

            ans1 = 1;

        });

        aa8.setOnClickListener(v-> {

            ans1 = 1;

        });

        aa9.setOnClickListener(v-> {

            ans1 = 1;

        });

        aa10.setOnClickListener(v-> {

            ans1 = 1;

        });

        aa11.setOnClickListener(v-> {

            ans1 = 1;

        });

        aa12.setOnClickListener(v-> {

            ans1 = 1;

        });

        aa13.setOnClickListener(v-> {

            ans1 = 1;

        });


        a21.setOnClickListener(v-> {

            ans3 = 1;

        });

        a22.setOnClickListener(v-> {

            ans3 = 1;

        });

        a23.setOnClickListener(v-> {

            ans1 = 1;

        });

        a24.setOnClickListener(v-> {

            ans1 = 1;

        });

        a25.setOnClickListener(v-> {

            ans1 = 1;

        });

        a26.setOnClickListener(v-> {

            ans1 = 1;

        });

        a27.setOnClickListener(v-> {

            ans1 = 1;

        });

        a28.setOnClickListener(v-> {

            ans1 = 1;

        });

        a29.setOnClickListener(v-> {

            ans1 = 1;

        });

        a210.setOnClickListener(v-> {

            ans1 = 1;

        });


        a31.setOnClickListener(v-> {

            ans1 = 1;

        });

        a32.setOnClickListener(v-> {

            ans1 = 1;

        });

        a33.setOnClickListener(v-> {

            ans1 = 1;

        });


        a41.setOnClickListener(v-> {

            ans1 = 1;

        });

        a42.setOnClickListener(v-> {

            ans1 = 1;

        });

        a43.setOnClickListener(v-> {

            ans1 = 1;

        });

        a44.setOnClickListener(v-> {

            ans1 = 1;

        });

        a45.setOnClickListener(v-> {

            ans1 = 1;

        });


        a51.setOnClickListener(v-> {

            ans1 = 1;

        });

        a52.setOnClickListener(v-> {

            ans1 = 1;

        });

        a53.setOnClickListener(v-> {

            ans1 = 1;

        });

        a54.setOnClickListener(v-> {

            ans1 = 1;

        });

        a55.setOnClickListener(v-> {

            ans1 = 1;

        });


    }

}
