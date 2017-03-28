package com.wholdus.tinderuitest.HomeScreen;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.wholdus.tinderuitest.R;

import java.util.List;

/**
 * Created by kaustubh on 28/11/16.
 */

public class CardsDataAdapter extends ArrayAdapter {
    private List<String> data;
    private Context context;
    private LayoutInflater layoutInflater;

    public CardsDataAdapter(List<String> data, Context context, int position) {
        super(context, position);
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
        final SwipeDeck2Adapter.ViewHolder holder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.product_card_layout, parent, false);
            holder = new SwipeDeck2Adapter.ViewHolder();
            holder.productImageView = (ImageView) convertView.findViewById(R.id.product_image_view);
            convertView.setTag(holder);
        }
        else {
            holder = (SwipeDeck2Adapter.ViewHolder) convertView.getTag();
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
