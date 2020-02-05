package com.example.sharecipe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SearchRecipeInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_recipe_info);

        final Button addToFav = findViewById(R.id.bSearchAddFav);
        addToFav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addToFav.setText("Added");
                addToFav.setBackgroundResource(R.color.colorGreen);
            }
        });

        final Intent i = new Intent(this,HomeActivity.class);

        Button bDone = findViewById(R.id.bSearchDoneView);
        bDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(i);
            }
        });



        Intent combine = getIntent();
        final String recipeSteps = combine.getStringExtra("steps");
        final String[] recipeIngredients = combine.getStringArrayExtra("ingredients");
        final String recipeName = combine.getStringExtra("name");
        final String recipeTime = combine.getStringExtra("time");

        TextView tvName = findViewById(R.id.tvSearchNameOfRec);
        TextView tvTime = findViewById(R.id.tvSearchTimeOfRec);

        tvName.setText("Cake");
        tvTime.setText("< 5 minutes");

        Button bSteps = findViewById(R.id.bSearchViewSteps);
        Button bIngred = findViewById(R.id.bSearchViewIng);

        final Intent viewSteps = new Intent(this,SearchViewSteps.class);
        final Intent viewIngredients = new Intent(this,SearchViewIng.class);
        bSteps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewSteps.putExtra("steps",recipeSteps);
                viewSteps.putExtra("ingredients",recipeIngredients);
                viewSteps.putExtra("name",recipeName);
                viewSteps.putExtra("time",recipeTime);
                startActivity(viewSteps);
            }
        });

        bIngred.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewIngredients.putExtra("steps",recipeSteps);
                viewIngredients.putExtra("ingredients",recipeIngredients);
                viewIngredients.putExtra("name",recipeName);
                viewIngredients.putExtra("time",recipeTime);
                startActivity(viewIngredients);
            }
        });

    }
}
