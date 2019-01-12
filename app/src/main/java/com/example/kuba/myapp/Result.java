package com.example.kuba.myapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Result extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        TextView textView = findViewById(R.id.result_answer);
        textView.setText(extras.getString("rs1"));

        TextView textView2 = findViewById(R.id.result_answer2);
        textView2.setText(extras.getString("rs2"));

        TextView textView3 = findViewById(R.id.result_answer3);
        textView3.setText(extras.getString("rs3"));

        TextView textView4 = findViewById(R.id.result_answer4);
        textView4.setText(extras.getString("rs4"));

    }
}
