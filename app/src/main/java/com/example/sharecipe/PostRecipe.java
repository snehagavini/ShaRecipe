package com.example.sharecipe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class PostRecipe extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    String spinnerText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_recipe);

        final Spinner spinnerTime = findViewById(R.id.spinnerTime);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.Time, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTime.setAdapter(adapter);
        spinnerTime.setOnItemSelectedListener(this);

        final EditText name = findViewById(R.id.etNameRecipe);

        Intent combine = getIntent();
        final String recipeSteps = combine.getStringExtra("steps");
        final String[] recipeIngredients = combine.getStringArrayExtra("ingredients");
        String recipeTime = spinnerTime.getSelectedItem().toString();
        final Integer stepCounter = combine.getIntExtra("stepC",0);

        Button bIngredients = findViewById(R.id.bIngredients);
        final Intent ingredientsIntent = new Intent(this,PostIngredients.class);

        bIngredients.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String recipeName = name.getText().toString();
                String recipeTime = spinnerTime.getSelectedItem().toString();
                ingredientsIntent.putExtra("steps",recipeSteps);
                ingredientsIntent.putExtra("ingredients",recipeIngredients);
                ingredientsIntent.putExtra("name",recipeName);
                ingredientsIntent.putExtra("time",recipeTime);
                ingredientsIntent.putExtra("stepC",stepCounter);
                startActivity(ingredientsIntent);
            }
        });

        Button bWrite = findViewById(R.id.bWrite);
        final Intent addStepsIntent = new Intent(this,AddSteps.class);

        bWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String recipeName = name.getText().toString();
                String recipeTime = spinnerTime.getSelectedItem().toString();
                addStepsIntent.putExtra("steps",recipeSteps);
                addStepsIntent.putExtra("ingredients",recipeIngredients);
                addStepsIntent.putExtra("name",recipeName);
                addStepsIntent.putExtra("time",recipeTime);
                addStepsIntent.putExtra("stepC",stepCounter);
                startActivity(addStepsIntent);
            }
        });



        Button bPostRecipe = findViewById(R.id.bPostRecipe);
        final Intent i = new Intent(this,FinalRecipeInfo.class);
        bPostRecipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String recipeName = name.getText().toString();
                String recipeTime = spinnerTime.getSelectedItem().toString();
                i.putExtra("steps",recipeSteps);
                i.putExtra("ingredients",recipeIngredients);
                i.putExtra("name",recipeName);
                i.putExtra("time",recipeTime);
                startActivity(i);
            }
        });





    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        spinnerText = parent.getItemAtPosition(position).toString();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
