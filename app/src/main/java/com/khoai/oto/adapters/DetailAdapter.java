package com.khoai.oto.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
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

            viewHolder = new ViewHolder();
            viewHolder.imvAnhXe = (ImageView) convertView.findViewById(R.id.imvAnhXe);
            viewHolder.tvTenXe = (TextView) convertView.findViewById(R.id.tvTenXe);
            viewHolder.tvNhanHieu = (TextView) convertView.findViewById(R.id.tvNhanHieu);
            viewHolder.tvGNY = (TextView) convertView.findViewById(R.id.tvGNY);
            viewHolder.tvGĐP = (TextView) convertView.findViewById(R.id.tvGĐP);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        //Neu muon load anh tu Web thi dung Glide
        /*Glide.with(mContext)
                .load(girlImageModel.getUrlImage())
                .into(viewHolder.imgGirlImage);*/
        //viewHolder.imvAnhXe.setImageResource(Integer.parseInt(detail.getImage()));
        viewHolder.tvTenXe.setText(detail.getModen());
        viewHolder.tvNhanHieu.setText(detail.getEngine());
        viewHolder.tvGNY.setText(detail.getCostNY());
        viewHolder.tvGĐP.setText(detail.getCostDP());
        return convertView;
    }

    private class ViewHolder {
        ImageView imvAnhXe;
        TextView tvTenXe;
        TextView tvNhanHieu;
        TextView tvGNY;
        TextView tvGĐP;
        public ViewHolder() {
        }
    }
}
