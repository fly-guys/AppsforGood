package com.example.appsforgood;

import java.util.ArrayList;

public class Question {
    //Data
    private String question;
    private String answer;
    private ArrayList<String> answers;


    //Constructors
    public Question(String questionText){
        question = questionText;
    }

    //Methods
    public void addAnswer(String answerText, Boolean correct){
        answers.add(answerText);
        if(correct){
            answer = answerText;
        }
    }

    public String getQuestion(){
        return question;
    }
}
