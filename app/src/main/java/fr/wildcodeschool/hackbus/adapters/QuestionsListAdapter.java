package fr.wildcodeschool.hackbus.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import fr.wildcodeschool.hackbus.QuestionActivity;
import fr.wildcodeschool.hackbus.R;
import fr.wildcodeschool.hackbus.models.QuestionModel;

public class QuestionsListAdapter extends RecyclerView.Adapter<QuestionsListAdapter.MyViewHolder> {

    private List<QuestionModel> questionsList;
    private Context ctx;
    private QuestionListener listener;

    public QuestionsListAdapter(List<QuestionModel> questionsList, Context ctx, QuestionListener listener) {
        this.questionsList = questionsList;
        this.ctx = ctx;
        this.listener = listener;
    }

    @Override
    public QuestionsListAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_question, parent, false);

        return new QuestionsListAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final QuestionsListAdapter.MyViewHolder holder, int position) {
        final QuestionModel question = questionsList.get(position);

        holder.title.setText(question.getTitle());
        holder.questionText.setText(question.getQuestion());

        int seekBarProgress = question.getPriority();

        if(question.isOpen()) {
            if (seekBarProgress == 0) {
                holder.priority.setBackgroundResource(R.drawable.ic_circle_grey);
            } else if (seekBarProgress == 1) {
                holder.priority.setBackgroundResource(R.drawable.ic_circle_blue);
            } else if (seekBarProgress == 2) {
                holder.priority.setBackgroundResource(R.drawable.ic_circle_green);
            } else if (seekBarProgress == 3) {
                holder.priority.setBackgroundResource(R.drawable.ic_circle_yellow);
            } else if (seekBarProgress == 4) {
                holder.priority.setBackgroundResource(R.drawable.ic_circle_orange);
            } else if (seekBarProgress == 5) {
                holder.priority.setBackgroundResource(R.drawable.ic_circle_red);
            }
        } else {
            holder.priority.setVisibility(View.GONE);
            holder.close.setVisibility(View.VISIBLE);
        }

        holder.answerNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ctx.startActivity(new Intent(ctx, QuestionActivity.class));
            }
        });

        holder.answerQuick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onTouch(question);
            }
        });
    }

    public interface QuestionListener {
        void onTouch(QuestionModel question);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public TextView questionText;
        public ImageView priority;
        public TextView close;
        public TextView answerNow;
        public TextView answerQuick;

        public MyViewHolder(View view) {
            super(view);
            title = view.findViewById(R.id.tv_question_title);
            questionText = view.findViewById(R.id.tv_question);
            priority = view.findViewById(R.id.iv_priority_color);
            close = view.findViewById(R.id.tv_close);
            answerNow = view.findViewById(R.id.tv_answer_now);
            answerQuick = view.findViewById(R.id.tv_quick_answer);
        }
    }

    @Override
    public int getItemCount() {
        return questionsList.size();
    }
}
