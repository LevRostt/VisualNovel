package com.example.visualnovel;

public class MiniGameCombination {

    private String[] activeWord = {"1C","BD","55","E9","7A"};
    private int len = 3 + (int)(Math.random()*3);
    private String[] combination = new String[len];
    private int progress = 0;

    public MiniGameCombination() {
        for (int i = 0; i < len; i++) {
            combination[i] = activeWord[(int) (Math.random()*5)];
        }
    }

    public int length() {
        return len;
    }

    public String getStringOfCombnation(){
        String string = "";
        for (int i = 0; i < len; i++){
            string += combination[i] + " ";
        }
        return string;
    }

    public int getProgress() {
        return progress;
    }

    public int check(String comb) {// Принимает элемент для сравнения, возвращает 0, если подходит ||  1, если не подходит || -1, Если ничего
        if (comb == combination[progress]) {
            combination[progress] = "--";
            progress++;
            return 0;
        } else if (comb == "[-]") {

            return -1;

        } else {
            return 1;
        }

    }
}
