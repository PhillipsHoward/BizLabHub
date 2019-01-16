package fr.wildcodeschool.hackbus;

import java.util.ArrayList;

public class CompetenceModel {

    private TagsModel tag;
    private int niveau;
    private ArrayList<TypeModel> typeCompetence;

    public CompetenceModel() {
    }

    public TagsModel getTag() {
        return tag;
    }

    public void setNom(TagsModel tag) {
        this.tag = tag;
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