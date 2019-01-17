package fr.wildcodeschool.hackbus;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import fr.wildcodeschool.hackbus.models.UserModel;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        final SingletonData singletonData = SingletonData.getInstance();
        singletonData.initDatas(new SingletonDataListener() {
            @Override
            public void onResponse(boolean success) {
                for(UserModel userModel : singletonData.getUsers()){
                    if(userModel.getuId().equals(SingletonData.getUidPerso())){
                        singletonData.setcUser(userModel);
                    }
                }
                singletonData.getcUser().setDispo(true);
                singletonData.updateUser(singletonData.getcUser());
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
            }
        });
    }


}
