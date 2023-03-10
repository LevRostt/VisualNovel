package com.example.visualnovel.ui;

import static java.lang.Thread.sleep;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.visualnovel.Character;
import com.example.visualnovel.MainGameGeneric;
import com.example.visualnovel.MiniGame;
import com.example.visualnovel.R;
import com.example.visualnovel.databinding.GameLayoutBinding;

public class MainActivity extends AppCompatActivity {

    private MainGameGeneric game;
    private GameLayoutBinding mBinding;
    private Character character;
    private int status;
//    private int miniGameRes;
    private int miniApp;
//    SharedPreferences prefs;

    private void updateScreenInfo(){
        mBinding.repCount.setText(String.valueOf(character.getReputation()));
        mBinding.strongCount.setText(String.valueOf(character.getStrong()));
        mBinding.implantsCount.setText(String.valueOf(character.getCyberimplants()));
        mBinding.moneyCount.setText(String.valueOf(character.getMoney()));
        mBinding.image.setImageResource(getResources().getIdentifier(game.getImage(),"drawable", this.getPackageName()));
        mBinding.mainText.setText(game.getText());
        if (game.getImage() == "end"){
            mBinding.buttonBased.setVisibility(View.GONE);
        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        switch (resultCode){
            case 1: //CharacterGeneric
                int[] i = data.getIntArrayExtra("Character");
                Log.d("MyApp","We get information back");
                character = new Character(i[0],i[1],i[2],i[3]);
                updateScreenInfo();
                //Log.d("CharacterData",String.valueOf(character.getStat()));
                break;
            case 2: //MiniGameRes
                int resOfGame = data.getIntExtra("res", -1); // 0 - поражение | 1 - победа
                //Toast.makeText(this,String.valueOf(resOfGame),Toast.LENGTH_LONG).show();
                if (resOfGame == 0){
                    game.setNextAct("0");
                }
                else{
                    game.setNextAct("1");
                }
                miniApp = 0;
                break;
        }
    }

    private void characterGeneric(){
        if (character == null){ //Первый вход в игру

            //Intent game = new Intent(this, MiniGameActivity.class);
            //startActivityForResult(game, 2);

            Intent creationOfCharacter = new Intent(this, CharacterScreenActivity.class);
            startActivityForResult(creationOfCharacter,1 );

//            prefs.edit().putBoolean("firstrun", false).commit();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = mBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());
//        prefs = getSharedPreferences("com.example.visualnovel", MODE_PRIVATE);

        Intent i = new Intent(this, ChoiseScreenActivity.class);
        startActivity(i);

        game = new MainGameGeneric(character); //Создаём историю


        mBinding.buttonBased.setOnClickListener(View -> {

            if (character == null){ //Проверка на создание персонажа
                characterGeneric();
            }
            else{
                if (mBinding.button2.getVisibility() == View.GONE){
                    status = game.nextText();
                    if (status == -1) {
                        mBinding.buttonBased.setText("1");
                        int count = game.getCountOfButton();

                        if (count != 0) {
                            mBinding.button2.setVisibility(android.view.View.VISIBLE);
                            if (count >= 3) {
                                mBinding.button3.setVisibility(android.view.View.VISIBLE);
                            }
                        }
                        else{
                            game.nextAct();
                        }
                    }

                    if (status != -1 && status != 0){

                        character.setChanges(game.getChoiseResult());
                        miniApp = game.nextAct();

                        if (miniApp == 0) {
                            if (game.getStoryNow() == "00") {
                                mBinding.buttonBased.setVisibility(android.view.View.GONE);
                            }
                        }
                        else{

                            Intent miniGame = new Intent(this, MiniGameActivity.class);
                            startActivityForResult(miniGame, 2);

//                            if (miniGameRes == 0){
//                                game.setNextAct("0");
//                            }
//                            else{
//                                game.setNextAct("1");
//                            }

                        }
                    }

                }
                else{
                    game.nextScene(1, character);
                    mBinding.button2.setVisibility(android.view.View.GONE);
                    mBinding.button3.setVisibility(android.view.View.GONE);
                    mBinding.buttonBased.setText("Далее...");
                }

                if (miniApp == 0) {
                    updateScreenInfo();
                }

            }
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


//    @Override
//    protected void onResume(){
//        super.onResume();
////        if (prefs.getBoolean("firstrun", true)){
//
//
//    }

}