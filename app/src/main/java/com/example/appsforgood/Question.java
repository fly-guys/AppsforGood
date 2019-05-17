package com.example.appsforgood;

import java.util.ArrayList;

public class Question {
    //Data
    private String question;
    private ArrayList<String> choices = new ArrayList<>();
    private String answer;

    //Constructors
    public Question(String question, String choice1, String choice2, String choice3, String choice4, String answer){
        this.question = question;
        this.answer = answer;
        choices.add(choice1);
        choices.add(choice2);
        choices.add(choice3);
        choices.add(choice4);
    }
    //Methods

    /**
     * Gets the Question
     * @return the Question
     */
    public String getQuestion(){
        return question;
    }

    /**
     * Gets the first choice
     * @return the first choice as a String
     */
    public String getChoice1(){
        return choices.get(0);
    }

    /**
     * Gets the second choice
     * @return the second choice as a String
     */
    public String getChoice2(){
        return choices.get(1);
    }

    /**
     * Gets the third choice
     * @return the third choice as a String
     */
    public String getChoice3(){
        return choices.get(2);
    }

    /**
     * Gets the fourth choice
     * @return the fourth choice as a String
     */
    public String getChoice4(){
        return choices.get(3);
    }

    /**
     * Gets the answer
     * @return the answer as a String
     */
    public String getAnswer(){
        return answer;
    }
}
