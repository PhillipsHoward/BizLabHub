package fr.wildcodeschool.hackbus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import fr.wildcodeschool.hackbus.models.CompetenceModel;
import fr.wildcodeschool.hackbus.models.UserModel;

public class UserPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_page);

        RecyclerView competenceList = findViewById(R.id.competenceUserList);
        LinearLayoutManager LayoutManager = new LinearLayoutManager(this);
        competenceList.setLayoutManager(LayoutManager);

        List<CompetenceModel> competences = new ArrayList<>();
        CompetenceAdapter adapter = new CompetenceAdapter(competences, this, new UserModel());
        competenceList.setAdapter(adapter);

        RecyclerView projetTeamList = findViewById(R.id.projetTeamList);
        LinearLayoutManager LayoutManager2 = new LinearLayoutManager(this);
        projetTeamList.setLayoutManager(LayoutManager2);

        List<UserModel> userTeam = new ArrayList<>();
        ProjetTeamAdapter adapter2 = new ProjetTeamAdapter(userTeam, this);
        competenceList.setAdapter(adapter2);

    }
}
