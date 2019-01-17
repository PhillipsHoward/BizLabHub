package fr.wildcodeschool.hackbus;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import fr.wildcodeschool.hackbus.models.ProjetModel;
import fr.wildcodeschool.hackbus.models.UserModel;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {
    private ArrayList<UserModel> mUsers = new ArrayList<>();

    public UserAdapter(ArrayList<UserModel> users) {
        mUsers = users;
    }

    @Override
    public UserAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_users_dispo, parent, false);
        return new UserAdapter.ViewHolder(itemView);
    }
    @Override
    public void onBindViewHolder(UserAdapter.ViewHolder holder, int position) {
        UserModel userModel = mUsers.get(position);
        holder.tvPresence.setText(String.valueOf(mUsers.get(position).isDispo()));
        holder.tvName.setText(mUsers.get(position).getNom() + " " +mUsers.get(position).getPrenom());
    }
    @Override
    public int getItemCount() {
        return mUsers.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvPresence;

        public ViewHolder(View v) {
            super(v);
            this.tvName = v.findViewById(R.id.nom_text);
            this.tvPresence = v.findViewById(R.id.presence_text);
        }
    }
}