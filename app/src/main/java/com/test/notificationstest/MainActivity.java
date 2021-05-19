package com.test.notificationstest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import static com.test.notificationstest.App.CHANNEL_1_ID;
import static com.test.notificationstest.App.CHANNEL_2_ID;

public class MainActivity extends AppCompatActivity {
    private NotificationManagerCompat notificationManager;
    private EditText editTextTitle;
    private EditText editTextMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        notificationManager = NotificationManagerCompat.from(this);
        editTextTitle = findViewById(R.id.edit_text_title);
        editTextMessage = findViewById(R.id.edit_text_message);
    }
    public void sendOnChannel1(View v) {
        String title = editTextTitle.getText().toString();
        String message = editTextMessage.getText().toString();

        //使用NotificationCompat.Builder對象設置通知內容和渠道
        Notification notification = new NotificationCompat.Builder(this, CHANNEL_1_ID)
                .setSmallIcon(R.drawable.ic_one)//小圖標，這是所必需的唯一用戶可見內容。
                .setContentTitle(title)//標題
                .setContentText(message)//正文文本
                .setPriority(NotificationCompat.PRIORITY_HIGH)//通知優先級，較高priority
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)//通知類別：傳入的直接消息（SMS，即時消息等）
                .build();
        //請記得保存您傳遞到NotificationManagerCompat.notify()的通知ID，因為如果之後您想要更新或移除通知，將需要使用這個ID。
        notificationManager.notify(1, notification);
    }
    public void sendOnChannel2(View v) {
        String title = editTextTitle.getText().toString();
        String message = editTextMessage.getText().toString();
        Notification notification = new NotificationCompat.Builder(this, CHANNEL_2_ID)
                .setSmallIcon(R.drawable.ic_two)
                .setContentTitle(title)
                .setContentText(message)
                .setPriority(NotificationCompat.PRIORITY_LOW)//通知優先級，降低priority，用於不太重要的項目。
                .build();
        notificationManager.notify(2, notification);
    }
}