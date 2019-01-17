package fr.wildcodeschool.hackbus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import fr.wildcodeschool.hackbus.models.QuestionModel;

public class QuestionActivity extends AppCompatActivity {

    private Singleton mSingleton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        mSingleton = Singleton.getInstance();

        //TODO: appeler setDataQuestion & setButtons quand BDD recup'
    }

    private void setButtons() {
        Button answer = findViewById(R.id.b_i_ansawer);
        Button noTime = findViewById(R.id.b_no_time);
        final QuestionModel currentQuestion = mSingleton.getCurrentQuestion();

        answer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO: à balancer vers page de réponse
            }
        });

        noTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSingleton.getUser().getQuestionNeedAnswer().remove(currentQuestion);
                //TODO: à vérifier
            }
        });
    }

    private void setDataQuestion() {
        TextView title = findViewById(R.id.tv_question_title);
        TextView question = findViewById(R.id.tv_question);

        QuestionModel currentQuestion = mSingleton.getCurrentQuestion();

        title.setText(currentQuestion.getTitle());
        question.setText(currentQuestion.getQuestion());

        colorPriority(currentQuestion.getPriority());
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
