package com.example.visualnovel.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.visualnovel.databinding.StartLayoutBinding;

public class CharacterScreenActivity extends AppCompatActivity {
    private StartLayoutBinding mBinding;
    private int perksCount = 6;
    private int rep = 1;
    private int strong = 1;
    private int cyberimplants = 1;
    private int money = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = mBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());
        mBinding.perksCount.setText(String.valueOf(perksCount));

        mBinding.repButton.setOnClickListener(View ->{ //Кнопка реп
            if (perksCount > 0) {
                if (rep == 6) {
                    Toast.makeText(this, "Достигнут максимум", Toast.LENGTH_SHORT).show();
                } else {
                    perksCount--;
                    mBinding.perksCount.setText(String.valueOf(perksCount));
                    rep++;
                    mBinding.rep.setText(String.valueOf(rep));
                }
            }


        });

        mBinding.strongButton.setOnClickListener(View ->{ //Кнопка силы
            if (perksCount > 0) {
                if (strong == 6) {
                    Toast.makeText(this, "Достигнут максимум", Toast.LENGTH_SHORT).show();
                } else {
                    perksCount--;
                    mBinding.perksCount.setText(String.valueOf(perksCount));
                    strong++;
                    mBinding.strong.setText(String.valueOf(strong));
                }
            }

        });

        mBinding.cyberimplButton.setOnClickListener(View ->{ //Кнопка киберимплантов
            if (perksCount > 0) {
                if (cyberimplants == 6) {
                    Toast.makeText(this, "Достигнут максимум", Toast.LENGTH_SHORT).show();
                } else {
                    perksCount--;
                    mBinding.perksCount.setText(String.valueOf(perksCount));
                    cyberimplants++;
                    mBinding.cyberimpl.setText(String.valueOf(cyberimplants));
                }
            }
        });

        mBinding.moneyButton.setOnClickListener(View ->{ //Кнопка денег
            if (perksCount > 0) {
                if (money == 6) {
                    Toast.makeText(this, "Достигнут максимум", Toast.LENGTH_SHORT).show();
                } else {
                    perksCount--;
                    mBinding.perksCount.setText(String.valueOf(perksCount));
                    money++;
                    mBinding.money.setText(String.valueOf(money));
                }
            }
        });

        mBinding.done.setOnClickListener(View -> {
            Intent i = new Intent();
            int[] out = {rep, strong, cyberimplants, money};
            i.putExtra("Character", out);
            setResult(1, i);
            finish();
        });



    }
}
