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

public class PhotosAdapter extends BaseAdapter {

    private Activity activity;
    private ArrayList<HashMap<String, String>> data;

    public PhotosAdapter(Activity activity, ArrayList<HashMap<String, String>> data) {
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
        PhotosItemViewHolder holder = null;
        if (view == null) {
            holder = new PhotosItemViewHolder();
            view = LayoutInflater.from(activity).inflate(R.layout.photos_item, viewGroup, false);

            holder.photosItemImage = view.findViewById(R.id.photos_item_image);

            view.setTag(holder);
        }
        else {
            holder = (PhotosItemViewHolder) view.getTag();
        }

        holder.photosItemImage.setId(i);

        HashMap<String, String> album = new HashMap<>();
        try {
            album = data.get(i);

            Glide.with(activity)
                    .load(new File(album.get(AlbumHelper.KEY_PATH)))
                    .into(holder.photosItemImage);
        }
        catch(Exception ex) {
            Log.println(Log.ERROR, null, ex.getMessage());
        }

        return view;
    }

    class PhotosItemViewHolder {
        ImageView photosItemImage;
    }
}
