package fr.wildcodeschool.hackbus.models;

import java.util.ArrayList;

public class QuestionModel {

    private String id;
    private String question;
    private String title;
    private ProjetModel projet;
    private UserModel sender;
    private ArrayList<UserModel> userReponse;
    private int priority;
    private ArrayList<String> skills;
    private Boolean open = true;
    private ArrayList<ReponseModel> allReponses;

    public QuestionModel() {
    }

    public QuestionModel(UserModel sender, String title, String question, int priority) {
        this.open = true;
        this.sender = sender;
        this.title = title;
        this.question = question;
        this.priority = priority;
    }

    public QuestionModel(String title, String question, int priority) {
        this.open = true;
        this.title = title;
        this.question = question;
        this.priority = priority;
    }

    public QuestionModel(UserModel sender, String title, String question, int priority, ArrayList<String> skills) {
        this.open = true;
        this.sender = sender;
        this.title = title;
        this.question = question;
        this.priority = priority;
        this.skills = skills;
    }

    public ArrayList<ReponseModel> getAllReponses() {
        return allReponses;
    }

    public void setAllReponses(ArrayList<ReponseModel> allReponses) {
        this.allReponses = allReponses;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ProjetModel getProjet() {
        return projet;
    }

    public void setProjet(ProjetModel projet) {
        this.projet = projet;
    }

    public ArrayList<UserModel> getUserReponse() {
        return userReponse;
    }

    public void setUserReponse(ArrayList<UserModel> userReponse) {
        this.userReponse = userReponse;
    }

    public Boolean getOpen() {
        return open;
    }

    public ArrayList<String> getSkills() {
        return skills;
    }

    public void setSkills(ArrayList<String> skills) {
        this.skills = skills;
    }

    public UserModel getSender() {
        return sender;
    }

    public void setSender(UserModel sender) {
        this.sender = sender;
    }

    public Boolean isOpen() {
        return open;
    }

    public void setOpen(Boolean open) {
        this.open = open;
    }
}
