package com.example.sharecipe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class PostIngredients extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_ingredients);

        final TextView tvNameOfIng = findViewById(R.id.tvNameOfIng);
        final TextView tvQOfIng = findViewById(R.id.tvQOfIng);
        final TextView tvUnitsOfIng = findViewById(R.id.tvUnitsOfIng);

        final Intent goBack = new Intent(this,PostRecipe.class);
        final Intent ingEdit = new Intent(this,IngredientEditor.class);
        Button bAdd = findViewById(R.id.bAdd);

        Intent combine = getIntent();
        final String recipeSteps = combine.getStringExtra("steps");
        final String recipeName = combine.getStringExtra("name");
        final String recipeTime = combine.getStringExtra("time");
        final Integer stepCounter = combine.getIntExtra("stepC",0);

        final String[] ingredients = combine.getStringArrayExtra("ingredients");
        if(ingredients != null) {
            tvNameOfIng.setText(ingredients[0]);
            tvQOfIng.setText(ingredients[1]);
            tvUnitsOfIng.setText(ingredients[2]);
        }

        bAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ingEdit.putExtra("ingredients",ingredients);
                ingEdit.putExtra("steps",recipeSteps);
                ingEdit.putExtra("name",recipeName);
                ingEdit.putExtra("time",recipeTime);
                ingEdit.putExtra("stepC",stepCounter);
                startActivity(ingEdit);
            }
        });

        Button bDone = findViewById(R.id.bRecipeDone);

        bDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goBack.putExtra("ingredients",ingredients);
                goBack.putExtra("steps",recipeSteps);
                goBack.putExtra("name",recipeName);
                goBack.putExtra("time",recipeTime);
                goBack.putExtra("stepC",stepCounter);
                startActivity(goBack);
            }
        });

    }
}
