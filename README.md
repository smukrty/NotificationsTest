# NotificationsTest
Notification通知
#
第1部分
我們將從創建通知通道（類別）開始，這是自Android Oreo（API級別26）以來必須能夠顯示任何通知的通道。

這些通道應在啟動應用程序後立即創建，因此我們將在擴展Application的類的onCreate方法中進行創建。

創建這些渠道時，我們必須傳遞一個ID，一個名稱和一個重要級別。

此外，我們可以進一步自定義通道，例如啟用LED、激活振動或更改聲音，但是用戶可以完全控制通道的行為。

創建我們的NotificationChannel對象時，我們將它們傳遞給NotificationManager的createNotificationChannel方法。

想要顯示通知時，可以使用NotificationCompat.Builder創建通知，在其中可以設置標題、消息、圖標、優先級、類別和更多自定義選項、然後傳遞此
Notification對象到NotificationManagerCompat的notify方法中，必須傳遞一個ID，以後可以使用它來更新或取消此特定通知。
文檔：

NotificationManager：

developer.android.com/reference/android/app/NotificationManager

NotificationChannel：

developer.android.com/reference/android/app/NotificationChannel
NotificationCompat：

developer.android.com/reference/android/support/v4/app/ NotificationCompat

NotificationCompat.Builder：

developer.android.com/reference/android/support/v4/app/NotificationCompat.Builder
#
