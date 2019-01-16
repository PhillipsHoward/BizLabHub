package fr.wildcodeschool.hackbus;

import java.util.ArrayList;

public class ProjetModel {

    private String nom;
    private String description;
    private TypeModel typeProjet;
    private ArrayList<CompetenceModel> competence;
    private String lienGitHub;
    private ArrayList<UserModel> team;
    private UserModel initiateur;
    private String photo;
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ProjetModel() {
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

    public ArrayList<CompetenceModel> getCompetence() {
        return competence;
    }

    public void setCompetence(ArrayList<CompetenceModel> competence) {
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
}