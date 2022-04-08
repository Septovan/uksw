package com.septovan.pam.pam_gallery.helper;

import android.content.Context;
import android.database.Cursor;
import android.database.MergeCursor;
import android.net.Uri;
import android.provider.MediaStore;

import java.util.HashMap;

public class AlbumHelper {
    public static final String KEY_ID = "id";
    public static final String KEY_ALBUM = "album";
    public static final String KEY_PATH = "path";
    public static final String KEY_TIMESTAMP = "timestamp";
    public static final String KEY_TIME = "time";
    public static final String KEY_COUNT = "count";

    // Mapping data from database to hash map
    public static HashMap<String, String> mapAlbumData(String id, String album, String path, String timestamp, String time, String count) {
        HashMap<String, String> albumData = new HashMap<>();

        albumData.put(KEY_ID, id);
        albumData.put(KEY_ALBUM, album);
        albumData.put(KEY_PATH, path);
        albumData.put(KEY_TIMESTAMP, timestamp);
        albumData.put(KEY_TIME, time);
        albumData.put(KEY_COUNT, count);

        return albumData;
    }

    public static String getImageCountInAlbum(Context context, String albumId) {
        Uri uriExternal = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;

        String[] projections = { MediaStore.MediaColumns.BUCKET_ID };

        Cursor cursorExternal = context.getContentResolver().query(uriExternal,
                projections,
                "bucket_id=?",
                new  String[] { albumId },
                null);

        return cursorExternal.getCount() + " Photos";
    }
}
