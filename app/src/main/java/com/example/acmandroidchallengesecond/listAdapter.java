package com.example.acmandroidchallengesecond;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class listAdapter extends RecyclerView.Adapter<listAdapter.viewHolder>{
  private ArrayList<item> info;
    Context context;

    public listAdapter(Context context,int resource , ArrayList<item> info) {
        this.info=info;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,parent,false);
        viewHolder holder=new viewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        holder.name.setText(info.get(position).getNam());
        holder.add.setText(info.get(position).getAddr());
        holder.clg.setText(info.get(position).getClg());
    }

    @Override
    public int getItemCount() {
        return info.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder{
        TextView name,clg,add;
        ConstraintLayout parent_layout;
        public viewHolder(@NonNull View itemView) {

            super(itemView);
            name=itemView.findViewById(R.id.name);
            clg=itemView.findViewById(R.id.clge);
            add=itemView.findViewById(R.id.addr);
            parent_layout.findViewById(R.id.parent);

        }
    }
}
