package fr.wildcodeschool.hackbus;

import fr.wildcodeschool.hackbus.models.QuestionModel;

//Listener pour "hey, t'as une nouvelle question !"
public interface QuestionReponseListener {
    void onChange(QuestionModel question);
}
