package com.septovan.pam.pam_gallery.helper;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Build;
import android.util.DisplayMetrics;

import androidx.core.app.ActivityCompat;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CommonHelper {

    // has the user grant the permission?
    public static boolean hasPermission(Context context, String[] permissions) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && context != null && permissions != null) {
            for (String permission : permissions) {
                if (ActivityCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) {
                    return false;
                }
            }
        }

        return true;
    }

    // Convert DP to PX
    public static float convertDpToPx(float dp, Context context) {
        Resources resources = context.getResources();
        DisplayMetrics diisplayMetrics = resources.getDisplayMetrics();

        float px = dp * (diisplayMetrics.densityDpi / 160f);

        return px;
    }

    // Convert Timestamp to Normal Format
    // e.g. Timestamp = 1500002336800
    // e.g. Normal Format = 08 April 2022 13.00
    public static String formatTimestamp(String timestamp) {
        long datetime = Long.parseLong(timestamp);
        Date date = new Date(datetime);
        DateFormat dateFormat = new SimpleDateFormat("dd/MM HH:mm");

        return dateFormat.format(date);
    }

}
