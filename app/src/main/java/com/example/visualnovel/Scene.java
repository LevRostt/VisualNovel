package com.example.visualnovel;

import android.util.Log;

import java.io.IOException;

public class Scene {

    private int numbOfString = 0;
    private int numbOfIncImage = 0;
    private String[] scenePlot;
    private int[] incSceneImg; //Передаются номера чисел строк текта, на которых нужно инкрементировать изображение
    private String[] sceneImage;

    public Scene(String[] scenePlot, String[] sceneImage, int[] incScene){
        this.scenePlot = scenePlot;
        this.sceneImage = sceneImage;
        this.incSceneImg = incScene;
    }

    public int nextStr(){ // 0 - Оставаться в этом файле, 1 - перейти к след. сцене.
        numbOfString++;

        if (numbOfString == incSceneImg[numbOfIncImage]){
            if (numbOfString != incSceneImg.length - 1){
                numbOfIncImage++;
            }
        }

        if (numbOfString == scenePlot.length){
            return 1;
        }
        else return 0;
    }

    public String getScenePlot() {
        return scenePlot[numbOfString];
    }
    public String getSceneImage() {
        return sceneImage[numbOfIncImage];
    }

}
