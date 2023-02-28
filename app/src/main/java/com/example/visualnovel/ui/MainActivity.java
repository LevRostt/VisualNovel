package com.example.visualnovel.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.visualnovel.Character;
import com.example.visualnovel.MainGameGeneric;
import com.example.visualnovel.R;
import com.example.visualnovel.databinding.GameLayoutBinding;

public class MainActivity extends AppCompatActivity {

    private MainGameGeneric game;
    private GameLayoutBinding mBinding;
    private Character character;
    private int status;
//    SharedPreferences prefs;

    private void updateScreenInfo(){
        mBinding.repCount.setText(String.valueOf(character.getReputation()));
        mBinding.strongCount.setText(String.valueOf(character.getStrong()));
        mBinding.implantsCount.setText(String.valueOf(character.getCyberimplants()));
        mBinding.moneyCount.setText(String.valueOf(character.getMoney()));
        mBinding.image.setImageResource(getResources().getIdentifier(game.getImage(),"drawable", this.getPackageName()));
        mBinding.mainText.setText(game.getText());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = mBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());
//        prefs = getSharedPreferences("com.example.visualnovel", MODE_PRIVATE);



        //Написани логики объединения интерфейса и классов
        game = new MainGameGeneric(character);


        mBinding.buttonBased.setOnClickListener(View -> {



            if (mBinding.button2.getVisibility() == View.GONE){
                status = game.nextText();
                if (status == -1) {
                    mBinding.buttonBased.setText("1");
                    int count = game.getCountOfButton();

                    mBinding.button2.setVisibility(android.view.View.VISIBLE);
                    if (count >= 3){
                        mBinding.button3.setVisibility(android.view.View.VISIBLE);
                    }
                }

                if (status != -1 && status != 0){

                    character.setChanges(game.getChoiseResult());
                    game.nextAct();
                    if (game.getStoryNow() == "00"){
                        mBinding.buttonBased.setVisibility(android.view.View.GONE);
                    }

                }

            }
            else{
                game.nextScene(1, character);
                mBinding.button2.setVisibility(android.view.View.GONE);
                mBinding.button3.setVisibility(android.view.View.GONE);
                mBinding.buttonBased.setText("Далее...");
            }

            updateScreenInfo();

        });

        mBinding.button2.setOnClickListener(View ->{
            game.nextScene(2, character);
            mBinding.button2.setVisibility(android.view.View.GONE);
            mBinding.button3.setVisibility(android.view.View.GONE);
            mBinding.buttonBased.setText("Далее...");
            updateScreenInfo();
        });

        mBinding.button3.setOnClickListener(View ->{
            game.nextScene(3, character);
            mBinding.button2.setVisibility(android.view.View.GONE);
            mBinding.button3.setVisibility(android.view.View.GONE);
            mBinding.buttonBased.setText("Далее...");
            updateScreenInfo();
        });


    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        switch (resultCode){
            case 1:
                int[] i = data.getIntArrayExtra("Character");
                Log.d("MyApp","We get information back");
                character = new Character(i[0],i[1],i[2],i[3]);
                Log.d("CharacterData",String.valueOf(character.getStat()));
        }
        updateScreenInfo();
    }

    @Override
    protected void onResume(){
        super.onResume();
//        if (prefs.getBoolean("firstrun", true)){
        if (character == null){
            Intent i = new Intent(this, CharacterScreenActivity.class);
            startActivityForResult(i,1 );
//            prefs.edit().putBoolean("firstrun", false).commit();
        }

    }

}