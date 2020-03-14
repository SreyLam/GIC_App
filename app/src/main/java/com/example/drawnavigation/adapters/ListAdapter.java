package com.example.drawnavigation.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.drawnavigation.DataNote;
import com.example.drawnavigation.R;

import java.util.ArrayList;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder>
{
    private ArrayList<DataNote> dataList;

    public ListAdapter(ArrayList<DataNote> data)
    {
        this.dataList = data;
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView textViewText;
        TextView textViewComment;
        TextView textViewDate;

        public ViewHolder(View itemView)
        {
            super(itemView);
            this.textViewText = (TextView) itemView.findViewById(R.id.text);
            this.textViewComment = (TextView) itemView.findViewById(R.id.comment);
            this.textViewDate = (TextView) itemView.findViewById(R.id.date);
        }
    }

    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ListAdapter.ViewHolder holder, final int position)
    {
        holder.textViewText.setText(dataList.get(position).getText());
        holder.textViewComment.setText(dataList.get(position).getComment());
        holder.textViewDate.setText(dataList.get(position).getDate());

        holder.itemView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

            }
        });
    }

    @Override
    public int getItemCount()
    {
        return dataList.size();
    }
}
