package fr.wildcodeschool.hackbus;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class ProjetTeamAdapter extends RecyclerView.Adapter<ProjetTeamAdapter.MyViewHolder> {

    private List<UserModel> userTeamList;
    private Context ctx;


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView nom;
        public TextView prenom;

        public MyViewHolder(View view) {
            super(view);
            nom = view.findViewById(R.id.tv_nom);
            prenom = view.findViewById(R.id.tv_prenom);
        }
    }


    public ProjetTeamAdapter(List<UserModel> userTeamList, Context ctx) {
        this.userTeamList = userTeamList;
        this.ctx = ctx;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_projet_team, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        final UserModel userTeam = userTeamList.get(position);
        holder.nom.setText(userTeam.getNom());
        holder.prenom.setText(userTeam.getPrenom());
    }

    @Override
    public int getItemCount() {
        return userTeamList.size();
    }
}