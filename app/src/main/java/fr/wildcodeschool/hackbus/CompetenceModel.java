package fr.wildcodeschool.hackbus;

import java.util.ArrayList;

public class CompetenceModel {

    private String nom;
    private int niveau;
    private ArrayList<TypeModel> typeCompetence;

    public CompetenceModel() {
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getNiveau() {
        return niveau;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }

    public ArrayList<TypeModel> getTypeCompetence() {
        return typeCompetence;
    }

    public void setTypeCompetence(ArrayList<TypeModel> typeCompetence) {
        this.typeCompetence = typeCompetence;
    }
}