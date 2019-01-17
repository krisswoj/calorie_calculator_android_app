package com.example.kuba.myapp.result;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.kuba.myapp.R;

public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        TextView textView = findViewById(R.id.result_answer);
        textView.setText(extras.getString("rs1"));
    }
}
