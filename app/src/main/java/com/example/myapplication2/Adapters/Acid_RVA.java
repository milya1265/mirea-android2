package com.example.myapplication2.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication2.R;
import com.example.myapplication2.databinding.RecyclerAcidRawBinding;
import com.example.myapplication2.models.AcidModel;

import java.util.ArrayList;

public class Acid_RVA extends RecyclerView.Adapter<Acid_RVA.MyViewHolder> {
    ArrayList<AcidModel> acidModels;
    public Acid_RVA( ArrayList<AcidModel> acidModels) {
        this.acidModels = acidModels;
    }
    @NonNull
    @Override
    public Acid_RVA.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerAcidRawBinding binding = RecyclerAcidRawBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new Acid_RVA.MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull Acid_RVA.MyViewHolder holder, int position) {
        holder.bindItem(position);
//        holder.Name.setText(acidModels.get(position).getName());
//        holder.ShortName.setText(acidModels.get(position).getShortName());
//        holder.imageView.setImageResource(acidModels.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return acidModels.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        RecyclerAcidRawBinding binding;
        public MyViewHolder(@NonNull RecyclerAcidRawBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }

        public void bindItem(int position) {
            binding.fullName.setText(acidModels.get(position).getName());
            binding.shortName.setText(acidModels.get(position).getShortName());
            binding.acidImage.setImageResource(acidModels.get(position).getImage());
        }
    }
}
