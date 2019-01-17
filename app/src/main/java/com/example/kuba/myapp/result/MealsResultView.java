package com.example.kuba.myapp.result;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.kuba.myapp.R;
import com.google.gson.Gson;

import java.util.concurrent.ExecutionException;

import domain.MealRecipeApiRequest;
import domain.mealRecipe.MealRecipeResponse;
import domain.meals.Meal;
import domain.meals.MealsPack;

public class MealsResultView extends AppCompatActivity {

    private ListView listView;
    private static CustomAdapter adapter;
    private MealsPack mealsPackApiResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result_view);

        Intent intent = getIntent();
        Gson gson = new Gson();
        mealsPackApiResponse = gson.fromJson(intent.getExtras().getString("rs4"), MealsPack.class);

        TextView textView = findViewById(R.id.meal_information);
        TextView textView2 = findViewById(R.id.recived_nutrients_details);

        textView.setText(userDetailsResponse(intent));
        textView2.setText(mealsNutrientsDetails(mealsPackApiResponse));

        adapter = new CustomAdapter(mealsPackApiResponse.getMeals(), getApplicationContext());

        listView = findViewById(R.id.list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Meal meal = mealsPackApiResponse.getMeals().get(position);
                mealRecipie(view, meal);
            }
        });
    }


    public void mealRecipie(View view, Meal meal) {

        Intent intent = new Intent(this, RecipeResultView.class);
        Bundle extras = new Bundle();

        Gson gson = new Gson();
        String mealRecipeResponeString = "";
        MealRecipeApiRequest mealRecipeApiRequest = new MealRecipeApiRequest(String.valueOf(meal.getId()));
        MealRecipeResponse mealRecipeResponse = null;

        try {
            mealRecipeResponeString = mealRecipeApiRequest.execute().get();
            mealRecipeResponse = gson.fromJson(mealRecipeResponeString, MealRecipeResponse.class);
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

////        extras.putString("rs1", mealRecipeResponse.getImage());
//        extras.putString("rs1", mealRecipeResponse.getTitle());
//        extras.putString("rs2", mealRecipeResponse.getInstructions());

        extras.putString("rs1", mealRecipeResponeString);


        intent.putExtras(extras);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private String userDetailsResponse(Intent intent) {
        return String.format("Excpected amount of calories: %s\nType of diet: %s\nWithout ingredients: %s",
                String.valueOf(intent.getExtras().getString("rs2")),
                String.valueOf(intent.getExtras().getString("rs3")),
                String.valueOf(intent.getExtras().getString("rs1"))
        );
    }

    private String mealsNutrientsDetails(MealsPack mealsPack) {
        return String.format("The generated diet consists of %s calories\n(Carbohydrates: %s, proteins: %s grams, fats: %s grams)",
                String.valueOf(mealsPack.getNutrients().getCalories()),
                String.valueOf(mealsPack.getNutrients().getCarbohydrates()),
                String.valueOf(mealsPack.getNutrients().getProtein()),
                String.valueOf(mealsPack.getNutrients().getFat())
        );
    }
}



