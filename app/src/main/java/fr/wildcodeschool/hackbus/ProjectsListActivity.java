package fr.wildcodeschool.hackbus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import java.util.ArrayList;

import fr.wildcodeschool.hackbus.models.ProjetModel;

public class ProjectsListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_projects_list);
        final RecyclerView listProjects = findViewById(R.id.recyclerview_projects);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        listProjects.setLayoutManager(layoutManager);

        final ArrayList<ProjetModel> projectsModels = new ArrayList<>(); // TODO remplaçer user Singleton
        ProjectsListAdapter adapter = new ProjectsListAdapter(projectsModels);
        listProjects.setAdapter(adapter);
    }
}