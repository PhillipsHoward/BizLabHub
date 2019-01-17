package fr.wildcodeschool.hackbus;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import fr.wildcodeschool.hackbus.models.ProjetModel;
import fr.wildcodeschool.hackbus.models.UserModel;

public class ProjetInitAdapter extends RecyclerView.Adapter<ProjetInitAdapter.MyViewHolder> {

    private List<ProjetModel> projetInitList;
    private Context ctx;


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView nom;

        public MyViewHolder(View view) {
            super(view);
            nom = view.findViewById(R.id.tv_nom_init);
        }
    }


    public ProjetInitAdapter(List<ProjetModel> projetInitList, Context ctx) {
        this.projetInitList = projetInitList;
        this.ctx = ctx;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_projet_init_user, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        final ProjetModel projetInit = projetInitList.get(position);
        holder.nom.setText(projetInit.getNom());
    }

    @Override
    public int getItemCount() {
        return projetInitList.size();
    }
}