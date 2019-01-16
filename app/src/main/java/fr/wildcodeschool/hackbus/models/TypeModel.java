package fr.wildcodeschool.hackbus.models;

import android.support.annotation.NonNull;

public class TypeModel implements Comparable<TypeModel> {

    private String nom;

    public TypeModel() {
    }

    public String getNom() {
        return nom;
    }

    public TypeModel(String nom) {
        this.nom = nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }


    @Override
    public int compareTo(@NonNull TypeModel o) {
        if (this.getNom().charAt(0) == o.getNom().charAt(0)) {
            return 0;
        } else if (this.getNom().charAt(0) < o.getNom().charAt(0)) {
            return -1;
        }

        return 1;
    }

}