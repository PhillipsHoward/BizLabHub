package fr.wildcodeschool.hackbus.adapters;


import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import fr.wildcodeschool.hackbus.R;
import fr.wildcodeschool.hackbus.models.CompetenceModel;
import fr.wildcodeschool.hackbus.models.UserModel;

public class CompetenceAdapter extends RecyclerView.Adapter<CompetenceAdapter.MyViewHolder> {

    private List<CompetenceModel> competenceList;
    private Context ctx;
    private UserModel cUser;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView nom;
        public CardView cardview;

        public MyViewHolder(View view) {
            super(view);
            nom = view.findViewById(R.id.tv_tag_competence);
            cardview = view.findViewById(R.id.cardview_competences);
        }
    }


    public CompetenceAdapter(List<CompetenceModel> competenceList, Context ctx, UserModel cUser) {
        this.competenceList = competenceList;
        this.ctx = ctx;
        this.cUser = cUser;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_competence, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        final CompetenceModel competence = competenceList.get(position);
        holder.nom.setText(competence.getTag().getNom());

        holder.cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cUser.getCompetence().add(competence);
                holder.cardview.setBackgroundResource(R.color.colorPrimaryDark);
            }
        });
    }

    @Override
    public int getItemCount() {
        return competenceList.size();
    }

    public void onClick(View v) {

    }

}