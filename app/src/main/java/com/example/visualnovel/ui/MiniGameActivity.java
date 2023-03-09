package com.example.visualnovel.ui;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.visualnovel.MiniGame;
import com.example.visualnovel.R;
import com.example.visualnovel.databinding.MinigameLayoutBinding;

import org.w3c.dom.Text;

public class MiniGameActivity extends AppCompatActivity {

    private MiniGame game;
    private MinigameLayoutBinding mBinding;
    private int endOfGame; //0 - Нейтральное состояние / -1 - Конец - проигрыш / 1 - Конец - победа

    private void updateScreen(){
        for (int i = 0; i < 5; i++){
            for (int j = 0; j < 5; j++){
                int resId = getResources().getIdentifier("tab" + i + "" + j, "id", getPackageName());
                TextView vE = findViewById(resId); // viewElemet
                vE.setText(game.getMatrix(i,j));
                vE.setBackground(getDrawable(R.drawable.empty));
            }
        }

        int x = game.getxCoords();
        int y = game.getyCoords();
        if (game.getOrientation() == 0){
            for (int i = 0; i < 5; i++){
                int resId = getResources().getIdentifier("tab" + x + "" + i, "id", getPackageName());
                TextView vE = findViewById(resId);
                vE.setBackgroundColor(getColor(R.color.hack_green_bg));
            }
        }
        else{
            for (int i = 0; i < 5; i++){
                int resId = getResources().getIdentifier("tab" + i + "" + y, "id", getPackageName());
                TextView vE = findViewById(resId);
                vE.setBackgroundColor(getColor(R.color.hack_green_bg));
            }
        }
        int resId = getResources().getIdentifier("tab"+x+""+y, "id", getPackageName());
        TextView choisen = findViewById(resId);
        choisen.setBackground(getDrawable(R.drawable.border_choisen));
        mBinding.combination.setText(game.getCombination());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        mBinding = mBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());
        game = new MiniGame();
        updateScreen();

        mBinding.Enter.setOnClickListener(View -> {

            endOfGame = game.pushCheck();

            if (endOfGame == 0){
                if (game.getOrientation() == 0){
                    mBinding.up.setVisibility(android.view.View.GONE);
                    mBinding.down.setVisibility(android.view.View.GONE);
                    mBinding.left.setVisibility(android.view.View.VISIBLE);
                    mBinding.right.setVisibility(android.view.View.VISIBLE);
                }
                else{
                    mBinding.up.setVisibility(android.view.View.VISIBLE);
                    mBinding.down.setVisibility(android.view.View.VISIBLE);
                    mBinding.left.setVisibility(android.view.View.GONE);
                    mBinding.right.setVisibility(android.view.View.GONE);
                }
            }
            else if (endOfGame == 1){
                Intent i = new Intent();
                i.putExtra("res", 1);
                setResult(2, i);
                finish();
            }
            else {
                Intent i = new Intent();
                i.putExtra("res", 0);
                setResult(2, i);
                finish();
            }

            updateScreen();

        });

        mBinding.left.setOnClickListener(View -> {

            game.setyCoords(-1);

            updateScreen();

        });
        mBinding.right.setOnClickListener(View -> {

            game.setyCoords(1);

            updateScreen();

        });
        mBinding.up.setOnClickListener(View -> {

            game.setxCoords(-1);

            updateScreen();

        });
        mBinding.down.setOnClickListener(View -> {

            game.setxCoords(1);

            updateScreen();

        });
    }

}
