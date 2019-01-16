package fr.wildcodeschool.hackbus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class AnswerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer);
    }

    private void colorPriority(int seekBarProgress) {
        //TODO: à recup' via singleton
        ImageView progressColor = findViewById(R.id.iv_priority_color);

        if (seekBarProgress == 0) {
            progressColor.setBackgroundResource(R.drawable.ic_circle_grey);
        } else if (seekBarProgress == 1) {
            progressColor.setBackgroundResource(R.drawable.ic_circle_blue);
        } else if (seekBarProgress == 2) {
            progressColor.setBackgroundResource(R.drawable.ic_circle_green);
        } else if (seekBarProgress == 3) {
            progressColor.setBackgroundResource(R.drawable.ic_circle_yellow);
        } else if (seekBarProgress == 4) {
            progressColor.setBackgroundResource(R.drawable.ic_circle_orange);
        } else if (seekBarProgress == 5) {
            progressColor.setBackgroundResource(R.drawable.ic_circle_red);
        }
    }
}
