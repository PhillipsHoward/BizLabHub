package fr.wildcodeschool.hackbus.adapters;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;
import fr.wildcodeschool.hackbus.R;

import fr.wildcodeschool.hackbus.models.ProjetModel;
public class ProjectsListAdapter extends RecyclerView.Adapter<ProjectsListAdapter.ViewHolder> {
    private ArrayList<ProjetModel> mProjects = new ArrayList<>();
    public ProjectsListAdapter(ArrayList<ProjetModel> projects) {
        mProjects = projects;
    }
    @Override
    public ProjectsListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_project, parent, false);
        return new ViewHolder(itemView);
    }
    @Override
    public void onBindViewHolder(ProjectsListAdapter.ViewHolder holder, int position) {
        ProjetModel projetModel = mProjects.get(position);
        holder.tvTitle.setText(projetModel.getNom());
        holder.tvNameOrganiser.setText(projetModel.getInitiateur().getNom());
        holder.tvNbParticipants.setText(String.valueOf(projetModel.getTeam().size()));
    }
    @Override
    public int getItemCount() {
        return mProjects.size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle, tvNameOrganiser, tvNbParticipants;
        public ViewHolder(View v) {
            super(v);
            this.tvTitle = v.findViewById(R.id.tv_title_project);
            this.tvNameOrganiser = v.findViewById(R.id.tv_organisator_name);
            this.tvNbParticipants = v.findViewById(R.id.tv_nb_participants);
        }
    }
}