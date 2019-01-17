package fr.wildcodeschool.hackbus;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import fr.wildcodeschool.hackbus.models.TagsModel;

public class AskingGringAdapter extends RecyclerView.Adapter<AskingGringAdapter.ViewHolder> {
    private ArrayList<TagsModel> mTag;
    private Context mContext;

    public AskingGringAdapter(Context mContext, ArrayList<TagsModel> mTag) {
        this.mContext = mContext;
        this.mTag = mTag;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view;
        LayoutInflater mInflater = LayoutInflater.from(viewGroup.getContext());
        view = mInflater.inflate(R.layout.item_skill, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {

        viewHolder.tagssss.setText(mTag.get(position).getNom());

    }

    @Override
    public int getItemCount() {
        return mTag.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tagssss;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tagssss = itemView.findViewById(R.id.textView);
        }
    }
}

