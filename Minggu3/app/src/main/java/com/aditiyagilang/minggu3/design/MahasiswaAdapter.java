package com.aditiyagilang.minggu3.design;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.aditiyagilang.minggu3.R;
import com.aditiyagilang.minggu3.model.sosmedlist;

import java.util.ArrayList;

import javax.xml.namespace.QName;

public class MahasiswaAdapter extends BaseAdapter {


    private final Context context;
    private final ArrayList<sosmedlist> sosmedlist;

    public MahasiswaAdapter(Context context, ArrayList<sosmedlist> sosmedlist) {
        this.context = context;
        this.sosmedlist = sosmedlist;
    }

    @Override
    public int getCount() {
        return sosmedlist.size();
    }

    @Override
    public Object getItem(int position) {
        return sosmedlist.get(position);
    }

    @Override
    public long getItemId(int id) {
        return id;
    }

    @Override
    public View getView(int position, View convertview, ViewGroup parent) {
        HolderView holderView;
                if(convertview == null){
                    convertview = LayoutInflater.from(context).inflate(R.layout.layout_cardview,parent,false);

                    holderView = new HolderView(convertview);
                    convertview.setTag(holderView);
                }
                else {
                    holderView = (HolderView) convertview.getTag();
                }

        sosmedlist list = sosmedlist.get(position);
                holderView.medsos.setImageResource(list.getMedsos());
                holderView.name.setText(list.getName());
        return convertview;
    }

    private static class HolderView{
        private final ImageView medsos;
        private final TextView name;

        public  HolderView(View view){
            medsos = view.findViewById(R.id.medsos);
            name = view.findViewById(R.id.name);
        }
    }
}
