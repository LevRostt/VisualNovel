package com.example.visualnovel;

public class MiniGame {
    private String[] word = {"1C","BD","55","E9","7A"};
    private String[][] matrix = new String[5][5];
    private MiniGameCombination combination = new MiniGameCombination();
    private int heal = 1;

    public MiniGame(){

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++){
                matrix[i][j] = word[(int) (Math.random()*5)];
            }
        }

    }

    public String getMatrix(int i,int j) {// Возвращает элемент, который нужно вставить в ячейку
        return matrix[i][j];
    }

    public int getOrientation(){ // 0 если горизон, 1 если по вертикали
        return combination.getProgress()%2;
    }

    public String getCombination(){
        return combination.getStringOfCombnation();
    }


}
