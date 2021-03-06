package com.wholdus.tinderuitest.HomeScreen;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.wholdus.tinderuitest.R;

import java.util.List;

/**
 * Created by kaustubh on 18/11/16.
 */

public class SwipeDeck2Adapter extends BaseAdapter {

    private List<String> data;
    private Context context;
    private LayoutInflater layoutInflater;

    public SwipeDeck2Adapter(List<String> data, Context context) {
        this.data = data;
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.product_card_layout, parent, false);
            holder = new ViewHolder();
            holder.productImageView = (ImageView) convertView.findViewById(R.id.product_image_view);
            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }
        String uri = data.get(position);

        int imageResource = context.getResources().getIdentifier(uri, null, context.getPackageName());

        Drawable res = context.getResources().getDrawable(imageResource);
        holder.productImageView.setImageDrawable(res);

        return convertView;
    }

    static class ViewHolder {
        ImageView productImageView;
    }
}

