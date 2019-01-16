package fr.wildcodeschool.hackbus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class UserForm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_form);

        //competence
        RecyclerView competenceList = findViewById(R.id.competenceList);
        LinearLayoutManager LayoutManager = new LinearLayoutManager(this);
        competenceList.setLayoutManager(LayoutManager);

        List<CompetenceModel> competences = new ArrayList<>();
        ProjetTeamAdapter adapter = new ProjetTeamAdapter(competences, this, new UserModel());
        competenceList.setAdapter(adapter);


    }
}
