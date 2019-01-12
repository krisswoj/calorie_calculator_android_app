package com.example.kuba.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.concurrent.ExecutionException;

import domain.FetchData;

public class MainActivity extends AppCompatActivity {

    private Button click;
    //    private RadioGroup radioGroup;
    public static TextView data;

    private RadioGroup radioGroup;
    private RadioButton radioButton;
    private Button btnDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        click = findViewById(R.id.btnDisplay);

        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendMessage(view);
            }
        });


    }

    public void sendMessage(View view) {
        Intent intent = new Intent(this, Result.class);
        Bundle extras = new Bundle();
        FetchData result = new FetchData();

        EditText withoutIngredients = findViewById(R.id.without_ingredients);
        EditText caloriesAmount = findViewById(R.id.calories_amount);
        RadioGroup radioGroup = findViewById(R.id.radioKindOfMeal);

        int selectedId = radioGroup.getCheckedRadioButtonId();
        radioButton = findViewById(selectedId);

        String jsonRespons = null;

        try {
            jsonRespons = result.execute().get();
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        extras.putString("rs1", withoutIngredients.getText().toString());
        extras.putString("rs2", caloriesAmount.getText().toString());
        extras.putString("rs3", String.valueOf(radioButton.getText().toString()));
        extras.putString("rs4", jsonRespons);
        intent.putExtras(extras);

        startActivity(intent);
    }
}
