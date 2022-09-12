package com.example.singlefragmentcode;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.singlefragmentcode.Models.Product;
import com.squareup.picasso.Picasso;

import java.util.List;

public class myAdapter extends RecyclerView.Adapter<myAdapter.holder> {
    private List<Product> dataList;
    private Context context;

    public myAdapter(Context context, List<Product> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.row_design,parent,false);
        return new holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull holder holder, int position) {
        holder.id.setText(String.valueOf(dataList.get(position).getId()));
        holder.title.setText(String.valueOf(dataList.get(position).getTitle()));
        holder.price.setText(String.valueOf(dataList.get(position).getPrice()));
        holder.description.setText(String.valueOf(dataList.get(position).getDescription()));
        holder.category.setText(String.valueOf(dataList.get(position).getCategory()));

        holder.rating.setText(String.valueOf(dataList.get(position).getRating().getRate()));
        holder.count.setText(String.valueOf(dataList.get(position).getRating().getCount()));

        Picasso
                .get()
                .load(dataList.get(position).getImage())
                .placeholder(R.drawable.ic_launcher_background)
                .fit()
                .into(holder.image);

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class holder extends RecyclerView.ViewHolder {

        TextView id,title,price,description,category,rating,count;
        ImageView image;

        public holder(@NonNull View itemView) {
            super(itemView);

            id=itemView.findViewById(R.id.id);
            title=itemView.findViewById(R.id.title);
            price=itemView.findViewById(R.id.price);
            description=itemView.findViewById(R.id.description);
            category=itemView.findViewById(R.id.category);
            rating=itemView.findViewById(R.id.rating);
            count=itemView.findViewById(R.id.count);
            image=itemView.findViewById(R.id.image);

        }
    }
}
