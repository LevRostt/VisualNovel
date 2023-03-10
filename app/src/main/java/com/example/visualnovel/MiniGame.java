package com.example.visualnovel;

public class MiniGame {
    private String[] word = {"1C","BD","55","E9","7A"};
    private String[][] matrix = new String[5][5];
    private MiniGameCombination combination = new MiniGameCombination();
    private int heal = combination.length()/2 + combination.length()%2; // 0 - dead / 1 - lastChance / 2 - based
    private int xCoords = 0;
    private int yCoords = 0;
    private int orientation = 0; // 0 - Horizontal / 1 - Vertical


    public MiniGame(){

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++){
                matrix[i][j] = word[(int) (Math.random()*5)];
            }
        }

    }

    public int pushCheck(){
        int code = combination.check(matrix[xCoords][yCoords]);
        if (code == -1 && heal != 1){
            return 0;
        }
        else {
            matrix[xCoords][yCoords] = "[-]";
            if (code == 0) {

                if (combination.getProgress() == combination.length()) {

                    return 1;

                } else {

                    if (orientation == 0) {
                        orientation++;
                    } else {
                        orientation--;
                    }

                    return 0;
                }

            } else {

                heal--;
                if (heal == 0) {

                    return -1;

                } else {
                    if (orientation == 0) {
                        orientation++;
                    } else {
                        orientation--;
                    }
                    return 0;
                }
            }
        }
    }

    public String getMatrix(int i,int j) {// Возвращает элемент, который нужно вставить в ячейку
        return matrix[i][j];
    }

    public int getOrientation(){ // 0 если горизон, 1 если по вертикали
        return orientation;
    }

    public String getCombination(){
        return combination.getStringOfCombnation();
    }

    public void setxCoords(int increase) {
        this.xCoords += increase;
        if (this.xCoords < 0){
            this.xCoords = 4;
        }
        if (this.xCoords > 4){
            this.xCoords = 0;
        }
    }

    public void setyCoords(int increase) {
        this.yCoords += increase;
        if (this.yCoords < 0){
            this.yCoords = 4;
        }
        if (this.yCoords > 4){
            this.yCoords = 0;
        }
    }

    public int getHeal() {
        return heal;
    }

    public int getxCoords() {
        return xCoords;
    }

    public int getyCoords() {
        return yCoords;
    }
}
