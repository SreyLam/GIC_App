package com.example.drawnavigation.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.drawnavigation.R;
import com.example.drawnavigation.model.SeminarModel;

import java.util.ArrayList;


public class SeminarAdapter extends RecyclerView.Adapter<SeminarAdapter.AwardViewHolder>
{
    private ArrayList<SeminarModel> seminarModelList=new ArrayList<>();
    private Context ctx;


    public SeminarAdapter(Context ctx)
    {
        this.ctx=ctx;
    }

    public ArrayList<SeminarModel> getAwardModelList() {
        return seminarModelList;
    }

    public void setSeminarModelList(ArrayList<SeminarModel> awardModelList) {
        this.seminarModelList = awardModelList;
    }

    @Override
    public AwardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new AwardViewHolder(LayoutInflater.from(ctx).inflate(R.layout.seminars_row_item,parent,false));
    }

    @Override
    public void onBindViewHolder(AwardViewHolder holder, int position)
    {
        final SeminarModel awardModel=getAwardModelList().get(position);
        if(null!=awardModel)
        {
            holder.seminarName.setText(awardModel.getName());
            holder.date.setText(awardModel.getDatetime());
        }

    }

    @Override
    public int getItemCount() {
        return seminarModelList.size();
    }

    class AwardViewHolder extends RecyclerView.ViewHolder {
        TextView seminarName,date;
        AwardViewHolder(View itemView) {
            super(itemView);
            seminarName=(TextView)itemView.findViewById(R.id.seminar_name);
            date=(TextView)itemView.findViewById(R.id.datetime);
        }
    }
}
