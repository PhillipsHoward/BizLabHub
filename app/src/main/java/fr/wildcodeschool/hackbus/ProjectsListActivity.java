package fr.wildcodeschool.hackbus;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;

import fr.wildcodeschool.hackbus.adapters.ProjectsListAdapter;
import fr.wildcodeschool.hackbus.models.ProjetModel;
import fr.wildcodeschool.hackbus.models.QuestionModel;
import fr.wildcodeschool.hackbus.models.UserModel;

public class ProjectsListActivity extends SuperActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_projects_list);
        final RecyclerView listProjects = findViewById(R.id.recyclerview_projects);

        final SingletonData singletonData = SingletonData.getInstance();
        singletonData.initListenerPresence(new PresenceListener() {
            @Override
            public void onChange(UserModel user) {
                if(!singletonData.getcUser().getuId().equals(user.getuId())) {
                    if(user.isDispo()) Toast.makeText(ProjectsListActivity.this, user.getPrenom() + " is connected !", Toast.LENGTH_LONG).show();
                    else Toast.makeText(ProjectsListActivity.this, user.getPrenom() + " disconnected !", Toast.LENGTH_LONG).show();
                }
            }
        });

        singletonData.getANewQuestionListener(new QuestionReponseListener() {
            @Override
            public void onChange(QuestionModel question) {
                UserModel sender = singletonData.findUserById(question.getSenderId());
                Toast.makeText(ProjectsListActivity.this, sender.getPrenom() + " send you a new question : " + question.getTitle(), Toast.LENGTH_LONG).show();
            }
        }, singletonData.getcUser());

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        listProjects.setLayoutManager(layoutManager);

        final ArrayList<ProjetModel> projectsModels = new ArrayList<>(); // TODO remplaçer user Singleton
        ProjectsListAdapter adapter = new ProjectsListAdapter(projectsModels);
        listProjects.setAdapter(adapter);

        profilButton();

        newProjectButton();
    }

    private void newProjectButton() {
        Button newProject = findViewById(R.id.b_create_new);

        newProject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProjectsListActivity.this, ProjetFormActivity.class));
            }
        });
    }

    private void profilButton() {

        ImageButton profilButton = findViewById(R.id.b_profil);

        profilButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProjectsListActivity.this, UserPage.class));
            }
        });
    }

}