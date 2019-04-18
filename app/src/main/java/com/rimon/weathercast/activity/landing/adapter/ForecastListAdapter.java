package com.rimon.weathercast.activity.landing.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.rimon.weathercast.R;
import com.rimon.weathercast.activity.landing.model.ForecastDayBean;
import com.rimon.weathercast.common.Helper;

import java.util.List;


public class ForecastListAdapter extends RecyclerView.Adapter<ForecastListAdapter.ForecastViewHolder>{
    private List<ForecastDayBean> forecastDayBeans;
    Activity activity;


    public ForecastListAdapter(List<ForecastDayBean> forecastDayBeans, Activity activity){
        this.forecastDayBeans = forecastDayBeans;
        this.activity = activity;
    }

    @Override
    public ForecastViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflate the layout file
        View groceryProductView = LayoutInflater.from(parent.getContext()).inflate(R.layout.content_forcast_list, parent, false);
        ForecastViewHolder gvh = new ForecastViewHolder(groceryProductView);
        return gvh;
    }

    @Override
    public void onBindViewHolder(ForecastViewHolder holder, final int position) {
        //Picasso.with(context).load(forecastDayBeans.get(position).getImageView()).memoryPolicy(MemoryPolicy.NO_CACHE).into(holder.ivHzList);
            System.out.println("ForecastListAdapter "+Helper.getDayFromDate(forecastDayBeans.get(position).getDate()));
        holder.tvHeading.setText(Helper.getDayFromDate(forecastDayBeans.get(position).getDate()));
        holder.tvSubHeading.setText(forecastDayBeans.get(position).getDay().getAvgtemp_c()+" C");

        holder.llForecastContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               /* switch (forecastDayBeans.get(position).getIndex()){
                    case 0:
                        *//*Toast.makeText(activity,forecastDayBeans.get(position).getHeading()+" Is Clicked",Toast.LENGTH_SHORT).show();
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
        return forecastDayBeans.size();
    }

    public class ForecastViewHolder extends RecyclerView.ViewHolder {
        TextView tvHeading;
        TextView tvSubHeading;
        LinearLayout llForecastContent;
        public ForecastViewHolder(View view) {
            super(view);
            tvHeading=view.findViewById(R.id.tvHeading);
            tvSubHeading=view.findViewById(R.id.tvSubHeading);
            llForecastContent=view.findViewById(R.id.llForecastContent);
        }
    }
}
