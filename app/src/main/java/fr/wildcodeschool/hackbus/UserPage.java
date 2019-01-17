package fr.wildcodeschool.hackbus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import fr.wildcodeschool.hackbus.models.CompetenceModel;
import fr.wildcodeschool.hackbus.models.ProjetModel;
import fr.wildcodeschool.hackbus.models.TagsModel;
import fr.wildcodeschool.hackbus.models.UserModel;

public class UserPage extends SuperActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_page);

        //competence
        RecyclerView competenceList = findViewById(R.id.competenceUserList);
        LinearLayoutManager LayoutManager = new LinearLayoutManager(this);
        competenceList.setLayoutManager(LayoutManager);

        List<CompetenceModel> competences = new ArrayList<>();
        for (CompetenceModel competence : SingletonData.getInstance().getcUser().getCompetence()) {
            for (TagsModel tag : SingletonData.getInstance().getTags())
            if (tag.getuId().equals(competence.getTag().getuId())) {
                competences.add(competence);
            }
        }
        CompetenceUserPageAdapter adapter = new CompetenceUserPageAdapter(competences, this, new UserModel());
        competenceList.setAdapter(adapter);

        //projet team
        RecyclerView projetTeamList = findViewById(R.id.projetTeamList);
        LinearLayoutManager LayoutManager2 = new LinearLayoutManager(this);
        projetTeamList.setLayoutManager(LayoutManager2);

        List<ProjetModel> projetTeam = new ArrayList<>();
        for (ProjetModel projet : SingletonData.getInstance().getProjects()) {
            for(UserModel user : projet.getTeam()) {
                if(user.getuId().equals(SingletonData.getInstance().getcUser().getuId())){
                    projetTeam.add(projet);
                }
            }
        }
        ProjetTeamAdapter adapter2 = new ProjetTeamAdapter(projetTeam, this);
        competenceList.setAdapter(adapter2);

        //projet init
        RecyclerView projetInitList = findViewById(R.id.myProjetList);
        LinearLayoutManager LayoutManager3 = new LinearLayoutManager(this);
        projetInitList.setLayoutManager(LayoutManager3);

        List<ProjetModel> projetInit = new ArrayList<>();
        for (ProjetModel projet : SingletonData.getInstance().getProjects()) {
            if (projet.getInitiateur().getuId() == SingletonData.getInstance().getcUser().getuId()) {
                projetInit.add(projet);
            }
        }
        ProjetInitAdapter adapter3 = new ProjetInitAdapter(projetInit, this);
        competenceList.setAdapter(adapter3);

    }
}
