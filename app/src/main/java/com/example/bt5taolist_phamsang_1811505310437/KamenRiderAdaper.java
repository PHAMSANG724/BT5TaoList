package com.example.bt5taolist_phamsang_1811505310437;

import android.content.Context;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class KamenRiderAdaper extends BaseAdapter {

    private Context context;
    private int layout;
    private List<KamenRider> kamenRiderList;

    public KamenRiderAdaper(Context context, int layout, List<KamenRider> kamenRiderList) {
        this.context = context;
        this.layout = layout;
        this.kamenRiderList = kamenRiderList;
    }

    @Override
    public int getCount() {
        return kamenRiderList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    private class ViewHolder{
        ImageView imgHinh;
        TextView txtTen, txtMoTa;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHolder holder;

        if(view == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout, null);

            holder = new ViewHolder();

            holder.txtTen = (TextView) view.findViewById(R.id.textviewTen);
            holder.txtMoTa = (TextView) view.findViewById(R.id.textviewMoTa);
            holder.imgHinh = (ImageView) view.findViewById(R.id.imageviewHinh);
            view.setTag(holder);
        }else  {
            holder = (ViewHolder) view.getTag();

        }

        KamenRider kamenRider = kamenRiderList.get(i);

        holder.txtTen.setText(kamenRider.getTen());
        holder.txtMoTa.setText(kamenRider.getMoTa());
        holder.imgHinh.setImageResource(kamenRider.getHinh());

        return view;
    }
}
