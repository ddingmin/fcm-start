package ddingmin.fcmstart

import com.google.firebase.messaging.Notification

data class ContentDto(
    val title: String,
    val message: String,
) {
    fun toNotification(): Notification {
        return Notification.builder()
            .setTitle(title)
            .setBody(message)
            .build()
    }
}
