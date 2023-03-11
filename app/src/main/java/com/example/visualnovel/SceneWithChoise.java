package com.example.visualnovel;

public class SceneWithChoise{
    private String[] changesPerson; // массив с двумя строками. строка с индексом "0" - вариант в случае А, с индексом "1" и тд. - вариант в случае Б. Строка содержит четыре значения прироста/убытка характеристик: RSCM.
    private String sceneText;
    private String sceneImage;

    public SceneWithChoise(String sceneText, String sceneImage, String[] changesPerson) {
        this.changesPerson = changesPerson;
        this.sceneImage = sceneImage;
        this.sceneText = sceneText;
    }

    public int getCountOfButton() { return changesPerson.length; }
    public String getChoiseResult(int choise) { return changesPerson[choise]; }

    public String getSceneText() { return sceneText; }
    public String getSceneImage() { return sceneImage; }
}
