package com.khoai.oto.adapters;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.khoai.oto.Chung;
import com.khoai.oto.Detail;
import com.khoai.oto.R;

import java.util.ArrayList;

/**
 * Created by hiepn on 8/31/2017.
 */
// Lop DetailAdapter dùng để hiển thị dữ liệu của các xe lên Listview
public class DetailAdapter extends BaseAdapter {
    private Context mContext;
    private ArrayList<Detail> list;
    private LayoutInflater mLayoutInflater;

    public DetailAdapter(Context mContext, ArrayList<Detail> detailArrayList) {
        this.mContext = mContext;
        this.list = detailArrayList;
        this.mLayoutInflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        Detail detail = list.get(position);
        if (convertView == null) {
            convertView = mLayoutInflater.inflate(R.layout.item_detail, parent, false);

            viewHolder = new ViewHolder() {
            };
            viewHolder.imvImage = (ImageView) convertView.findViewById(R.id.imvImage);
            viewHolder.tvName = (TextView) convertView.findViewById(R.id.tvName);
            viewHolder.tvType = (TextView) convertView.findViewById(R.id.tvType);
            viewHolder.tvCostNY = (TextView) convertView.findViewById(R.id.tvCostNY);
            viewHolder.tvCostDP = (TextView) convertView.findViewById(R.id.tvCostDP);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        //Neu muon load anh tu Web thi dung Glide
        /*Glide.with(mContext)
                .load(girlImageModel.getUrlImage())
                .into(viewHolder.imgGirlImage);*/
        //viewHolder.imvAnhXe.setImageResource(Integer.parseInt(detail.getImage()));
        Log.d("======image====", detail.getImage());
        viewHolder.tvName.setText(detail.getModen());
        viewHolder.tvType.setText(detail.getType());
        String strCostNY = Chung.stand_string(detail.getCostNY());
        String strCostDP = Chung.stand_string(detail.getCostDP());
        int intCostNY = Integer.parseInt(strCostNY);
        int intCostDP = Integer.parseInt(strCostDP);
        if (null != viewHolder.tvCostNY) {
            if (intCostNY >= 0 && intCostNY < 500) {
                viewHolder.tvCostNY.setTextColor(Color.BLUE); // Xanh dương
            } else if (intCostNY >= 500 && intCostNY < 800) {
                viewHolder.tvCostNY.setTextColor(Color.rgb(72, 150, 32)); // Xanh
            } else if (intCostNY >= 800 && intCostNY < 1000) {
                viewHolder.tvCostNY.setTextColor(Color.rgb(241, 175, 0)); // Cam
            } else if (intCostNY >= 1000 && intCostNY < 10000) {
                viewHolder.tvCostNY.setTextColor(Color.RED); // Đỏ
            } else{
                viewHolder.tvCostNY.setTextColor(Color.rgb(178, 0, 31)); // Đỏ mận
            }
            if (intCostDP >= 0 && intCostDP < 500) {
                viewHolder.tvCostDP.setTextColor(Color.BLUE); // Xanh dương
            } else if (intCostDP >= 500 && intCostDP < 800) {
                viewHolder.tvCostDP.setTextColor(Color.rgb(72, 150, 32)); // Xanh
            } else if (intCostDP >= 800 && intCostDP < 1000) {
                viewHolder.tvCostDP.setTextColor(Color.rgb(241, 175, 0)); // Cam
            } else if (intCostDP >= 1000 && intCostDP < 10000) {
                viewHolder.tvCostDP.setTextColor(Color.RED); // Đỏ
            } else{
                viewHolder.tvCostDP.setTextColor(Color.rgb(178, 0, 31)); // Đỏ mận
            }
            viewHolder.tvCostNY.setText(strCostNY);
            viewHolder.tvCostDP.setText(strCostDP);
        }
        return convertView;
    }

    private class ViewHolder {
        ImageView imvImage;
        TextView tvName;
        TextView tvType;
        TextView tvCostNY;
        TextView tvCostDP;

    }
}
