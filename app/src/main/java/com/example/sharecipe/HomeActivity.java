package com.example.sharecipe;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class HomeActivity extends AppCompatActivity {
    Button bLogOut;
    Button bFind;
    Button bPost;
    Button bSaved;
    Button bSettings;

    FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        final Intent intentFind = new Intent(this,FindRecipe.class);
        final Intent intentPost = new Intent(this,PostRecipe.class);
        final Intent intentSaved = new Intent(this,SearchRecipeInfo.class);
        final Intent intentSettings = new Intent(this,SettingsActivity.class);
        bLogOut = findViewById(R.id.bLogOut);

        bLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent i = new Intent(HomeActivity.this,LoginActivity.class);
                startActivity(i);
            }
        });

        bFind = findViewById(R.id.bFindRecipe);

        bFind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentFind);
            }
        });

        bPost = findViewById(R.id.bPostRecipe);

        bPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentPost);
            }
        });

        bSaved= findViewById(R.id.bViewFav);
        bSaved.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentSaved);
            }
        });

    }
}
