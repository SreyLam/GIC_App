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

public class PartnershipAdapter extends RecyclerView.Adapter<PartnershipAdapter.AwardViewHolder>{

    public static double length;
    private ArrayList<SeminarModel> partnershipModelList=new ArrayList<>();
    private Context context;


    public PartnershipAdapter(Context context)
    {
        this.context=context;
    }

    public ArrayList<SeminarModel> getAwardModelList() {
        return partnershipModelList;
    }

    public void setSeminarModelList(ArrayList<SeminarModel> awardModelList) {
        this.partnershipModelList = awardModelList;
    }

    @Override
    public PartnershipAdapter.AwardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new PartnershipAdapter.AwardViewHolder(LayoutInflater.from(context).inflate(R.layout.partnership_item,parent,false));
    }

    @Override
    public void onBindViewHolder(PartnershipAdapter.AwardViewHolder holder, int position)
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
        return partnershipModelList.size();
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
