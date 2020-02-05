package com.example.sharecipe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SearchViewSteps extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_view_steps);

        TextView step1 = findViewById(R.id.tvSearchStep);
        step1.setMovementMethod(new ScrollingMovementMethod());


        step1.setText("Step 1: Pour flour into the bowl.\nStep 2: mix the eggs with the flour.\nStep 3: Bake at 365 degrees for 60 minutes.\nStep 4: Enjoy!");

        Button bDone = findViewById(R.id.bDone);
        final Intent done = new Intent(this,SearchRecipeInfo.class);
        bDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(done);
            }
        });
    }
}
