package fr.wildcodeschool.hackbus;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

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


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        MenuItem item = (MenuItem) menu.findItem(R.id.switchId);
        item.setActionView(R.layout.switch_layout);
        Switch switchAB = item
                .getActionView().findViewById(R.id.switchAB);
        switchAB.setChecked(false);

        switchAB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView,
                                         boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(getApplication(), "ON", Toast.LENGTH_SHORT)
                            .show();
                } else {
                    Toast.makeText(getApplication(), "OFF", Toast.LENGTH_SHORT)
                            .show();
                }
            }
        });
        return true;
    }
}
