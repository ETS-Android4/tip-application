package com.yetkinyurtsever.kermit_tips;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class BetListAdapter extends ArrayAdapter<BetCard> {

    private static final String TAG = "BetListAdapter";

    private Context mContext;
    int mResource;

    public BetListAdapter(Context context, int resource, ArrayList<BetCard> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        String homeTeam = getItem(position).getHomeTeam();
        String awayTeam = getItem(position).getAwayTeam();
        String matchCode = getItem(position).getMatchCode();
        String prediction = getItem(position).getPrediction();

        BetCard betCard = new BetCard(homeTeam, awayTeam, matchCode, prediction);

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);

        TextView tvHome = (TextView) convertView.findViewById(R.id.tvHomeTeam);
        TextView tvAway = (TextView) convertView.findViewById(R.id.tvAwayTeam);
        TextView tvMatchCode = (TextView) convertView.findViewById(R.id.tvMatchCode);
        TextView tvPredict = (TextView) convertView.findViewById(R.id.tvPrediction);

        tvHome.setText(homeTeam);
        tvAway.setText(awayTeam);
        tvMatchCode.setText(matchCode);
        tvPredict.setText(prediction);

        return convertView;
    }
}
