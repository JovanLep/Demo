package com.lep.demo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;

import com.lep.demo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by android on 2017/10/30.
 */

public class SlidingListAdapter extends BaseAdapter {
    private Context context;
    List<String> list=new ArrayList<>();

    public SlidingListAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.size();
    }

    @Override
    public long getItemId(int i) {
        return list.size();
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        ViewHolder holder=null;
        if(convertView==null){
            holder=new ViewHolder();
            convertView= LayoutInflater.from(context).inflate(R.layout.item_mylistview,viewGroup,false);
            holder.iv_header=convertView.findViewById(R.id.iv_header);
            holder.cannelbt=convertView.findViewById(R.id.bt_call);
            holder.deletebt=convertView.findViewById(R.id.bt_delete);

            convertView.setTag(holder);
        }else{
            holder = (ViewHolder)convertView.getTag();
        }


        return convertView;
    }
    public final class ViewHolder{
        public ImageView iv_header;
        public Button deletebt;
        public Button cannelbt;

    }
}
