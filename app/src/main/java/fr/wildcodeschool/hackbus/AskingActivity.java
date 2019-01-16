package fr.wildcodeschool.hackbus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

public class AskingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asking);

        seekBar();
    }

    private void seekBar() {
        SeekBar sbPriority = findViewById(R.id.sb_priority);
        final TextView tvCount = findViewById(R.id.tv_count);
        final ImageView progressColor = findViewById(R.id.iv_color_progress);

        sbPriority.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int seekBarProgress = 0;

            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekBarProgress = progress;

            }

            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                tvCount.setText(seekBarProgress + " / " + seekBar.getMax());
                //TODO: à envoyer dans singleton seekBarProgress
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
        });
    }
}
