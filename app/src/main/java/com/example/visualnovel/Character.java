package com.example.visualnovel;

public class Character {

    private Integer reputation, strong, cyberimplants, money;

    public Character(int reputation, int strong, int cyberimplants, int money) {
        this.reputation = reputation;
        this.strong = strong;
        this.cyberimplants = cyberimplants;
        this.money = money;
    }

    public void setChanges(String changes){ // На вход приходит строка вида RSCM - Rep, Strong, Cyberimplants, Money
        int i = 0;
        int rm = 2, sm = 2, cm = 2, mm = 2;
        char rep = changes.charAt(i);
        if (rep == '-'){
            rm--;
            i++;
            rep = changes.charAt(i);
        }
        i++;
        char strong = changes.charAt(i);
        if (strong == '-'){
            sm--;
            i++;
            strong = changes.charAt(i);
        }
        i++;
        char cyberimpl = changes.charAt(i);
        if (cyberimpl == '-'){
            cm--;
            i++;
            cyberimpl = changes.charAt(i);
        }
        i++;
        char money = changes.charAt(i);
        if (money == '-'){
            mm--;
            i++;
            money = changes.charAt(i);
        }
        this.reputation += (rep-'0')*((int)Math.pow(-1,rm));
        this.strong += (strong-'0')*((int)Math.pow(-1,sm));
        this.cyberimplants += (cyberimpl-'0')*((int)Math.pow(-1,cm));
        this.money += (money-'0')*((int)Math.pow(-1,mm));
    }

    public int getReputation() {
        return reputation;
    }

    public int getStrong() {
        return strong;
    }

    public int getCyberimplants() {
        return cyberimplants;
    }

    public int getMoney() {
        return money;
    }

    public int getStat(){
        return Integer.parseInt(reputation.toString() + strong.toString() + cyberimplants.toString() + money.toString());
    }
//    public void setReputation(int reputation) {
//        this.reputation = reputation;
//    }
//    public void setCyberimplants(int cyberimplants) {
//        this.cyberimplants = cyberimplants;
//    }
//    public void setStrong(int strong) {
//        this.strong = strong;
//    }
//    public void setMoney(int money) {
//        this.money = money;
//    }
}
