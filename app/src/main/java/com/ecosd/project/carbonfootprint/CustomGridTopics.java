package com.ecosd.project.carbonfootprint;

/**
 * Created by this pc on 11-04-17.
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import Models.ArticleStructure;


public class CustomGridTopics extends RecyclerView.Adapter<CustomGridTopics.MyNewsHolder>
{
    public RecyclerView re;
    private List<ArticleStructure> dataSet ;
    public Context context=null;
    VenueAdapterClickCallbacks venueAdapterClickCallbacks;

    public class MyNewsHolder extends RecyclerView.ViewHolder
    {
        TextView author;
        TextView headline;
        TextView description;
        ImageView image;
        public MyNewsHolder(View itemView)
        {
            super(itemView);
            this.author = (TextView) itemView.findViewById(R.id.author);
            this.headline = (TextView) itemView.findViewById(R.id.headline);
            this.description=(TextView)itemView.findViewById(R.id.description);
            this.image=(ImageView)itemView.findViewById(R.id.image);
        }
    }
    public CustomGridTopics(Context c, List<ArticleStructure> data, VenueAdapterClickCallbacks venueAdapterClickCallback)
    {

        this.dataSet = data;
        this.venueAdapterClickCallbacks=venueAdapterClickCallback;
        context=c;


    }
    @Override
    public MyNewsHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.news_card, parent, false);
        MyNewsHolder myNewsHolder=new MyNewsHolder(view);
        re = (RecyclerView) parent.findViewById(R.id.news_grid);
        return myNewsHolder;
    }

    @Override
    public void onBindViewHolder( MyNewsHolder holder,final int position)
    {
        TextView author = holder.author;
        TextView headline = holder.headline;
        TextView description=holder.description;
        ImageView image=holder.image;
        author.setText("Author: "+dataSet.get(position).author);
        String p=dataSet.get(position).urlToImage;

        if(p!=null) {
            setImageoncard(context,image,p);
        }
        headline.setText(dataSet.get(position).title);
        description.setText(dataSet.get(position).description+"...");

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                venueAdapterClickCallbacks.onCardClick(dataSet.get(position).url);

            }
        });

//        holder.description.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                venueAdapterClickCallbacks.onShareClick(dataSet.get(position).getTitle());
//            }
//        });

    }
    public interface VenueAdapterClickCallbacks {
        void onCardClick( String p);
        void onShareClick(String a);

    }

    @Override
    public int getItemCount()
    {
        return dataSet.size();
    }

    private void setImageoncard(Context context, ImageView img, String url) {
        Picasso.with(context)
                .load(url)
                .fit()
                .centerCrop()
                .into(img);
    }

}
