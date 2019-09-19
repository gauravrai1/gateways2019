package com.example.kaksha.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.kaksha.Model.Card;
import com.example.kaksha.R;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewCardAdapter extends RecyclerView.Adapter<RecyclerViewCardAdapter.MyViewHolder> {

    //Global Data
    private List<Card> cards = new ArrayList<>();
    private LayoutInflater inflater;
    private View view;
    private RecyclerViewCardAdapter.MyViewHolder holder;
    private Context context;

    //Context setting Function
    public RecyclerViewCardAdapter(Context context) {

        if (context != null) {

            this.context = context;
            inflater = LayoutInflater.from(context);

        }

    }

    //This method inflates view present in the RecyclerView
    @Override
    public RecyclerViewCardAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        view = inflater.inflate(R.layout.home_card, parent, false);
        holder = new RecyclerViewCardAdapter.MyViewHolder(view);
        return holder;

    }

    //Binding the data using get() method of POJO object
    @Override
    public void onBindViewHolder(final RecyclerViewCardAdapter.MyViewHolder holder, int position) {

        //Fetching Data
        Card card = cards.get(position);

    }

    //Setting the arrayList
    public void setListContent(List<Card> cards) {

        this.cards = cards;
        notifyItemRangeChanged(0, cards.size());

    }

    //Setting the count
    @Override
    public int getItemCount() {
        return cards.size();
    }

    //View holder class, where all view components are defined
    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public MyViewHolder(View itemView) {

            super(itemView);
            itemView.setOnClickListener(this);

        }

        @SuppressLint("NewApi")
        @Override
        public void onClick(View v) {

        }

    }

    //function to remove a particular card
    public void removeAt(int position) {
        cards.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(0, cards.size());
    }

}