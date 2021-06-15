package com.example.recyclerviewexample;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class NameAdapter extends RecyclerView.Adapter<NameAdapter.ViewHolder> {
    Context mContext;
    List<Name> nm;

    public NameAdapter(Context mContext, List<Name> nm) {
        this.mContext = mContext;
        this.nm = nm;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View cv= LayoutInflater.from(parent.getContext()).inflate(R.layout.customdesign,parent,false);
        return new ViewHolder(cv);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Name name=nm.get(position);
        holder.nameView.setText(name.getName());
        holder.emailView.setText(name.getEmail());
        holder.phoneView.setText(name.getPhone());

        holder.nameView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext,"You clicked on: "+holder.nameView.getText(),Toast.LENGTH_LONG).show();
            }
        });

        holder.emailView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_EMAIL,new String[]{(String) holder.emailView.getText()});
                intent.setType("message/rfc822");
                mContext.startActivity(Intent.createChooser(intent,"Choose client"));
                Toast.makeText(mContext,"You clicked on: "+holder.emailView.getText(),Toast.LENGTH_LONG).show();
            }
        });

        holder.phoneView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent calling=new Intent(Intent.ACTION_CALL);
                calling.setData(Uri.parse("tel:"+holder.phoneView.getText()));
                mContext.startActivity(calling);

                Toast.makeText(mContext,"You clicked on: "+holder.phoneView.getText(),Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return listSize();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView nameView,emailView,phoneView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameView=itemView.findViewById(R.id.namedesign);
            emailView=itemView.findViewById(R.id.designemail);
            phoneView=itemView.findViewById(R.id.designphone);
        }
    }
    int listSize(){
        return nm.size();
    }
}