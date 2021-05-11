package com.myduyen.ontap3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapterBaggggg extends RecyclerView.Adapter<CustomAdapterBaggggg.ViewHolder> {
    private ArrayList<Cloth> mCloths;
    private OnClickListener listener;

    public CustomAdapterBaggggg(ArrayList<Cloth> cloths,OnClickListener listener) {
        this.mCloths = cloths;
        this.listener= listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.bag_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return mCloths.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgCloth_bag;
        int position;
        TextView tvName_bag,tvPrice_bag,tvSize_bag,tvSo_bag;
        ImageButton imgbtn_plusBag,imgbtn_minusBag;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgCloth_bag = itemView.findViewById(R.id.imgCLoth_bag);
            tvName_bag = itemView.findViewById(R.id.tvName_bag);
            tvPrice_bag = itemView.findViewById(R.id.tvPrice_bag);
            tvSize_bag = itemView.findViewById(R.id.tvSize_bag);
            tvSo_bag = itemView.findViewById(R.id.tvSo_bag);
            imgbtn_plusBag = itemView.findViewById(R.id.imgbtn_plusBag);
            imgbtn_minusBag = itemView.findViewById(R.id.imgbtn_minusBag);
            imgbtn_minusBag.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onPlus(position);
                }
            });
            imgbtn_plusBag.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onMinus(position);
                }
            });
        }
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Cloth cloth = mCloths.get(position);
        holder.imgCloth_bag.setImageResource(cloth.getAnh());
        holder.position = position;
        holder.tvName_bag.setText(cloth.getName());
        holder.tvSize_bag.setText(cloth.getSize());
        holder.tvPrice_bag.setText(cloth.getPrice()+"");
        holder.tvSo_bag.setText(cloth.getSoLuong()+"");

    }

}
