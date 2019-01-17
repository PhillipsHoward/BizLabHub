package fr.wildcodeschool.hackbus;

import android.os.Bundle;
import android.widget.Toast;

import fr.wildcodeschool.hackbus.models.UserModel;

public class MainActivity extends SuperActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SingletonData singletonData = SingletonData.getInstance();
        singletonData.initListenerPresence(new PresenceListener() {
            @Override
            public void onChange(UserModel user) {
                Toast.makeText(MainActivity.this, user.getPrenom() + " connexion : " + user.isDispo(), Toast.LENGTH_LONG).show();
            }
        });

    }
}
