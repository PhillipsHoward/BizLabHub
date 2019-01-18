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

import fr.wildcodeschool.hackbus.models.UserModel;

public class MainActivity extends SuperActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SingletonData singletonData = SingletonData.getInstance();
        singletonData.initListenerPresence(new PresenceListener() {
            @Override
            public void onChange(UserModel user) {
                if(!singletonData.getcUser().getuId().equals(user.getuId()))
                Toast.makeText(MainActivity.this, user.getPrenom() + " connexion : " + user.isDispo(), Toast.LENGTH_LONG).show();
            }
        });

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
