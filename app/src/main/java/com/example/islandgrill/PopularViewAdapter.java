package com.example.islandgrill;

import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;


public class PopularViewAdapter extends RecyclerView.Adapter<PopularViewAdapter.ViewHolder>
{
    private static final String TAG = "RecyclerViewAdapter";

    //vars
    private ArrayList<String> Names = new ArrayList<>();
    private ArrayList<Integer> Images = new ArrayList<>();
    private ArrayList<String> Description = new ArrayList<>();
    private ArrayList<String> Prices = new ArrayList<>();
    private Context mContext;
    public PopularViewAdapter(Context context, ArrayList<String> names, ArrayList<Integer> images,ArrayList<String> desc,ArrayList<String> pri) {
        names = names;
        Images = images;
        Description = desc;
        Prices = pri;
        mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listitem, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called.");

        Glide.with(mContext)
                .asBitmap()
                .load(Images.get(position))
                .into(holder.image);

        holder.name.setText(Names.get(position));
        holder.description.setText(Description.get(position));
        holder.price.setText(Prices.get(position));

        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: clicked on an image: " + Names.get(position));
                Toast.makeText(mContext, Names.get(position), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return Images.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView name,description,price;

        public ViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.fimage);
            name = itemView.findViewById(R.id.fname);
            description = itemView.findViewById(R.id.description);
            price = itemView.findViewById(R.id.amount);
        }
    }
}
