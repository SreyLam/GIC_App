//package com.example.drawnavigation.adapters;
//
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//import android.widget.TextView;
//import androidx.recyclerview.widget.RecyclerView;
//import com.bumptech.glide.request.RequestOptions;
//import com.example.drawnavigation.DataNote;
//import com.example.drawnavigation.R;
//import com.squareup.picasso.Picasso;
//
//import java.util.ArrayList;
//
//public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder>
//{
//    private ArrayList<DataNote> dataList;
//    private Context mContext;
//
//
//
//    public ListAdapter(Context context, ArrayList<DataNote> exampleList) {
//        mContext = context;
//        dataList = exampleList;
//    }
//
//
//    public class ViewHolder extends RecyclerView.ViewHolder
//    {
//
//        public TextView textViewText;
//        public TextView textViewDetail;
//        public TextView textViewEnd_date;
//        public TextView textViewSart_date;
//        public ImageView imageView;
//
//        public ViewHolder(View itemView)
//        {
//            super(itemView);
//            this.textViewText = (TextView) itemView.findViewById(R.id.text);
//            this.textViewDetail = (TextView) itemView.findViewById(R.id.detail);
//            this.textViewSart_date = (TextView) itemView.findViewById(R.id.start_date);
//            this.textViewEnd_date = (TextView) itemView.findViewById(R.id.end_date);
//            this.imageView = (ImageView) itemView.findViewById(R.id.image);
//        }
//    }
//
//    @Override
//    public ListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
//    {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item, parent, false);
//        ViewHolder viewHolder = new ViewHolder(view);
//        return viewHolder;
//    }
//
//    @Override
//    public void onBindViewHolder(ViewHolder holder, final int position)
//    {
//        DataNote currentItem = dataList.get(position);
//        String imageUrl = currentItem.getImageUrl();
//
//        holder.textViewText.setText(dataList.get(position).getText());
//        holder.textViewDetail.setText(dataList.get(position).getDetail());
//        holder.textViewSart_date.setText(dataList.get(position).getStart_date());
//        holder.textViewEnd_date.setText(dataList.get(position).getEnd_date());
//        //holder.imageView.setImageResource(dataList.get(position).getImageUrl());
//        Picasso.get().load(imageUrl).fit().centerInside().into(holder.imageView);
//
//        holder.itemView.setOnClickListener(new View.OnClickListener()
//        {
//            @Override
//            public void onClick(View v)
//            {
//
//            }
//        });
//    }
//
//    @Override
//    public int getItemCount()
//    {
//        return dataList.size();
//    }
//}
