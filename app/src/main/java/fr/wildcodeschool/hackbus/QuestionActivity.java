package fr.wildcodeschool.hackbus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import fr.wildcodeschool.hackbus.models.QuestionModel;
import fr.wildcodeschool.hackbus.models.ReponseModel;
import fr.wildcodeschool.hackbus.models.UserModel;

public class QuestionActivity extends AppCompatActivity {

    private Singleton mSingleton;
    private SingletonData mDataSingleton;
    private QuestionModel mCurrentQuestion;
    private Boolean isCreator = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        mSingleton = Singleton.getInstance();
        mDataSingleton = SingletonData.getInstance();

        //mCurrentQuestion = mSingleton.getCurrentQuestion();

        /*TODO: à décommenter quand BDD sera OK
        if(mCurrentQuestion.getSender().getuId() == mSingleton.getUser().getuId()) {
            isCreator = true;
        }*/

        //TODO: appeler getDataQuestion & setButtons quand BDD recup'

        //TODO: créer Adapter et l'appeler avec ITEM_QUESTION
    }


    private void setButtons() {
        Button answerButton = findViewById(R.id.send);
        TextView openOrClose = findViewById(R.id.tv_open_close);
        TextView closeOpenConfirmation = findViewById(R.id.tv_quicky);

        final EditText answer = findViewById(R.id.et_answer);

        answerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String answerText = answer.getText().toString();

                if(answerText.isEmpty()){
                    Toast.makeText(QuestionActivity.this, "Please write your answerNow", Toast.LENGTH_SHORT).show();
                } else {
                    ReponseModel newReponse = new ReponseModel(answerText, mDataSingleton.getcUser());
                    //TODO: à balancer vers la BDD
                }
            }
        });

        if(isCreator && mCurrentQuestion.isOpen()) {
            openOrClose.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showInfoPopup();
                }
            });

            closeOpenConfirmation.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mCurrentQuestion.setOpen(false);
                    closeInfoPopup();
                }
            });

        }
    }

    private void closeInfoPopup() {
        View greyView = findViewById(R.id.view_grey);
        TextView closeOpenPopup = findViewById(R.id.tv_close_open_popup);
        TextView closeOpenConfirmation = findViewById(R.id.tv_quicky);

        greyView.setVisibility(View.GONE);
        closeOpenPopup.setVisibility(View.GONE);
        closeOpenConfirmation.setVisibility(View.GONE);
    }

    private void showInfoPopup() {
        View greyView = findViewById(R.id.view_grey);
        TextView closeOpenPopup = findViewById(R.id.tv_close_open_popup);
        TextView closeOpenConfirmation = findViewById(R.id.tv_quicky);

        greyView.setVisibility(View.VISIBLE);
        closeOpenPopup.setVisibility(View.VISIBLE);
        closeOpenConfirmation.setVisibility(View.VISIBLE);
    }

    private void getDataQuestion() {

        TextView title = findViewById(R.id.tv_question_title);
        TextView question = findViewById(R.id.tv_question);
        TextView userNameQuestion = findViewById(R.id.tv_user_question);
        TextView openOrClose = findViewById(R.id.tv_open_close);
        UserModel sender = mDataSingleton.findUserById(mCurrentQuestion.getSenderId());
        String nameAndFirstLastnameLetter = sender.getPrenom() + " " + sender.getNom().charAt(0);

        title.setText(mCurrentQuestion.getTitle());
        question.setText(mCurrentQuestion.getQuestion());
        userNameQuestion.setText(nameAndFirstLastnameLetter);
        userNameQuestion.setText("RB");

        if(!mCurrentQuestion.isOpen()) {
            openOrClose.setText("CLOSE");
            openOrClose.setTextColor(getResources().getColor(R.color.red));
        } else {
            openOrClose.setText("OPEN");
            openOrClose.setTextColor(getResources().getColor(R.color.green));
        }

        colorPriority(mCurrentQuestion.getPriority());
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
