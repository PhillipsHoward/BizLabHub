package fr.wildcodeschool.hackbus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        SingletonData singletonData = SingletonData.getInstance();
        singletonData.initDatas(new SingletonDataListener() {
            @Override
            public void onResponse(boolean success) {
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
            }
        });
    }
}
