package com.example.sharecipe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import org.w3c.dom.Text;

public class FinalRecipeInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_recipe_info);


        Intent combine = getIntent();
        final String recipeSteps = combine.getStringExtra("steps");
        final String[] recipeIngredients = combine.getStringArrayExtra("ingredients");
        final String recipeName = combine.getStringExtra("name");
        final String recipeTime = combine.getStringExtra("time");

        TextView tvName = findViewById(R.id.tvNameOfRecipe);
        TextView tvTime = findViewById(R.id.tvTime);

        tvName.setText(recipeName);
        tvTime.setText(recipeTime);




        Button bSteps = findViewById(R.id.bViewSteps);
        Button bIngred = findViewById(R.id.bViewIng);

        final Intent viewSteps = new Intent(this,ViewSteps.class);
        final Intent viewIngredients = new Intent(this,ViewIngredients.class);
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

        final Button addToFav = findViewById(R.id.bAddToFav);
        addToFav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addToFav.setText("Added");
                addToFav.setBackgroundResource(R.color.colorGreen);
            }
        });

        final Intent i = new Intent(this,HomeActivity.class);
        Button bDone = findViewById(R.id.bRecipeDone);

        bDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(i);
            }
        });
    }
}
