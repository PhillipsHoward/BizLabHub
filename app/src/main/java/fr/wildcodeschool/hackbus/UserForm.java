package fr.wildcodeschool.hackbus;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import fr.wildcodeschool.hackbus.adapters.CompetenceAdapter;
import fr.wildcodeschool.hackbus.models.CompetenceModel;
import fr.wildcodeschool.hackbus.models.UserModel;

public class UserForm extends SuperActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_form);

        //competence
        RecyclerView competenceList = findViewById(R.id.competenceList);
        LinearLayoutManager LayoutManager = new LinearLayoutManager(this);
        competenceList.setLayoutManager(LayoutManager);

        List<CompetenceModel> competences = new ArrayList<>();
        CompetenceAdapter adapter = new CompetenceAdapter(competences, this, new UserModel());
        competenceList.setAdapter(adapter);


    }
}
