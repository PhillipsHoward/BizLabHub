package fr.wildcodeschool.hackbus.models;

import java.util.ArrayList;

import fr.wildcodeschool.hackbus.models.TypeModel;

public class TagsModel {
    private String nom;
    private ArrayList<TypeModel> types;
    private String uId;

    public TagsModel(String nom, ArrayList<TypeModel> types, String uId) {
        this.nom = nom;
        this.types = types;
        this.uId = uId;
    }

    public TagsModel(String nom, ArrayList<TypeModel> types) {
        this.nom = nom;
        this.types = types;
        this.uId = "";
    }

    public TagsModel() {
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public ArrayList<TypeModel> getTypes() {
        return types;
    }

    public void setTypes(ArrayList<TypeModel> types) {
        this.types = types;
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }
}
