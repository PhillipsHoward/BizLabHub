package fr.wildcodeschool.hackbus;

import android.content.Context;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import fr.wildcodeschool.hackbus.models.UserModel;

public class SuperActivity extends AppCompatActivity {



    @Override
    protected void onStart() {

        SingletonData.getInstance().getcUser().setDispo(true);
        SingletonData.getInstance().updateUser(
                SingletonData.getInstance().getcUser()
        );
        super.onStart();
    }


    @Override
    protected void onStop() {
        SingletonData.getInstance().getcUser().setDispo(false);
        SingletonData.getInstance().updateUser(
                SingletonData.getInstance().getcUser()
        );
        super.onStop();
    }


}
