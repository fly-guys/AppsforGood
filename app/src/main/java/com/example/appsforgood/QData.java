package com.example.appsforgood;

public class QData {
    private String question;
    private String ans1;
    private String ans2;
    private String ans3;
    private String ans4;

    public QData(String question, String ans1, String ans2, String ans3, String ans4)
    {
        this.question  = question;
        this.ans1  = ans1;
        this.ans2  = ans2;
        this.ans3  = ans3;
        this.ans4  = ans4;
    }

    public String getQuestion() {

        return question;
    }

    public String getAns1() {

        return ans1;
    }

    public String getAns2() {

        return ans2;
    }

    public String getAns3() {

        return ans3;
    }

    public String getAns4() {

        return ans4;
    }

    public void setProductName(String question)
    {
        System.out.println("Setting question ...");
        this.question = question;
    }

    public void setAns1(String ans1)
    {
        System.out.println("Setting first answer ...");
        this.ans1 = ans1;
    }

    public void setAns2(String ans2)
    {
        System.out.println("Setting second answer ...");
        this.ans2 = ans2;
    }

    public void setAns3(String ans3)
    {
        System.out.println("Setting third answer ...");
        this.ans3 = ans3;
    }

    public void setAns4(String ans4)
    {
        System.out.println("Setting fourth answer ...");
        this.ans4 = ans4;
    }



}
