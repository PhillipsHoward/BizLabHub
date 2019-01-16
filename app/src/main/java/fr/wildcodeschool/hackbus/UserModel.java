package fr.wildcodeschool.hackbus;

import java.util.ArrayList;

public class UserModel {

    private String nom;
    private String prenom;
    private String poste;
    private String email;
    private String tel;
    private ArrayList<CompetenceModel> competence;
    private ArrayList<ProjetModel> projetEnCours;
    private ArrayList<ProjetModel> projetInitie;
    private boolean dispo;
    private String uId;

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public UserModel() {
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public ArrayList<CompetenceModel> getCompetence() {
        return competence;
    }

    public void setCompetence(ArrayList<CompetenceModel> competence) {
        this.competence = competence;
    }

    public ArrayList<ProjetModel> getProjetEnCours() {
        return projetEnCours;
    }

    public void setProjetEnCours(ArrayList<ProjetModel> projetEnCours) {
        this.projetEnCours = projetEnCours;
    }

    public ArrayList<ProjetModel> getProjetInitie() {
        return projetInitie;
    }

    public void setProjetInitie(ArrayList<ProjetModel> projetInitie) {
        this.projetInitie = projetInitie;
    }

    public boolean isDispo() {
        return dispo;
    }

    public void setDispo(boolean dispo) {
        this.dispo = dispo;
    }
}
