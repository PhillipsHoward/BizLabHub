package fr.wildcodeschool.hackbus.models;

import java.util.ArrayList;

public class QuestionModel {

    private String id;
    private String question;
    private String title;
    private int priority;
    private ArrayList<TagsModel> skills;
    private ArrayList<ReponseModel> reponses;
    private ArrayList<String> answererId;
    private String senderId;
    private Boolean open = true;


    public QuestionModel() {
    }

    public QuestionModel(String title, String question, int priority) {
        this.open = true;
        this.title = title;
        this.question = question;
        this.priority = priority;
    }

    public QuestionModel(String title, String question, int priority, ArrayList<TagsModel> skills, Boolean open, ArrayList<ReponseModel> reponses) {
        this.title = title;
        this.question = question;
        this.priority = priority;
        this.skills = skills;
        this.open = open;
        this.reponses = reponses;
    }

    public ArrayList<ReponseModel> getReponses() {
        return reponses;
    }

    public void setReponses(ArrayList<ReponseModel> reponses) {
        this.reponses = reponses;
    }

    public ArrayList<String> getAnswererId() {
        return answererId;
    }

    public void setAnswererId(ArrayList<String> answererId) {
        this.answererId = answererId;
    }

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
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


}
