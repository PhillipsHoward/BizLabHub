package fr.wildcodeschool.hackbus.models;

public class ReponseModel {

    private String id;
    private String answer;


    public ReponseModel() {}

    public ReponseModel(String answer, UserModel sender) {
        this.answer = answer;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

}
