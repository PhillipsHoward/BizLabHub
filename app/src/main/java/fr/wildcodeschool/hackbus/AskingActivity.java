package fr.wildcodeschool.hackbus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import fr.wildcodeschool.hackbus.models.QuestionModel;

public class AskingActivity extends AppCompatActivity {

    private int mSeekBarProgress = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asking);

        seekBar();

        sendButton();
    }

    private void sendButton() {
        Button send = findViewById(R.id.send);
        final EditText title = findViewById(R.id.et_title_question);
        final EditText question = findViewById(R.id.et_question);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String titleText = title.getText().toString();
                String questionText = question.getText().toString();

                if (titleText.isEmpty() || questionText.isEmpty()) {
                    Toast.makeText(AskingActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                } else {
                    QuestionModel newQuestion = new QuestionModel(titleText, questionText, mSeekBarProgress);
                    //TODO: model question tout prêt à balancer quelque part
                }
            }
        });
    }

    private void seekBar() {
        SeekBar sbPriority = findViewById(R.id.sb_priority);
        final TextView tvCount = findViewById(R.id.tv_count);
        final ImageView progressColor = findViewById(R.id.iv_color_progress);

        sbPriority.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mSeekBarProgress = progress;
                tvCount.setText(mSeekBarProgress + " / " + seekBar.getMax());
                if (mSeekBarProgress == 0) {
                    progressColor.setBackgroundResource(R.drawable.ic_circle_grey);
                } else if (mSeekBarProgress == 1) {
                    progressColor.setBackgroundResource(R.drawable.ic_circle_blue);
                } else if (mSeekBarProgress == 2) {
                    progressColor.setBackgroundResource(R.drawable.ic_circle_green);
                } else if (mSeekBarProgress == 3) {
                    progressColor.setBackgroundResource(R.drawable.ic_circle_yellow);
                } else if (mSeekBarProgress == 4) {
                    progressColor.setBackgroundResource(R.drawable.ic_circle_orange);
                } else if (mSeekBarProgress == 5) {
                    progressColor.setBackgroundResource(R.drawable.ic_circle_red);
                }
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
    }
}
