package com.example.kuba.myapp.result;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TextView;

import com.example.kuba.myapp.R;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import domain.mealRecipe.MealRecipeResponse;

public class RecipeResultView extends AppCompatActivity {


    private ListView listView;
    private static CustomAdapterRecipe adapter;
    private MealRecipeResponse mealsPackApiResponse;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result_view_recipe);

        Intent intent = getIntent();
        Gson gson = new Gson();
        mealsPackApiResponse = gson.fromJson(intent.getExtras().getString("rs1"), MealRecipeResponse.class);

        TextView textView = findViewById(R.id.meal_information);
        TextView textView2 = findViewById(R.id.recived_nutrients_details);


        List<MealRecipeResponse> mealRecipeResponseList = new ArrayList<>();
        mealRecipeResponseList.add(mealsPackApiResponse);


        adapter = new CustomAdapterRecipe(mealRecipeResponseList, getApplicationContext());

        listView = findViewById(R.id.list);
        listView.setAdapter(adapter);

    }
}
