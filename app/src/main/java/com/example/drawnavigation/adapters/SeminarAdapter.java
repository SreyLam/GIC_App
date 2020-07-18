package com.example.drawnavigation.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.drawnavigation.Detail_SeminarActivity;
import com.example.drawnavigation.R;
import com.example.drawnavigation.SeminarActivity;
import com.example.drawnavigation.model.SeminarModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class SeminarAdapter extends RecyclerView.Adapter<SeminarAdapter.ViewHolder>

{
    private ArrayList<SeminarModel> dataList;
    private Context mContext;
    private OnItemClickListener mListener;


    public interface OnItemClickListener {
        void onItemClick(int position);
    }
    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }


    public SeminarAdapter(Context context, ArrayList<SeminarModel> exampleList) {
        mContext = context;
        dataList = exampleList;

    }

    @Override
    public ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.seminars_row_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        SeminarModel currentItem = dataList.get(position);
        String imageUrl = currentItem.getImageUrl();


        holder.textViewName.setText(dataList.get(position).getName());
        holder.textViewStart_date.setText(dataList.get(position).getStart_date());
        holder.textViewEnd_date.setText(dataList.get(position).getEnd_date());
        //holder.imageView.setImageResource(dataList.get(position).getImageUrl());
        Picasso.get().load(imageUrl).fit().centerInside().into(holder.imageView);

    }

    @Override
    public int getItemCount()  { return dataList.size(); }



    public class ViewHolder extends RecyclerView.ViewHolder
    {

        public TextView textViewName;
        public TextView textViewEnd_date;
        public TextView textViewStart_date;
        public ImageView imageView;
        public ViewHolder(View itemView)
        {
            super(itemView);
            this.textViewName = (TextView) itemView.findViewById(R.id.name);
            this.textViewStart_date = (TextView) itemView.findViewById(R.id.start_date);
            this.textViewEnd_date = (TextView) itemView.findViewById(R.id.end_date);
            this.imageView = (ImageView) itemView.findViewById(R.id.image);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (mListener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            mListener.onItemClick(position);


                        }
                    }

                }
            });

        }
    }

}
