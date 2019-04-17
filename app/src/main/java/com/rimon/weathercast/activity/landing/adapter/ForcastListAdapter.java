package com.rimon.weathercast.activity.landing.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.rimon.weathercast.R;
import com.rimon.weathercast.activity.landing.model.ForecastdayBean;

import java.util.List;


public class ForcastListAdapter extends RecyclerView.Adapter<ForcastListAdapter.ForcastViewHolder>{
    private List<ForecastdayBean> forecastdayBeans;
    Activity activity;


    public ForcastListAdapter(List<ForecastdayBean> forecastdayBeans, Activity activity){
        this.forecastdayBeans = forecastdayBeans;
        this.activity = activity;
    }

    @Override
    public ForcastViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflate the layout file
        View groceryProductView = LayoutInflater.from(parent.getContext()).inflate(R.layout.content_forcast_list, parent, false);
        ForcastViewHolder gvh = new ForcastViewHolder(groceryProductView);
        return gvh;
    }

    @Override
    public void onBindViewHolder(ForcastViewHolder holder, final int position) {
        //Picasso.with(context).load(forecastdayBeans.get(position).getImageView()).memoryPolicy(MemoryPolicy.NO_CACHE).into(holder.ivHzList);

        holder.tvHeading.setText(forecastdayBeans.get(position).getDate());
        holder.tvSubHeading.setText(""+forecastdayBeans.get(position).getDay().getAvgtemp_c());

        holder.llForecastContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               /* switch (forecastdayBeans.get(position).getIndex()){
                    case 0:
                        *//*Toast.makeText(activity,forecastdayBeans.get(position).getHeading()+" Is Clicked",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(activity, UserPropertyListActivity.class);
                        intent.putExtra("UserDetails", userDetails);
                        activity.startActivityForResult(intent,123);*//*
                        break;
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:

                        break;
                    case 6:

                        break;
                    default:

                        break;
                }*/

            }
        });

    }

    @Override
    public int getItemCount() {
        return forecastdayBeans.size();
    }

    public class ForcastViewHolder extends RecyclerView.ViewHolder {
        TextView tvHeading;
        TextView tvSubHeading;
        LinearLayout llForecastContent;
        public ForcastViewHolder(View view) {
            super(view);
            tvHeading=view.findViewById(R.id.tvHeading);
            tvSubHeading=view.findViewById(R.id.tvSubHeading);
            llForecastContent=view.findViewById(R.id.llForecastContent);
        }
    }
}
