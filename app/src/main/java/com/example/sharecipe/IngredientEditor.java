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

import java.lang.reflect.Array;

public class IngredientEditor extends AppCompatActivity{


    String name;
    String quan;
    String unit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingredient_editor);

        final EditText ingQuantity = findViewById(R.id.etIngQuantity);
        final EditText ingName = findViewById(R.id.etIngName);
        final EditText ingUnit = findViewById(R.id.etIngUnit);

        Intent intent = getIntent();
        final String[] prev = intent.getStringArrayExtra("ingredients");

        Button bIngDone = findViewById(R.id.bIngDone);
        final Intent ingDone = new Intent(this,PostIngredients.class);
        final String recipeSteps = intent.getStringExtra("steps");
        final String recipeName = intent.getStringExtra("name");
        final String recipeTime = intent.getStringExtra("time");
        final Integer stepCounter = intent.getIntExtra("stepC",0);
        bIngDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = ingName.getText().toString();
                quan = ingQuantity.getText().toString();
                unit = ingUnit.getText().toString();
                String[] firstTime = new String[3];
                boolean first = false;

                if(prev != null)
                {
                 prev[0] += "\n"+name;
                 prev[1] += "\n"+quan;
                 prev[2] += "\n"+unit;
                }
                else {
                    firstTime[0] = name;
                    firstTime[1] = quan;
                    firstTime[2] = unit;
                    first = true;
                }

                if(first)
                    ingDone.putExtra("ingredients",firstTime);
                else
                    ingDone.putExtra("ingredients",prev);

                ingDone.putExtra("steps",recipeSteps);
                ingDone.putExtra("name",recipeName);
                ingDone.putExtra("time",recipeTime);
                ingDone.putExtra("stepC",stepCounter);
                startActivity(ingDone);
            }
        });

    }

}
