package com.ecosd.project.carbonfootprint;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import Models.AlternativeModel;


public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder>
{

    public static View view;
    public RecyclerView re;
    VenueAdapterClickCallbacks venueAdapterClickCallbacks;

    Context mContext;
    private ArrayList<AlternativeModel> dataSet;

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView title;
        TextView description;
        LinearLayout llExpandArea;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.title = (TextView) itemView.findViewById(R.id.alertTitle);
            this.description = (TextView) itemView.findViewById(R.id.descriptional);
            this.image=(ImageView)itemView.findViewById(R.id.imageal);
            view=itemView.findViewById(R.id.separater_view);
            this.llExpandArea = (LinearLayout) itemView.findViewById(R.id.llExpandArea);

        }
    }

    public CustomAdapter(Context mContext, ArrayList<AlternativeModel> data, VenueAdapterClickCallbacks venueAdapterClickCallback) {
        this.dataSet = data;
        this.mContext = mContext;
        this.venueAdapterClickCallbacks=venueAdapterClickCallback;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        Log.d("TAG", "onCreateViewHolder called");
        final View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.alternative_card, parent, false);
        re=(RecyclerView)parent.findViewById(R.id.alternative_grid);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        view.setTag(myViewHolder);
        Log.e("Dataaaaa",dataSet.toString());
        return myViewHolder;

    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int listPosition) {

        TextView question = holder.title;
        TextView answer = holder.description;
        ImageView imageView=holder.image;
        view.setVisibility(View.GONE);
        final int current=holder.getLayoutPosition();
        String q=dataSet.get(listPosition).getTitle();
        String a=dataSet.get(listPosition).getDescription();
        int is=dataSet.get(listPosition).getImage();

        imageView.setImageResource(is);
        question.setText(q);
        answer.setText(a);
        if (dataSet.get(listPosition).isChecked == true) {
            holder.llExpandArea.setVisibility(View.VISIBLE);

        } else {
            holder.llExpandArea.setVisibility(View.GONE);

     onExpand( holder.itemView, mContext, listPosition);

        }
    }


    private void onExpand(View view, final Context mContext, final int position) {
        view.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (dataSet.get(position).isChecked != true) {
                            dataSet.get(position).isChecked = true;
                            re.scrollToPosition(position);
                        }

                        else {
                            dataSet.get(position).isChecked = false;
                            re.scrollToPosition(position);
                        }
                        notifyItemChanged(position);

                    }
                }

        );
    }
    public interface VenueAdapterClickCallbacks {
        void onShareClick(String a);

    }
    @Override
    public int getItemCount() {
        Log.e("Data sice",dataSet.size()+"");
        return dataSet.size();
    }

}
