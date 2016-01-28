package com.miguelcr.navigationdrawer;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by miguelcampos on 26/1/16.
 */
public class StationAdapter extends RecyclerView.Adapter<StationAdapter.StationViewHolder> {
        private ArrayList<Station> mDataset;

        // Provide a reference to the views for each data item
        // Complex data items may need more than one view per item, and
        // you provide access to all the views for a data item in a view holder
        public static class StationViewHolder extends RecyclerView.ViewHolder {
            // each data item is just a string in this case
            public TextView stationName;
            public ImageView parkingIcon;
            public ImageView tramIcon;
            public ImageView busIcon;
            public ImageView trainConnectionIcon;
            public StationIconView stationIcon;
            public StationViewHolder(View v) {

                super(v);

                stationName = (TextView)v.findViewById(R.id.station_name);
                parkingIcon = (ImageView)v.findViewById(R.id.parking_icon);
                tramIcon = (ImageView)v.findViewById(R.id.tram_icon);
                busIcon = (ImageView)v.findViewById(R.id.bus_icon);
                trainConnectionIcon = (ImageView)v.findViewById(R.id.train_icon);
                stationIcon = (StationIconView)v.findViewById(R.id.station_icon);

            }
        }

        // Provide a suitable constructor (depends on the kind of dataset)
        public StationAdapter(ArrayList<Station> myDataset) {
            mDataset = myDataset;
        }

        // Create new views (invoked by the layout manager)
        @Override
        public StationAdapter.StationViewHolder onCreateViewHolder(ViewGroup parent,
                                                            int viewType) {
            // create a new view
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.recycler_item_station, parent, false);
            // set the view's size, margins, paddings and layout parameters

            StationViewHolder vh = new StationViewHolder(v);
            return vh;
        }

        // Replace the contents of a view (invoked by the layout manager)
        @Override
        public void onBindViewHolder(StationViewHolder holder, int position) {
            // - get element from your dataset at this position
            // - replace the contents of the view with that element
            holder.stationName.setText(mDataset.get(position).getName());
            if(!mDataset.get(position).isParking()) {
                holder.parkingIcon.setVisibility(View.GONE);
            }
            if(!mDataset.get(position).isBusConnection()) {
                holder.busIcon.setVisibility(View.GONE);
            }
            if(!mDataset.get(position).isTrampConnection()) {
                holder.tramIcon.setVisibility(View.GONE);
            }
            if(!mDataset.get(position).isTrainConnection()) {
                holder.trainConnectionIcon.setVisibility(View.GONE);
            }
        }

        // Return the size of your dataset (invoked by the layout manager)
        @Override
        public int getItemCount() {
            return mDataset.size();
        }
}
