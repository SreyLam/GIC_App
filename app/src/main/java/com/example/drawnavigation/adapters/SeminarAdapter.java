package com.example.drawnavigation.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.drawnavigation.R;
import com.example.drawnavigation.SeminarActivity;
import com.example.drawnavigation.model.SeminarModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class SeminarAdapter extends RecyclerView.Adapter<SeminarAdapter.ViewHolder>

{
    private ArrayList<SeminarModel> dataList;
    private Context mContext;

    public SeminarAdapter(Context context, ArrayList<SeminarModel> exampleList) {
        mContext = context;
        dataList = exampleList;
    }

    public SeminarAdapter(SeminarActivity seminarActivity) {

    }


    public class ViewHolder extends RecyclerView.ViewHolder
    {

        public TextView textViewName;
        //        public TextView textViewComment;
        public TextView textViewEnd_date;
        public TextView textViewSart_date;
        public ImageView imageView;

        public ViewHolder(View itemView)
        {
            super(itemView);
            this.textViewName = (TextView) itemView.findViewById(R.id.name);
//            this.textViewComment = (TextView) itemView.findViewById(R.id.comment);
            this.textViewSart_date = (TextView) itemView.findViewById(R.id.start_date);
            this.textViewEnd_date = (TextView) itemView.findViewById(R.id.end_date);
            this.imageView = (ImageView) itemView.findViewById(R.id.image);
        }
    }
    @Override
    public SeminarAdapter.ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.seminars_row_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        SeminarModel currentItem = dataList.get(position);
        String imageUrl = currentItem.getImageUrl();

        holder.textViewName.setText(dataList.get(position).getName());
        holder.textViewSart_date.setText(dataList.get(position).getStart_date());
        holder.textViewEnd_date.setText(dataList.get(position).getEnd_date());
        //holder.imageView.setImageResource(dataList.get(position).getImageUrl());
        Picasso.get().load(imageUrl).fit().centerInside().into(holder.imageView);

        holder.itemView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

            }
        });

    }




    @Override
    public int getItemCount()  { return dataList.size(); }


//    private ArrayList<SeminarModel> seminarModelList=new ArrayList<>();
//    private Context ctx;
//
//
//    public SeminarAdapter(Context ctx)
//    {
//        this.ctx=ctx;
//    }
//
//    public ArrayList<SeminarModel> getAwardModelList() {
//        return seminarModelList;
//    }
//
//    public void setSeminarModelList(ArrayList<SeminarModel> awardModelList) {
//        this.seminarModelList = awardModelList;
//    }
//
//    @Override
//    public AwardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        return new AwardViewHolder(LayoutInflater.from(ctx).inflate(R.layout.seminars_row_item,parent,false));
//    }
//
//    @Override
//    public void onBindViewHolder(AwardViewHolder holder, int position)
//    {
//        final SeminarModel awardModel=getAwardModelList().get(position);
//        if(null!=awardModel)
//        {
//            holder.seminarName.setText(awardModel.getName());
//            holder.date.setText(awardModel.getDatetime());
//        }
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return seminarModelList.size();
//    }
//
//    class AwardViewHolder extends RecyclerView.ViewHolder {
//        TextView seminarName,date;
//        AwardViewHolder(View itemView) {
//            super(itemView);
//            seminarName=(TextView)itemView.findViewById(R.id.seminar_name);
//            date=(TextView)itemView.findViewById(R.id.datetime);
//        }
//    }
}
