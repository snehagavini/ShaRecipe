package com.example.sharecipe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class StepEditor extends AppCompatActivity {

    String step;
    Integer stepCounter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step_editor);

        Button bStepDone = findViewById(R.id.bStepDone);
        final Intent stepDone = new Intent(this,AddSteps.class);
        final EditText etStep = findViewById(R.id.etTheStep);

        Intent intent = getIntent();
        stepCounter = intent.getIntExtra("stepC",0);
        stepCounter++;
        if(intent.getStringExtra("steps") != null) {
            step = intent.getStringExtra("steps");
        }

        final String[] recipeIngredients = intent.getStringArrayExtra("ingredients");
        final String recipeName = intent.getStringExtra("name");
        final String recipeTime = intent.getStringExtra("time");

        bStepDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String total;
                if(step != null)
                    total = step + "\nStep "+stepCounter + ": " + etStep.getText().toString();
                else
                    total = "Step "+ stepCounter + ": " + etStep.getText().toString();
                stepDone.putExtra("steps",total);
                stepDone.putExtra("stepC",stepCounter);
                stepDone.putExtra("ingredients",recipeIngredients);
                stepDone.putExtra("name",recipeName);
                stepDone.putExtra("time",recipeTime);
                startActivity(stepDone);
            }
        });

    }
}
