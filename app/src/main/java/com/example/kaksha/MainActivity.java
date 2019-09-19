package com.example.kaksha;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;

import com.example.kaksha.DB.TinyDB;

public class MainActivity extends AppCompatActivity {

    private TinyDB db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new TinyDB(MainActivity.this);

        findViewById(R.id.go).setOnClickListener(v -> {

            Dialog dialog;
            dialog = new Dialog(MainActivity.this);
            dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setContentView(R.layout.dialog_name);

            EditText name = dialog.findViewById(R.id.name);
            TextView save = dialog.findViewById(R.id.save);

            save.setOnClickListener(c -> {

                String naam = name.getText().toString().trim();

                if(naam.isEmpty()) {

                    name.setHint("Enter your name to continue");

                } else {

                    db.putString("name",naam);

                    startActivity(new Intent(MainActivity.this, Home.class));
                    finish();


                }

            });

            dialog.show();


        });

    }

}
