package fr.wildcodeschool.hackbus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import fr.wildcodeschool.hackbus.models.QuestionModel;

public class QuestionActivity extends AppCompatActivity {

    private Singleton mSingleton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        mSingleton = Singleton.getInstance();

        //TODO: appeler setDataQuestion & setButtons quand BDD recup'

        infoButton();
    }

    private void infoButton() {
        ImageButton info = findViewById(R.id.ib_info);
        final View greyView = findViewById(R.id.view_grey);
        final TextView priorityMeaning = findViewById(R.id.tv_meaning_priority);

        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showInfoPopup();
            }
        });

        greyView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                closeInfoPopup();
            }
        });

        priorityMeaning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                closeInfoPopup();

            }
        });
    }

    private void closeInfoPopup() {
        View greyView = findViewById(R.id.view_grey);
        TextView priorityPopup = findViewById(R.id.tv_priority_popup);
        TextView priorityMeaning = findViewById(R.id.tv_meaning_priority);

        greyView.setVisibility(View.GONE);
        priorityPopup.setVisibility(View.GONE);
        priorityMeaning.setVisibility(View.GONE);
    }

    private void showInfoPopup() {
        View greyView = findViewById(R.id.view_grey);
        TextView priorityPopup = findViewById(R.id.tv_priority_popup);
        TextView priorityMeaning = findViewById(R.id.tv_meaning_priority);

        greyView.setVisibility(View.VISIBLE);
        priorityPopup.setVisibility(View.VISIBLE);
        priorityMeaning.setVisibility(View.VISIBLE);
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
                ArrayList<QuestionModel> questionList = mSingleton.getUser().getQuestionNeedAnswer();
                for(int i = 0; i < questionList.size(); i ++) {
                    if(questionList.get(i).getId() == currentQuestion.getId()) {
                        questionList.remove(i);
                    }
                }
                mSingleton.getUser().setQuestionNeedAnswer(questionList);
                //TODO: à vérifier OU tester celle commentee
               // mSingleton.getUser().getQuestionNeedAnswer().remove(currentQuestion);
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
