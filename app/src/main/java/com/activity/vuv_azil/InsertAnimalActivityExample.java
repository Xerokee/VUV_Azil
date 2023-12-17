package com.activity.vuv_azil;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class InsertAnimalActivityExample extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_insert_animal);
    // Get the FragmentManager
    FragmentManager fragmentManager = getSupportFragmentManager();

    // Begin a new FragmentTransaction
    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

    // Replace the FrameLayout with the desired Fragment
    InsertAnimalFragment exampleFragment = new InsertAnimalFragment();
        fragmentTransaction.replace(R.id.FrameLayout, exampleFragment);

    // Commit the transaction
        fragmentTransaction.commit();
    }
}
