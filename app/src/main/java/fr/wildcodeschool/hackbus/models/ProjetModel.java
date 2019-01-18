package fr.wildcodeschool.hackbus.models;

import java.util.ArrayList;


public class ProjetModel {

    private String nom;
    private String description;
    private TypeModel typeProjet;
    private ArrayList<TagsModel> competence = new ArrayList<>();
    private String lienGitHub;
    private ArrayList<UserModel> team = new ArrayList<>();
    private UserModel initiateur;
    private String photo;
    private String id;
    private ArrayList<QuestionModel> questions = new ArrayList<>();

    public ProjetModel() {
    }

    public ArrayList<QuestionModel> getQuestions() {
        return questions;
    }

    public void setQuestions(ArrayList<QuestionModel> questions) {
        this.questions = questions;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TypeModel getTypeProjet() {
        return typeProjet;
    }

    public void setTypeProjet(TypeModel typeProjet) {
        this.typeProjet = typeProjet;
    }

    public ArrayList<TagsModel> getCompetence() {
        return competence;
    }

    public void setCompetence(ArrayList<TagsModel> competence) {
        this.competence = competence;
    }

    public String getLienGitHub() {
        return lienGitHub;
    }

    public void setLienGitHub(String lienGitHub) {
        this.lienGitHub = lienGitHub;
    }

    public ArrayList<UserModel> getTeam() {
        return team;
    }

    public void setTeam(ArrayList<UserModel> team) {
        this.team = team;
    }

    public UserModel getInitiateur() {
        return initiateur;
    }

    public void setInitiateur(UserModel initiateur) {
        this.initiateur = initiateur;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "ProjetModel{" +
                "nom='" + nom + '\'' +
                ", description='" + description + '\'' +
                ", typeProjet=" + typeProjet +
                ", competence=" + competence +
                ", lienGitHub='" + lienGitHub + '\'' +
                ", team=" + team +
                ", initiateur=" + initiateur +
                ", photo='" + photo + '\'' +
                ", id='" + id + '\'' +
                ", questions=" + questions +
                '}';
    }
}