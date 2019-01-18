package fr.wildcodeschool.hackbus;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import java.util.ArrayList;

import fr.wildcodeschool.hackbus.models.CompetenceModel;
import fr.wildcodeschool.hackbus.models.ProjetModel;
import fr.wildcodeschool.hackbus.models.QuestionModel;
import fr.wildcodeschool.hackbus.models.TagsModel;
import fr.wildcodeschool.hackbus.models.UserModel;

public class MainActivity extends SuperActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        /*final SingletonData singletonData = SingletonData.getInstance();


        CompetenceModel competence1 = new CompetenceModel();
        competence1.setNiveau(3);
        competence1.setNom(singletonData.getTags().get(0));

        CompetenceModel competence2 = new CompetenceModel();
        competence2.setNiveau(2);
        competence2.setNom(singletonData.getTags().get(3));

        CompetenceModel competence3 = new CompetenceModel();
        competence3.setNiveau(1);
        competence3.setNom(singletonData.getTags().get(2));

        CompetenceModel competence4 = new CompetenceModel();
        competence4.setNiveau(4);
        competence4.setNom(singletonData.getTags().get(5));


        UserModel user1 = new UserModel();
        user1.setNom("Le Grand");
        user1.setPrenom("Edouard");
        user1.setPoste("Grand Architecte de l'univers");
        user1.setEmail("yolo@gmail.com");
        user1.setTel(("04 05 04 03 44"));
        user1.setDispo(false);
        ArrayList<CompetenceModel> competences1 = new ArrayList<>();
        competences1.add(competence1);
        competences1.add(competence3);
        user1.setCompetence(competences1);
        ArrayList<ProjetModel> projetsInities1 = new ArrayList<>();
        projetsInities1.add(singletonData.getProjects().get(0));
        user1.setProjetInitie(projetsInities1);
        user1.setProjetEnCours(new ArrayList<>(projetsInities1));
        user1.setQuestionAsked(new ArrayList<QuestionModel>());
        user1.setQuestionNeedAnswer(new ArrayList<QuestionModel>());

        UserModel user2 = new UserModel();
        user2.setNom("Le Joyeux");
        user2.setPrenom("Thibault");
        user2.setPoste("Architecte systeme");
        user2.setEmail("thibz@gmail.com");
        user2.setTel(("04 06 04 01 44"));
        user2.setDispo(false);
        ArrayList<CompetenceModel> competences2 = new ArrayList<>();
        competences2.add(competence2);
        competences2.add(competence3);
        user2.setCompetence(competences2);
        ArrayList<ProjetModel> projetsInities2 = new ArrayList<>();
        projetsInities2.add(singletonData.getProjects().get(0));
        user2.setProjetInitie(new ArrayList<ProjetModel>());
        user2.setProjetEnCours(new ArrayList<>(projetsInities2));
        user2.setQuestionAsked(new ArrayList<QuestionModel>());
        user2.setQuestionNeedAnswer(new ArrayList<QuestionModel>());

        UserModel user3 = new UserModel();
        user3.setNom("Le Hardis");
        user3.setPrenom("Tom");
        user3.setPoste("Developper UiX");
        user3.setEmail("tomz@gmail.com");
        user3.setTel(("07 06 04 51 44"));
        user3.setDispo(false);
        ArrayList<CompetenceModel> competences3 = new ArrayList<>();
        competences3.add(competence3);
        competences3.add(competence4);
        user3.setCompetence(competences3);
        ArrayList<ProjetModel> projetsInities3 = new ArrayList<>();
        projetsInities3.add(singletonData.getProjects().get(0));
        user3.setProjetInitie(new ArrayList<ProjetModel>());
        user3.setProjetEnCours(new ArrayList<>(projetsInities3));
        user3.setQuestionAsked(new ArrayList<QuestionModel>());
        user3.setQuestionNeedAnswer(new ArrayList<QuestionModel>());

        singletonData.addUsers(user1);
        singletonData.addUsers(user2);
        singletonData.addUsers(user3);

        boolean test = true;*/
        final SingletonData singletonData = SingletonData.getInstance();
        singletonData.initListenerPresence(new PresenceListener() {
            @Override
            public void onChange(UserModel user) {
                if(!singletonData.getcUser().getuId().equals(user.getuId()))
                Toast.makeText(MainActivity.this, user.getPrenom() + " connexion : " + user.isDispo(), Toast.LENGTH_LONG).show();
            }
        });

        singletonData.getANewQuestionListener(new QuestionReponseListener() {
            @Override
            public void onChange(QuestionModel question) {
                UserModel sender = singletonData.findUserById(question.getSenderId());
                Toast.makeText(MainActivity.this, sender.getPrenom() + " send you a new question !", Toast.LENGTH_LONG).show();
            }
        }, singletonData.getcUser());

        Button listProject = findViewById(R.id.bt_projet_list);
        Button createProject = findViewById(R.id.bt_form_projet);
        Button userPage = findViewById(R.id.bt_user_page);

        listProject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToListProject = new Intent(MainActivity.this, ProjectsListActivity.class);
                MainActivity.this.startActivity(goToListProject);
            }
        });

        createProject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToFormProject = new Intent(MainActivity.this, ProjetFormActivity.class);
                MainActivity.this.startActivity(goToFormProject);
            }
        });

        userPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToUserPage = new Intent(MainActivity.this, UserPage.class);
                MainActivity.this.startActivity(goToUserPage);
            }
        });

    }
}
