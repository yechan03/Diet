package com.example.diet;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import static com.example.diet.R.id.recycler_image;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder>{

    private ArrayList<Data> mList;

    private ItemClick listener;


    public RecyclerAdapter(ArrayList<Data> mArrayList) {

        this.mList = mArrayList;
    }

    public void setOnItemClickListener(ItemClick listener) {
        this.listener = listener;
    }


    public interface ItemClick {
        public void onImageClick(int position);
        public void onText1Click(int position);
        public void onText2Click(int position);
    }





    public class RecyclerViewHolder extends RecyclerView.ViewHolder {


        protected TextView recycler_text1;
        protected TextView recycler_text2;
        protected ImageView recycler_image;


        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            this.recycler_text1 = itemView.findViewById(R.id.recycler_text1);
            this.recycler_text2 = itemView.findViewById(R.id.recycler_text2);
            this.recycler_image = itemView.findViewById(R.id.recycler_image);

        }
    }



    @NonNull
    @Override
    public RecyclerAdapter.RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, final int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);

        final RecyclerViewHolder viewHolder = new RecyclerViewHolder(view);

        viewHolder.recycler_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null){
                    listener.onImageClick(viewHolder.getAdapterPosition());
                }
            }
        });

        viewHolder.recycler_text1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null){
                    listener.onText1Click(viewHolder.getAdapterPosition());
                }
            }
        });

        viewHolder.recycler_text2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null)
                {
                    listener.onText2Click(viewHolder.getAdapterPosition());
                }
            }
        });



        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.RecyclerViewHolder holder, int position) {

        holder.recycler_text1.setText(mList.get(position).getRecycler_text1());
        holder.recycler_text2.setText(mList.get(position).getRecycler_text2());
        holder.recycler_image.setImageResource(mList.get(position).getRecycler_image());


    }

    @Override
    public int getItemCount() {
        return (null != mList ? mList.size():0);
    }


}
