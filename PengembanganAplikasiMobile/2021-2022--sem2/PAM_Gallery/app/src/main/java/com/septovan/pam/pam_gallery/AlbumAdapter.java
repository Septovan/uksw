package com.septovan.pam.pam_gallery;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.septovan.pam.pam_gallery.helper.AlbumHelper;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class AlbumAdapter extends BaseAdapter {
    private Activity activity;
    ArrayList<HashMap<String, String>> data;

    public AlbumAdapter(Activity activity, ArrayList<HashMap<String, String>> data) {
        this.activity = activity;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        AlbumItemViewHolder holder = null;
        if (view == null) {
            holder = new AlbumItemViewHolder();
            view = LayoutInflater.from(activity).inflate(R.layout.album_item, viewGroup, false);

            holder.albumItemImage = view.findViewById(R.id.album_item_image);
            holder.albumItemCount = view.findViewById(R.id.album_item_count);
            holder.albumItemTitle = view.findViewById(R.id.album_item_title);

            view.setTag(holder);
        }
        else {
            holder = (AlbumItemViewHolder) view.getTag();
        }

        holder.albumItemImage.setId(i);
        holder.albumItemCount.setId(i);
        holder.albumItemTitle.setId(i);

        HashMap<String, String> album = new HashMap<>();
        try {
            album = data.get(i);
            holder.albumItemCount.setText(album.get(AlbumHelper.KEY_COUNT));
            holder.albumItemTitle.setText(album.get(AlbumHelper.KEY_ALBUM));

            Glide.with(activity)
                    .load(new File(album.get(AlbumHelper.KEY_PATH)))
                    .into(holder.albumItemImage);
        }
        catch(Exception ex) {
            Log.println(Log.ERROR, null, ex.getMessage());
        }

        return view;
    }

    class AlbumItemViewHolder {
        ImageView albumItemImage;
        TextView albumItemCount, albumItemTitle;
    }
}
