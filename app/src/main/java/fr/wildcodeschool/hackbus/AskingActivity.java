package fr.wildcodeschool.hackbus;

import android.annotation.TargetApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class AskingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asking);

        seekBar();
    }

    @TargetApi(21)
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

                if (seekBarProgress == 0) {
                    progressColor.setColorFilter(R.color.grey);
                } else if (seekBarProgress == 1) {
                    progressColor.setColorFilter(R.color.blue);
                } else if (seekBarProgress == 2) {
                    progressColor.setColorFilter(R.color.green);
                } else if (seekBarProgress == 3) {
                    progressColor.setColorFilter(R.color.yellow);
                } else if (seekBarProgress == 4) {
                    progressColor.setColorFilter(R.color.orange);
                } else if (seekBarProgress == 5) {
                    progressColor.setColorFilter(R.color.red);
                }
            }

        });
    }
}
