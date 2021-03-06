package fr.wildcodeschool.hackbus;

import fr.wildcodeschool.hackbus.models.ProjetModel;
import fr.wildcodeschool.hackbus.models.QuestionModel;
import fr.wildcodeschool.hackbus.models.UserModel;

public class Singleton {

    private static final Singleton ourInstance = new Singleton();
    private QuestionModel currentQuestion;
    private UserModel user;
    private ProjetModel newProject = new ProjetModel();
    private ProjetModel currentProject = new ProjetModel();

    public static Singleton getInstance() {
        return ourInstance;
    }

    private Singleton() {

    }

    public ProjetModel getNewProject() {
        return newProject;
    }

    public void setNewProject(ProjetModel newProject) {
        this.newProject = newProject;
    }

    public QuestionModel getCurrentQuestion() {
        return currentQuestion;
    }

    public void setCurrentQuestion(QuestionModel currentQuestion) {
        this.currentQuestion = currentQuestion;
    }

    public ProjetModel getCurrentProject() {
        return currentProject;
    }

    public void setCurrentProject(ProjetModel currentProject) {
        this.currentProject = currentProject;
    }

}
