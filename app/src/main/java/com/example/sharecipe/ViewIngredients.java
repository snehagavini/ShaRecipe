package com.example.sharecipe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ViewIngredients extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_ingredients);


        Intent combine = getIntent();
        final String recipeSteps = combine.getStringExtra("steps");
        final String[] recipeIngredients = combine.getStringArrayExtra("ingredients");
        final String recipeName = combine.getStringExtra("name");
        final String recipeTime = combine.getStringExtra("time");

        final TextView tvNameOfIng = findViewById(R.id.tvViewIngName);
        final TextView tvQOfIng = findViewById(R.id.tvViewIngQ);
        final TextView tvUnitsOfIng = findViewById(R.id.tvViewIngUnit);

        tvNameOfIng.setText(recipeIngredients[0]);
        tvQOfIng.setText(recipeIngredients[1]);
        tvUnitsOfIng.setText(recipeIngredients[2]);

        Button bDone = findViewById(R.id.bViewIngDone);
        final Intent done = new Intent(this,FinalRecipeInfo.class);

        bDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                done.putExtra("steps",recipeSteps);
                done.putExtra("ingredients",recipeIngredients);
                done.putExtra("name",recipeName);
                done.putExtra("time",recipeTime);
                startActivity(done);
            }
        });
    }
}
