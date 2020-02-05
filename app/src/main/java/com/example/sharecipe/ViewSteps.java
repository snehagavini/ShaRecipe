package com.example.sharecipe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ViewSteps extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_steps);

        TextView step1 = findViewById(R.id.tvStep);
        step1.setMovementMethod(new ScrollingMovementMethod());

        Intent combine = getIntent();
        final String recipeSteps = combine.getStringExtra("steps");
        final String[] recipeIngredients = combine.getStringArrayExtra("ingredients");
        final String recipeName = combine.getStringExtra("name");
        final String recipeTime = combine.getStringExtra("time");

        step1.setText(recipeSteps);

        Button bDone = findViewById(R.id.bDone);
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
