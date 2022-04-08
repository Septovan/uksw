package com.septovan.pam.pam_gallery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.DisplayMetrics;
import android.widget.GridView;

import com.septovan.pam.pam_gallery.helper.AlbumHelper;
import com.septovan.pam.pam_gallery.helper.CommonHelper;

import java.util.ArrayList;
import java.util.HashMap;

public class PhotosActivity extends AppCompatActivity {

    private GridView gridViewPhotosContainer;
    private ArrayList<HashMap<String, String>> photos = new ArrayList<>();
    private LoadPhotosTask loadPhotosTask;
    private String albumId, albumTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photos);

        gridViewPhotosContainer = findViewById(R.id.gridView_photos_container);

        // Gridview Item Column Width
        int iDisplayWidth = getResources().getDisplayMetrics().widthPixels;
        Resources resources = getApplicationContext().getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        float dp = iDisplayWidth / (displayMetrics.densityDpi / 160f);
        if (dp < 360) {
            dp = (dp - 17) / 2;
            float px = CommonHelper.convertDpToPx(dp, getApplicationContext());
            gridViewPhotosContainer.setColumnWidth(Math.round(px));
        }

        albumId = getIntent().getStringExtra("albumId");
        albumTitle = getIntent().getStringExtra("albumTitle");

        setTitle(albumTitle);

        loadPhotosTask = new LoadPhotosTask();
        loadPhotosTask.execute();
    }

    class LoadPhotosTask extends AsyncTask<String, Void, String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            photos.clear();
        }

        @Override
        protected String doInBackground(String... strings) {
            Uri uriExternal = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;

            String[] projections = { MediaStore.MediaColumns.DATA,
                    MediaStore.MediaColumns.BUCKET_DISPLAY_NAME,
                    MediaStore.MediaColumns.BUCKET_ID,
                    MediaStore.MediaColumns.DATE_MODIFIED
            };

            Cursor cursorExternal = getContentResolver().query(
                    uriExternal,
                    projections,
                    "bucket_id=?",
                    new  String[] { albumId },
                    (MediaStore.MediaColumns.DATE_MODIFIED + " DESC")
            );

            while (cursorExternal.moveToNext()) {
                String bucketId = cursorExternal.getString(cursorExternal.getColumnIndexOrThrow(MediaStore.MediaColumns.BUCKET_ID));
                String album = cursorExternal.getString(cursorExternal.getColumnIndexOrThrow(MediaStore.MediaColumns.BUCKET_DISPLAY_NAME));
                String path = cursorExternal.getString(cursorExternal.getColumnIndexOrThrow(MediaStore.MediaColumns.DATA));
                String timestamp = cursorExternal.getString(cursorExternal.getColumnIndexOrThrow(MediaStore.MediaColumns.DATE_MODIFIED));
                String time = CommonHelper.formatTimestamp(timestamp);
                String count = AlbumHelper.getImageCountInAlbum(getApplicationContext(), bucketId);

                photos.add(AlbumHelper.mapAlbumData(bucketId, album, path, timestamp, time, count));
            }

            cursorExternal.close();

            return "";
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            PhotosAdapter photosAdapter = new PhotosAdapter(PhotosActivity.this, photos);
            gridViewPhotosContainer.setAdapter(photosAdapter);
        }
    }
}