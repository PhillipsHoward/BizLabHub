package fr.wildcodeschool.hackbus;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import fr.wildcodeschool.hackbus.adapters.AskingGringAdapter;
import fr.wildcodeschool.hackbus.adapters.QuestionsListAdapter;
import fr.wildcodeschool.hackbus.models.QuestionModel;
import fr.wildcodeschool.hackbus.models.TagsModel;

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

        //questionModel.add(new QuestionModel("blibli", "hello", 3));
        //TODO: à dégager avec appelle BDD

        final QuestionsListAdapter adapterQuestionModel = new QuestionsListAdapter(questionModel, mContext);

        RecyclerView QuestionsRecyclerView = findViewById(R.id.rv_questions);

        QuestionsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        QuestionsRecyclerView.setAdapter(adapterQuestionModel);
    }
}
