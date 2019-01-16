package fr.wildcodeschool.hackbus.models;

import java.util.ArrayList;

public class QuestionModel {
    private String question;
    private String title;
    private String projet;
    private String user;
    private ArrayList<UserModel> userPotentiel;
    private int priority;
    private ArrayList<String> skills;

    public QuestionModel() {
    }

    //TODO: à dégager quand tout sera complet (utiliser autre constructeur)
    public QuestionModel(String title, String question, int priority) {
        this.title = title;
        this.question = question;
        this.priority = priority;
    }

    public QuestionModel(String title, String question, int priority, ArrayList<String> skills) {
        this.title = title;
        this.question = question;
        this.priority = priority;
        this.skills = skills;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getProjet() {
        return projet;
    }

    public void setProjet(String projet) {
        this.projet = projet;
    }

    public ArrayList<String> getSkills() {
        return skills;
    }

    public void setSkills(ArrayList<String> skills) {
        this.skills = skills;
    }
}
