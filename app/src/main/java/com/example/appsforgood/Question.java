package com.example.appsforgood;

import java.util.ArrayList;

public class Question {
    private String question;
    private ArrayList<String> choices = new ArrayList<>();
    private String answer;

    public Question(String question, String choice1, String choice2, String choice3, String choice4, String answer){
        this.question = question;
        this.answer = answer;
        choices.add(choice1);
        choices.add(choice2);
        choices.add(choice3);
        choices.add(choice4);
    }

    public String getQuestion(){
        return question;
    }

    public String getChoice1(){
        return choices.get(0);
    }

    public String getChoice2(){
        return choices.get(1);
    }

    public String getChoice3(){
        return choices.get(2);
    }

    public String getChoice4(){
        return choices.get(3);
    }

    public String getAnswer(){
        return answer;
    }
}
