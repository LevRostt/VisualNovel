package com.example.visualnovel;

import java.util.ArrayList;

public class Act {
    private String actName;
    private Scene[] sceneList; //with index 0 -scene before choise, i - after choise;
    private SceneWithChoise choiseScene;
    private int sceneIndex = 0;
    private String[] minStat; //RSCM для каждой сцены(текущей, и i-следующих)

    public Act(String actName, Scene[] sceneList, SceneWithChoise choiseScene, String[] minStat) {
        this.actName = actName;
        this.sceneList = sceneList;
        this.choiseScene = choiseScene;
        this.minStat = minStat;
    }

    public int nextText(){
        if (sceneIndex == 0) {
            int id = sceneList[0].nextStr();
            if (id == 1){
                sceneIndex = -1;
                return -1;
            }
            else{
                return 0;
            }
        }
        else {
            int id = sceneList[sceneIndex].nextStr();
            if (id == 1){
                return sceneIndex;
            }
            else{
                return 0;
            }
        }
    }

    public void choiseNextAct(int nextScene, Character character){
        int stat = character.getStat();
        String nedeed = minStat[nextScene-1];
        if ((stat/1000 >= Integer.parseInt(nedeed)/1000) && ((stat/100)%10 >= (Integer.parseInt(nedeed)/100)%10) && ((stat/10)%10 >= (Integer.parseInt(nedeed)/10)%10) && (stat%10 >= Integer.parseInt(nedeed)%10)){
            sceneIndex = nextScene;
        }
        else{
            sceneIndex = minStat.length-1;
        }

    }

    public String getText(){
        if (sceneIndex != -1) {
            return sceneList[sceneIndex].getScenePlot();
        }
        else {
            return choiseScene.getSceneText();
        }
    }

    public String getImg(){
        if (sceneIndex != -1) {
            return sceneList[sceneIndex].getSceneImage();
        }
        else {
            return choiseScene.getSceneImage();
        }
    }

    public String getActName(){
        return getActName();
    }

    public int getSceneIndex(){
        return sceneIndex;
    }

    public int getCountOfButton(){ return choiseScene.getCountOfButton(); }

    public String getChoiseResult(){ return choiseScene.getChoiseResult(sceneIndex-1);}
}
