package com.example.kaksha.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.kaksha.DB.TinyDB;
import com.example.kaksha.Model.Card;
import com.example.kaksha.Model.Recommended;
import com.example.kaksha.R;

import java.util.ArrayList;
import java.util.List;

public class RecommendedRecycler extends RecyclerView.Adapter<RecommendedRecycler.MyViewHolder> {

    //Global Data
    private List<Recommended> cards = new ArrayList<>();
    private LayoutInflater inflater;
    private View view;
    private RecommendedRecycler.MyViewHolder holder;
    private Context context;
    private TinyDB db;

    //Context setting Function
    public RecommendedRecycler(Context context) {
        if (context != null) {
            this.context = context;
            inflater = LayoutInflater.from(context);
            db = new TinyDB(context);
        }
    }

    //This method inflates view present in the RecyclerView
    @Override
    public RecommendedRecycler.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view = inflater.inflate(R.layout.home_card, parent, false);
        holder = new RecommendedRecycler.MyViewHolder(view);
        return holder;
    }

    //Binding the data using get() method of POJO object
    @Override
    public void onBindViewHolder(final RecommendedRecycler.MyViewHolder holder, int position) {
        //Fetching Data
        Recommended card = cards.get(position);

        if(position == 0) {
            holder.text.setText("Go away you retard!");
        } else {
            holder.text.setText(card.getTitle());
        }
    }

    //Setting the arrayList
    public void setListContent(List<Recommended> cards) {
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
        private TextView text;
        public MyViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            text = itemView.findViewById(R.id.text);
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