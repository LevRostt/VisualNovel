package com.example.visualnovel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MainGameGeneric {
    private Map<String, Act> StoryLine = new HashMap<String, Act>();
    private Character character;
    private String storyNow = "0";
    private int numberOfNextAct = 0;


    public MainGameGeneric(Character character){
        this.character = character;
        Scene s0 = new Scene(new String[]{"Вы просыпаетесь в темном переулке, дезориентированные и растерянные. Вы проверяете свой нейроинтерфейс, и ваша статистика показывает значения указанные выше.",
                "Вы не помните, как вы сюда попали, но вы испытываете странное ощущение. В голове - как будто чего-то не хватает.",
                "Вы выбредаете из переулка на оживленные улицы города, пытаясь собрать воедино то, что произошло.",
                "Перед вами открываются огроный город, с домами уходящими ввысь. И вдруг в вашей голове промелькает воспоминие старого района и его улиц.",
                "Кажется это лишь фонили нейроимпланты, но даже сердце говорит что оно знает направление к этому месту"},
                new String[]{"s0","s00"}, new int[]{3, -1});
        SceneWithChoise sc0 = new SceneWithChoise("1 - Отправиться по зову сердца и попробовать найти район в окрайне города\n2 - Не обращать внимание на помехи и продвигаться к центру. Там точно будут люди, которые как-то помогут",
                "sc0",new String[]  {"4060", "0000"});

        Scene s01 = new Scene(new String[]{"- Направившись по волю сердца, вы оказывается в заброшенном районе.\n",
                "Вы решаетесь в него зайти, ибо всё равно альтернатив нет, однако уже проходя мимо домов вам становится хуже и, вас вырубает от сильнейшего удара током...\n",
                "Как оказалось, вы натыкнулись на группу хакеров, которые сразу решили вас атаковать. Именно из-за этого вам поплохело, а далее последовал удар.\n",
                "Однако их заинтересовали ваши ваше тело и современные киберимпланты, которые выдержали их атаку. Они проявляют к вам интерес и предлагают помочь восстановить память. \n",
                "Вам нечего терять. Ваши вчерашние убийцы, становятся вашими товарищами, и вы принимаете их предложение и присоединяетесь к их команде...\n",
                "Они устанавливают новый киберимплантат — Synaptic Bridge — который позволяет вам подключить ваш мозг к Интернету. Ваши «киберимплантаты» увеличиваются на 6, а ваша «репутация» подскакивает на 4."},
                new String[]{"s01"}, new int[]{-1});

        Scene s02 = new Scene(new String[]{"Блуждая по городу, вы натыкаетесь на группу уличных головорезов, которые угрожают вас ограбить.\n",
                "Вы можете либо бороться с ними, либо отдать им свои деньги."},new String[]{"s02"}, new int[]{-1});

        Act act0 = new Act("0", new Scene[]{s0, s01, s02}, sc0, new String[]{"0000", "0000"});



//        Act act10 = new Act("10", new Scene[]{}, sc0, new String[]{});
//        Act act20 = new Act("20", new Scene[]{}, sc0, new String[]{});

        StoryLine.put("0", act0);
//        StoryLine.put("10", act10);
//        StoryLine.put("20", act20);

    }

    public String getText(){
        return StoryLine.get(storyNow).getText();
    }

    public String getImage(){
        return StoryLine.get(storyNow).getImg();
    }

    public int nextText(){

        return StoryLine.get(storyNow).nextText();

    }

    public void nextScene(int numberNext, Character character){

        StoryLine.get(storyNow).choiseNextAct(numberNext,character);
        numberOfNextAct = numberNext;

    }

    public void nextAct(){
        storyNow = numberOfNextAct + storyNow;
    }

    public int getCountOfButton(){
        return StoryLine.get(storyNow).getCountOfButton();
    }
}
