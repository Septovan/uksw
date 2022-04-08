package com.septovan.pam.pam_gallery;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.ContentUris;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.MergeCursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.septovan.pam.pam_gallery.helper.AlbumHelper;
import com.septovan.pam.pam_gallery.helper.CommonHelper;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private GridView gridViewAlbumContainer;
    private static final int REQ_PERMISSION_RW_STORAGE_CODE = 1;
    ArrayList<HashMap<String, String>> albums = new ArrayList<>();
    LoadAlbumTask loadAlbumTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridViewAlbumContainer = findViewById(R.id.gridView_album_container);

        // Permission
        String[] permissions = { Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE };
        if (!CommonHelper.hasPermission(this, permissions)) {
            ActivityCompat.requestPermissions(this, permissions, REQ_PERMISSION_RW_STORAGE_CODE);
        }

        // Gridview Item Column Width
        int iDisplayWidth = getResources().getDisplayMetrics().widthPixels;
        Resources resources = getApplicationContext().getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        float dp = iDisplayWidth / (displayMetrics.densityDpi / 160f);
        if (dp < 360) {
            dp = (dp - 17) / 2;
            float px = CommonHelper.convertDpToPx(dp, getApplicationContext());
            gridViewAlbumContainer.setColumnWidth(Math.round(px));
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case REQ_PERMISSION_RW_STORAGE_CODE: {
                    if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                        loadAlbumTask = new LoadAlbumTask();
                        loadAlbumTask.execute();
                    }
                    else {
                        Toast.makeText(this, "This app needs you to allow some permissions to work properly", Toast.LENGTH_SHORT).show();
                    }
                }
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        // Permission
        String[] permissions = { Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE };
        if (!CommonHelper.hasPermission(this, permissions)) {
            ActivityCompat.requestPermissions(this, permissions, REQ_PERMISSION_RW_STORAGE_CODE);
        }
        else {
            loadAlbumTask = new LoadAlbumTask();
            loadAlbumTask.execute();
        }
    }

    class LoadAlbumTask extends AsyncTask<String, Void, String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            albums.clear();
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
                    null,
                    null,
                    (MediaStore.MediaColumns.BUCKET_DISPLAY_NAME + " ASC")
            );

            String currentBucketId = "";
            while (cursorExternal.moveToNext()) {
                String bucketId = cursorExternal.getString(cursorExternal.getColumnIndexOrThrow(MediaStore.MediaColumns.BUCKET_ID));

                if (!currentBucketId.equals(bucketId)) {
                    String album = cursorExternal.getString(cursorExternal.getColumnIndexOrThrow(MediaStore.MediaColumns.BUCKET_DISPLAY_NAME));
                    String path = cursorExternal.getString(cursorExternal.getColumnIndexOrThrow(MediaStore.MediaColumns.DATA));
                    String timestamp = cursorExternal.getString(cursorExternal.getColumnIndexOrThrow(MediaStore.MediaColumns.DATE_MODIFIED));
                    String time = CommonHelper.formatTimestamp(timestamp);
                    String count = AlbumHelper.getImageCountInAlbum(getApplicationContext(), bucketId);

                    albums.add(AlbumHelper.mapAlbumData(bucketId, album, path, timestamp, time, count));
                    currentBucketId = bucketId;
                }
            }

            cursorExternal.close();

            return "";
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            AlbumAdapter albumAdapter = new AlbumAdapter(MainActivity.this, albums);
            gridViewAlbumContainer.setAdapter(albumAdapter);

            gridViewAlbumContainer.setOnItemClickListener((adapterView, view, i, l) -> {
                Intent intentToPhotosActivity = new Intent(MainActivity.this, PhotosActivity.class);
                intentToPhotosActivity.putExtra("albumId", albums.get(i).get(AlbumHelper.KEY_ID));
                intentToPhotosActivity.putExtra("albumTitle", albums.get(i).get(AlbumHelper.KEY_ALBUM));
                startActivity(intentToPhotosActivity);
            });
        }
    }
}