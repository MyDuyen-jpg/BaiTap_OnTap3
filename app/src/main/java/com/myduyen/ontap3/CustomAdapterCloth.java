package com.myduyen.ontap3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapterCloth extends RecyclerView.Adapter<CustomAdapterCloth.ViewHolder> {
     ArrayList<Cloth> mCloths;
     OnClickListener listener;

    public CustomAdapterCloth(ArrayList<Cloth> cloths, OnClickListener listener) {
        this.mCloths = cloths;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cloth_item,parent,false);
        return new ViewHolder(view);
    }


    @Override
    public int getItemCount() {
        return mCloths.size();
    }

    public void filterList(ArrayList<Cloth> cloths) {
        mCloths = cloths;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        Cloth mCloth;
        ImageView imgCloth;
        TextView tvName,tvPrice;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgCloth = itemView.findViewById(R.id.imgCloth);
            tvName = itemView.findViewById(R.id.tvName);
            tvPrice = itemView.findViewById(R.id.tvPrice);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.itemClick(mCloth);
                }
            });
        }
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Cloth cloth = mCloths.get(position);
        holder.mCloth = cloth;
        holder.imgCloth.setImageResource(cloth.getAnh());
        holder.tvName.setText(cloth.getName());
        holder.tvPrice.setText(cloth.getPrice()+"");

    }
}
