package fr.wildcodeschool.hackbus;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import fr.wildcodeschool.hackbus.adapters.QuestionsListAdapter;
import fr.wildcodeschool.hackbus.models.QuestionModel;

public class QuestionsListActivity extends AppCompatActivity {

    Context mContext = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions_list);

        setAdapter();
    }

    private void setAdapter() {
        final ArrayList<QuestionModel> questionModel = new ArrayList<>();
        final View greyView = findViewById(R.id.view_grey);
        final Button tenMinutes = findViewById(R.id.b_ten_mn);
        final Button aDay = findViewById(R.id.b_a_day);
        final Button dontKnow = findViewById(R.id.b_dont_know);

        questionModel.add(new QuestionModel("blibli", "hello", 3));
        //TODO: à dégager avec appelle BDD

        final QuestionsListAdapter adapterQuestionModel = new QuestionsListAdapter(questionModel, mContext, new QuestionsListAdapter.QuestionListener() {
            @Override
            public void onTouch(QuestionModel question) {
                openPopup();

                tenMinutes.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // TODO: envoyer réponse auto "I will answer you in 10mn"
                        closePopup();
                    }
                });

                aDay.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // TODO: envoyer réponse auto "I will answer by the end of the day"
                        closePopup();
                    }
                });

                dontKnow.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // TODO: envoyer réponse auto "I don't know"
                        closePopup();
                    }
                });

                greyView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        closePopup();
                    }
                });
            }
        });

        RecyclerView QuestionsRecyclerView = findViewById(R.id.rv_questions);

        QuestionsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        QuestionsRecyclerView.setAdapter(adapterQuestionModel);
    }

    private void openPopup() {
        View greyView = findViewById(R.id.view_grey);
        TextView quickyPopup = findViewById(R.id.tv_quicky);
        Button tenMinutes = findViewById(R.id.b_ten_mn);
        Button aDay = findViewById(R.id.b_a_day);
        Button dontKnow = findViewById(R.id.b_dont_know);

        greyView.setVisibility(View.VISIBLE);
        quickyPopup.setVisibility(View.VISIBLE);
        tenMinutes.setVisibility(View.VISIBLE);
        aDay.setVisibility(View.VISIBLE);
        dontKnow.setVisibility(View.VISIBLE);
    }

    private void closePopup() {
        View greyView = findViewById(R.id.view_grey);
        TextView quickyPopup = findViewById(R.id.tv_quicky);
        Button tenMinutes = findViewById(R.id.b_ten_mn);
        Button aDay = findViewById(R.id.b_a_day);
        Button dontKnow = findViewById(R.id.b_dont_know);

        greyView.setVisibility(View.GONE);
        quickyPopup.setVisibility(View.GONE);
        tenMinutes.setVisibility(View.GONE);
        aDay.setVisibility(View.GONE);
        dontKnow.setVisibility(View.GONE);
    }
}
