package dev.chytac.map.notification;

import android.Manifest;
import android.app.Activity;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;

import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;

import java.time.format.DateTimeFormatterBuilder;

import dev.chytac.map.R;
import dev.chytac.map.entities.LineEntity;

public class NotificationAppManager {

    private final NotificationManager notificationManager;
    private final Context context;

    private static final int NOTIFICATION_PERMISSION_REQUEST_CODE = 24;

    public NotificationAppManager(NotificationManager notificationManager, Context context) {
        this.notificationManager = notificationManager;
        this.context = context;
    }

    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == NOTIFICATION_PERMISSION_REQUEST_CODE) {
            NotificationChannel channel = new NotificationChannel("PIN_DEPARTURE", "Pin departure", NotificationManager.IMPORTANCE_DEFAULT);
            notificationManager.createNotificationChannel(channel);
        }
    }

    public void showDepartureNotification(int id, LineEntity line) {
        String departureTimeString = line.getDeparture().format(new DateTimeFormatterBuilder().appendPattern("HH:mm").toFormatter());

        if (!notificationManager.areNotificationsEnabled())
            requestPermission();

        NotificationCompat.Builder notification = new NotificationCompat.Builder(context, "PIN_DEPARTURE")
                .setSmallIcon(R.drawable.pid)
                .setContentTitle(line.getType() + " - " + line.getName() +  " " + line.getFinalStation())
                .setContentText("Přijede v " + departureTimeString)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        notificationManager.notify(id, notification.build());
    }

    private void requestPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU)
            ActivityCompat.requestPermissions((Activity) context, new String[]{Manifest.permission.POST_NOTIFICATIONS}, NOTIFICATION_PERMISSION_REQUEST_CODE);
    }
}
