package com.example.drawnavigation.adapters;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.drawnavigation.R;
import com.example.drawnavigation.model.ScholarshipModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ScholarshipAdapter extends RecyclerView.Adapter<ScholarshipAdapter.ViewHolder> {
    private ArrayList<ScholarshipModel> dataList;
    private Context mContext;
    private OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }
    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    public ScholarshipAdapter(Context context, ArrayList<ScholarshipModel> exampleList) {
        mContext = context;
        dataList = exampleList;
    }



    @Override
    public ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        ScholarshipModel currentItem = dataList.get(position);
        String flag = currentItem.getFlag();

        holder.textViewTitle.setText(dataList.get(position).getTitle());
        holder.textViewDate.setText(dataList.get(position).getDate());
        holder.textViewShort_description.setText(dataList.get(position).getShort_description());
        Picasso.get().load(flag).fit().centerInside().into(holder.flag);
//        holder.textViewDescription.setText(dataList.get(position).getDescription());

    }




    @Override
    public int getItemCount()  { return dataList.size(); }



    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView textViewTitle;
        public TextView textViewShort_description;
        public TextView textViewDescription;
        public TextView textViewDate;
        public ImageView flag;


        public ViewHolder(View itemView) {
            super(itemView);
            this.textViewTitle = (TextView) itemView.findViewById(R.id.title);
            this.textViewShort_description = (TextView) itemView.findViewById(R.id.short_description);
//            this.textViewDescription = (TextView) itemView.findViewById(R.id.description);
            this.textViewDate = (TextView) itemView.findViewById(R.id.date);
            this.flag = (ImageView) itemView.findViewById(R.id.flag);


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

