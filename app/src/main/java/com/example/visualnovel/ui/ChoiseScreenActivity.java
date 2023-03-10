package com.example.visualnovel.ui;

import android.content.Intent;
import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;

import com.example.visualnovel.databinding.StartLayoutBinding;
import com.example.visualnovel.databinding.StartscreenLayoutBinding;


public class ChoiseScreenActivity extends AppCompatActivity {

    private StartscreenLayoutBinding mBinding;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        mBinding = mBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        mBinding.storyGame.setOnClickListener(View -> {

            Intent i = new Intent();
            finish();

        });

        mBinding.miniGame.setOnClickListener(View -> {

            Intent miniGame = new Intent(this, MiniGameActivity.class);
            startActivity(miniGame);

        });

    }
}
