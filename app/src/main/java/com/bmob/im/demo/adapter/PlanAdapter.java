package com.bmob.im.demo.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bmob.im.demo.R;
import com.bmob.im.demo.adapter.base.BaseListAdapter;
import com.bmob.im.demo.adapter.base.ViewHolder;
import com.bmob.im.demo.bean.Plan;
import com.bmob.im.demo.util.util.Calculator;
import com.bmob.im.demo.util.util.Format;
import com.bmob.im.demo.util.util.MemoryCache;

import java.util.ArrayList;
import java.util.List;

/**
 * ************************************************************
 * *********    User : SuLinger(462679107@qq.com) .
 * *********    Date : 2014-09-12  .
 * *********    Time:  2014-09-12  .
 * *********    Project name :PBOX1.3 .
 * *********    Copyright @ 2014, SuLinger, All Rights Reserved
 * *************************************************************
 */


public class PlanAdapter extends BaseListAdapter<Plan> {

    List<Plan> mPlans = new ArrayList<Plan>();

    public PlanAdapter(Context context, List<Plan> list) {
        super(context, list);
    }

    @Override
    public View bindView(int position, View contentView, ViewGroup parent) {

        LinearLayout backgroundLayout;
        TextView titleText;
        TextView timeText;
        ImageView headImg;
        TextView progressText;
        TextView dueText;
        if (contentView == null) {
            contentView = mInflater.inflate(R.layout.item_plan, null);

        }
        titleText = ViewHolder.get(contentView, R.id.item_plan_title_text);
        timeText = ViewHolder.get(contentView, R.id.item_plan_time_text);
        headImg = ViewHolder.get(contentView, R.id.item_plan_head_img);
        progressText = ViewHolder.get(contentView, R.id.item_plan_progress_text);
        backgroundLayout = ViewHolder.get(contentView, R.id.item_plan_background);
        dueText = ViewHolder.get(contentView, R.id.item_plan_due_text);


        String title = mPlans.get(position).getTitle();

        String dueTime = Format.getDueTimeString(mPlans.get(position).getPlanDate());


        int day = Calculator.calculate(dueTime);

        progressText.setText(mPlans.get(position).getProgress() + "%");
        dueText.setText(dueTime);
        if (day < 0) {
            titleText.setText(title + "已经");
        } else {
            titleText.setText(title + "还剩");
        }
        timeText.setText(String.valueOf(Math.abs(day)) + "天");

        int imageResId;
        int t = mPlans.get(position).get_id();
        switch (t) {
            case 1:
                imageResId = R.drawable.cover_bg4;
                backgroundLayout.setBackgroundResource(R.drawable.listitem_red);
                break;
            case 2:
                imageResId = R.drawable.cover_bg5;
                backgroundLayout.setBackgroundResource(R.drawable.listitem_yellow);
                break;
            case 3:
                imageResId = R.drawable.cover_bg6;
                backgroundLayout.setBackgroundResource(R.drawable.listitem_blue);
                break;
            case 4:
                imageResId = R.drawable.cover_bg3;
                backgroundLayout.setBackgroundResource(R.drawable.listitem_green);
                break;
            default:
                imageResId = R.drawable.cover_bg1;
                backgroundLayout.setBackgroundResource(R.drawable.listitem_white);
                break;
        }
        backgroundLayout.setPadding(6, 8, 8, 8);

        MemoryCache memoryCache = new MemoryCache();
        Bitmap bitmap = memoryCache.getBitmapFromMemCache(imageResId);
        if (bitmap == null) {
            bitmap = BitmapFactory.decodeResource(mContext.getResources(), imageResId);
            memoryCache.addBitmapToMemoryCache(imageResId, bitmap);
        }
        headImg.setImageBitmap(bitmap);
        return contentView;
    }
}







