package fr.wildcodeschool.hackbus.models;

import java.util.ArrayList;



public class CompetenceModel {

    private TagsModel tag;
    private int niveau;

    public CompetenceModel() {
    }

    public CompetenceModel(TagsModel tag, int niveau) {
        this.tag = tag;
        this.niveau = niveau;
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
}
