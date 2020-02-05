package com.example.sharecipe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AddSteps extends AppCompatActivity {

    String step;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_steps);
        TextView step1 = findViewById(R.id.tvStep);
        step1.setMovementMethod(new ScrollingMovementMethod());

        Intent intent = getIntent();
        if(intent.getStringExtra("steps") != null) {
            step = intent.getStringExtra("steps");
            if(step !=null)
            step1.setText(step);
        }

        final String[] recipeIngredients = intent.getStringArrayExtra("ingredients");
        final String recipeName = intent.getStringExtra("name");
        final String recipeTime = intent.getStringExtra("time");

        final Integer stepCounter = intent.getIntExtra("stepC",0);

        Button bDone = findViewById(R.id.bRecipeDone);
        final Intent iDone = new Intent(this,PostRecipe.class);
        bDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iDone.putExtra("stepC",stepCounter);
                iDone.putExtra("steps",step);
                iDone.putExtra("ingredients",recipeIngredients);
                iDone.putExtra("name",recipeName);
                iDone.putExtra("time",recipeTime);
                startActivity(iDone);
            }
        });

        Button bAdd = findViewById(R.id.bAdd);
        final Intent iStep= new Intent(this,StepEditor.class);
        bAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                iStep.putExtra("steps",step);
                iStep.putExtra("stepC",stepCounter);
                iStep.putExtra("ingredients",recipeIngredients);
                iStep.putExtra("name",recipeName);
                iStep.putExtra("time",recipeTime);
                startActivity(iStep);
            }
        });

    }


}
