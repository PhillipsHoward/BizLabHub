package fr.wildcodeschool.hackbus.models;

public class ReponseModel {

    private String answer;
    private UserModel sender;

    public ReponseModel() {}

    public ReponseModel(String answer, UserModel sender) {
        this.answer = answer;
        this.sender = sender;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public UserModel getSender() {
        return sender;
    }

    public void setSender(UserModel sender) {
        this.sender = sender;
    }
}
