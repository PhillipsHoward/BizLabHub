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
    private ArrayList<TagsModel> skills;
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

    public QuestionModel(UserModel sender, String title, String question, int priority, ArrayList<UserModel> userReponse, ArrayList<TagsModel> skills, Boolean open, ArrayList<ReponseModel> allReponses, ProjetModel projet) {
        this.sender = sender;
        this.title = title;
        this.question = question;
        this.priority = priority;
        this.userReponse = userReponse;
        this.skills = skills;
        this.open = open;
        this.allReponses = allReponses;
        this.projet = projet;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public ProjetModel getProjet() {
        return projet;
    }

    public void setProjet(ProjetModel projet) {
        this.projet = projet;
    }

    public UserModel getSender() {
        return sender;
    }

    public void setSender(UserModel sender) {
        this.sender = sender;
    }

    public ArrayList<UserModel> getUserReponse() {
        return userReponse;
    }

    public void setUserReponse(ArrayList<UserModel> userReponse) {
        this.userReponse = userReponse;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public ArrayList<TagsModel> getSkills() {
        return skills;
    }

    public void setSkills(ArrayList<TagsModel> skills) {
        this.skills = skills;
    }

    public Boolean isOpen() {
        return open;
    }

    public void setOpen(Boolean open) {
        this.open = open;
    }

    public ArrayList<ReponseModel> getAllReponses() {
        return allReponses;
    }

    public void setAllReponses(ArrayList<ReponseModel> allReponses) {
        this.allReponses = allReponses;
    }
}
