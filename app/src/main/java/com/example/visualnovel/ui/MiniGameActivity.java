package com.example.visualnovel.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.visualnovel.MiniGame;
import com.example.visualnovel.R;
import com.example.visualnovel.databinding.MinigameLayoutBinding;

public class MiniGameActivity extends AppCompatActivity {

    private MiniGame game;
    private MinigameLayoutBinding mBinding;

    private void updateScreen(){
        for (int i = 0; i < 5; i++){
            for (int j = 0; j < 5; j++){
                int resId = getResources().getIdentifier("tab" + i + "" + j, "id", getPackageName());
                TextView tab = findViewById(resId);
                tab.setText(game.getMatrix(i,j));
            }
        }

        mBinding.combination.setText(game.getCombination());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        mBinding = mBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());
        game = new MiniGame();
        updateScreen();

    }

}
