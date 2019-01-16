package fr.wildcodeschool.hackbus;

import fr.wildcodeschool.hackbus.models.QuestionModel;
import fr.wildcodeschool.hackbus.models.UserModel;

public class Singleton {

    private static final Singleton ourInstance = new Singleton();
    private QuestionModel currentQuestion;
    private UserModel user;

    public static Singleton getInstance() {
        return ourInstance;
    }



    private Singleton() {

    }

    public QuestionModel getCurrentQuestion() {
        return currentQuestion;
    }

    public void setCurrentQuestion(QuestionModel currentQuestion) {
        this.currentQuestion = currentQuestion;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    /* * LISTE DES TYPES

    -Informatique
    -Développement
    -Physique
    -Mathématiques
    -Relations humaines
    -Communication
    -Biologie
    -Chimie
    -Mécanique
    -Electronique
    -Travaux manuels
    -Ecriture
    -Investigation
    -Négociation
    -Gestion
    -Finances/Comptabilité
    -Architecture
    -Economie
    -Modélisation 3D
    -Dessin
     */

}
