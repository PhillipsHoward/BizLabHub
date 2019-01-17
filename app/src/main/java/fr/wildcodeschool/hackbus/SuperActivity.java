package fr.wildcodeschool.hackbus;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

public class SuperActivity extends AppCompatActivity {

    Switch mSwitchAB;
    private static String NOT_DISPO = "Not now, I'm busy";
    private static String DISPO = "Open office !";

    @Override
    protected void onStart() {
        changeStatus(true);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(ResourcesCompat.getColor(getResources(), R.color.red, null)));
        changeText(NOT_DISPO);
        super.onStart();
    }

    @Override
    protected void onStop() {
        changeStatus(false);
        super.onStop();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        mSwitchAB.setChecked(false);
        changeStatus(false);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_menu, menu);
        MenuItem item = menu.findItem(R.id.switchId);
        item.setActionView(R.layout.switch_layout);

        mSwitchAB = item
                .getActionView().findViewById(R.id.switchAB);
        mSwitchAB.setChecked(false);

        mSwitchAB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView,
                                         boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(getApplication(), "You're now ready to answer questions", Toast.LENGTH_SHORT)
                            .show();
                    getSupportActionBar().setBackgroundDrawable(new ColorDrawable(ResourcesCompat.getColor(getResources(), R.color.green, null)));
                    changeText(DISPO);
                    changeStatus(true);

                } else {
                    Toast.makeText(getApplication(), "You will not receive questions for now", Toast.LENGTH_SHORT)
                            .show();
                    getSupportActionBar().setBackgroundDrawable(new ColorDrawable(ResourcesCompat.getColor(getResources(), R.color.red, null)));
                    changeText(NOT_DISPO);
                    changeStatus(false);
                }
            }
        });
        return true;
    }

    protected void changeText(String title) {
        this.setTitle(title);
    }

    protected void changeStatus(boolean disponible) {
        SingletonData.getInstance().getcUser().setDispo(disponible);
        SingletonData.getInstance().updateUser(
                SingletonData.getInstance().getcUser()
        );
    }
}
