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
import fr.wildcodeschool.hackbus.Singleton;
import fr.wildcodeschool.hackbus.models.CompetenceModel;
import fr.wildcodeschool.hackbus.models.ProjetModel;
import fr.wildcodeschool.hackbus.models.TagsModel;
import fr.wildcodeschool.hackbus.models.UserModel;

public class CompetenceProjetAdapter extends RecyclerView.Adapter<CompetenceProjetAdapter.MyViewHolder> {

    private List<CompetenceModel> competenceList;
    private Context ctx;
    private ProjetModel newProject = Singleton.getInstance().getNewProject();

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView nom;
        public CardView cardview;

        public MyViewHolder(View view) {
            super(view);
            nom = view.findViewById(R.id.tv_tag_competenceproj);
            cardview = view.findViewById(R.id.cardview_competencesproj);
        }
    }


    public CompetenceProjetAdapter(List<CompetenceModel> competenceList, Context ctx, ProjetModel newProject) {
        this.competenceList = competenceList;
        this.ctx = ctx;
        this.newProject = newProject;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_competence_projet, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        final CompetenceModel competence = competenceList.get(position);
        final TagsModel tag = competence.getTag();
        holder.nom.setText(tag.getNom());

        holder.cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newProject.getCompetence().add(tag);
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