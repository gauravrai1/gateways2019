package com.example.kaksha;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kaksha.Adapter.RecommendedRecycler;
import com.example.kaksha.Adapter.RecyclerViewCardAdapter;
import com.example.kaksha.DB.TinyDB;
import com.example.kaksha.Model.Card;
import com.example.kaksha.Model.Recommended;

import java.util.ArrayList;
import java.util.List;

public class Recommendations extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView allextras;
    private RecommendedRecycler adapter;
    private List<Recommended> cards = new ArrayList<>();
    private TinyDB db;
    private ImageView home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommendations);

        home = findViewById(R.id.home);
        home.setOnClickListener(this);
        allextras = findViewById(R.id.allextras);

        db = new TinyDB(Recommendations.this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(Recommendations.this, LinearLayoutManager.HORIZONTAL, false);
        allextras.setLayoutManager(linearLayoutManager);
        adapter = new RecommendedRecycler(Recommendations.this);
        cards.add(new Recommended("Play"));
        cards.add(new Recommended("Movie"));
        cards.add(new Recommended("Video"));
        cards.add(new Recommended("Let's play a game?"));
        adapter.setListContent(cards);
        allextras.setAdapter(adapter);

    }

    @Override
    public void onClick(View v) {
        if (v == home) {
            Intent i = new Intent(Recommendations.this, Home.class);
            finish();
            startActivity(i);
        }
    }

}
