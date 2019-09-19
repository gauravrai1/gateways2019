package com.example.kaksha;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.kaksha.Adapter.RecyclerViewCardAdapter;
import com.example.kaksha.Model.Card;

import java.util.ArrayList;
import java.util.List;

public class Home extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerViewCardAdapter adapter;
    private List<Card> cards = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        recyclerView = findViewById(R.id.recyclerView);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(Home.this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new RecyclerViewCardAdapter(Home.this);
        cards.add(new Card("Hey"));
        cards.add(new Card("Hey"));
        cards.add(new Card("Hey"));
        cards.add(new Card("Hey"));
        adapter.setListContent(cards);
        recyclerView.setAdapter(adapter);

    }

}
