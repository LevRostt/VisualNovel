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
        String rep = String.valueOf(changes.charAt(i));
        i++;
        if (rep == "-"){
            rep += String.valueOf(changes.charAt(i));
            i++;
        }
        String strong = String.valueOf(changes.charAt(i));
        i++;
        if (strong == "-"){
            strong += String.valueOf(changes.charAt(i));
            i++;
        }
        String cyberimpl = String.valueOf(changes.charAt(i));
        i++;
        if (cyberimpl == "-"){
            cyberimpl += String.valueOf(changes.charAt(i));
            i++;
        }
        String money = String.valueOf(changes.charAt(i));
        i++;
        if (money == "-"){
            money += String.valueOf(changes.charAt(i));
            i++;
        }
        this.money += Integer.parseInt(money);
        this.cyberimplants += Integer.parseInt(cyberimpl);
        this.strong += Integer.parseInt(strong);
        this.reputation += Integer.parseInt(rep);
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
