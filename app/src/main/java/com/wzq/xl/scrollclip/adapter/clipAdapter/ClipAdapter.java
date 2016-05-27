package com.wzq.xl.scrollclip.adapter.clipAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.wzq.xl.scrollclip.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wzq on 2016/3/18.
 */
public class ClipAdapter extends RecyclingPagerAdapter {
    private Animation mAnimation;
    private final List<Integer> mList;
    private Context mContext;
    private final float W_H_RATE = 320.f /568.0f;


    public ClipAdapter(Context context) {
        mList = new ArrayList<Integer>();
        mContext = context;

    }

    public void addAll(List<Integer> list) {
        mList.clear();
        mList.addAll(list);
        notifyDataSetChanged();
    }


    @Override
    public View getView(int position, View convertView, ViewGroup container) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.customerviewlayout, container, false);
            convertView.measure(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT);
            convertView.setLayoutParams(new FrameLayout.LayoutParams((int)(convertView.getMeasuredHeight() * W_H_RATE), convertView.getMeasuredHeight()));
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }


        viewHolder.imageView.setImageDrawable(mContext.getResources().getDrawable(mList.get(position)));



        return convertView;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    private static class ViewHolder {

        private ImageView imageView;

        public ViewHolder(View view) {
            imageView = (ImageView) view.findViewById(R.id.imageView);
        }
    }
}