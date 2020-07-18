package com.example.drawnavigation.adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.drawnavigation.R;
import com.example.drawnavigation.model.PartnershipModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class PartnershipAdapter extends RecyclerView.Adapter<PartnershipAdapter.ViewHolder>

{
    private ArrayList<PartnershipModel> dataList;
    private Context mContext;
    private OnItemClickListener mListener;


    public interface OnItemClickListener {
        void onItemClick(int position);
    }
    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }


    public PartnershipAdapter(Context context, ArrayList<PartnershipModel> exampleList) {
        mContext = context;
        dataList = exampleList;

    }

    @Override
    public ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.partnership_row_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        PartnershipModel currentItem = dataList.get(position);
        String logo = currentItem.getLogo();


        holder.textViewName.setText(dataList.get(position).getName());
//        holder.textViewEnd_date.setText(dataList.get(position).getEnd_date());
        //holder.imageView.setImageResource(dataList.get(position).getImageUrl());
        Picasso.get().load(logo).fit().centerInside().into(holder.imageView);
//        holder.itemView.setOnClickListener(new View.OnClickListener()
//        {
//            @Override
//            public void onClick(View v)
//            {
//                String url = "https://www.univ-larochelle.fr/";
//
//                Intent i = new Intent(Intent.ACTION_VIEW);
//                i.setData(Uri.parse(url));
//                mContext.startActivity(i);
//            }
//
//        });

    }

    @Override
    public int getItemCount()  { return dataList.size(); }



    public class ViewHolder extends RecyclerView.ViewHolder
    {

        public TextView textViewName;
        //        public TextView textViewEnd_date;
        public TextView textViewWebsite;
        public ImageView imageView;
        public ViewHolder(View itemView)
        {
            super(itemView);
            this.textViewName = (TextView) itemView.findViewById(R.id.name);
            this.textViewWebsite = (TextView) itemView.findViewById(R.id.website);
//            this.textViewEnd_date = (TextView) itemView.findViewById(R.id.end_date);
            this.imageView = (ImageView) itemView.findViewById(R.id.logo);

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
