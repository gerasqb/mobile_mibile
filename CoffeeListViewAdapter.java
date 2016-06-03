package com.homemade.barista;

/**
 * Created by Александр on 11.05.2016.
 */

import android.content.Context;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class CoffeeListViewAdapter extends ArrayAdapter<Coffee> {
    Context context;
    LayoutInflater inflater;
    List<Coffee> baseItemsList;
    private SparseBooleanArray mSelectedItemsIds;

    public CoffeeListViewAdapter(Context context, int resourceId,
                                 List<Coffee> baseItemsList) {
        super(context, resourceId, baseItemsList);
        mSelectedItemsIds = new SparseBooleanArray();
        this.context = context;
        this.baseItemsList = baseItemsList;
        inflater = LayoutInflater.from(context);
    }

    private class ViewHolder {
        TextView title;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;

        ViewHolder holder = new ViewHolder();

        // First let's verify the convertView is not null
        if (convertView == null) {
            // This a new view we inflate the new layout
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.coffee_list_item, null);
            // Now we can fill the layout with the right values
            holder.title = (TextView) v.findViewById(R.id.title);
            v.setTag(holder);
        } else
            holder = (ViewHolder) v.getTag();

        Coffee p = baseItemsList.get(position);
        holder.title.setText(p.getTitle());

        return v;
    }

    public void remove(Coffee object) {
        baseItemsList.remove(object);
        notifyDataSetChanged();
    }

    public List<Coffee> getWorldPopulation() {
        return baseItemsList;
    }

    public void toggleSelection(int position) {
        selectView(position, !mSelectedItemsIds.get(position));
    }

    public void removeSelection() {
        mSelectedItemsIds = new SparseBooleanArray();
        notifyDataSetChanged();
    }

    public void selectView(int position, boolean value) {
        if (value)
            mSelectedItemsIds.put(position, value);
        else
            mSelectedItemsIds.delete(position);
        notifyDataSetChanged();
    }

    public int getSelectedCount() {
        return mSelectedItemsIds.size();
    }

    public SparseBooleanArray getSelectedIds() {
        return mSelectedItemsIds;
    }
}
