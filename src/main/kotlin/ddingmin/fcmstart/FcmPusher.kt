package ddingmin.fcmstart

import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.Message
import org.springframework.stereotype.Component

@Component
class FcmPusher(
    private val fcmClient: FirebaseMessaging,
) {
    fun send(
        deviceToken: String,
        content: ContentDto,
    ) {
        val message = Message.builder()
            .setNotification(content.toNotification())
            .setToken(deviceToken)
            .build()

        fcmClient.send(message)
    }

    fun sendAll(
        deviceTokens: List<String>,
        content: ContentDto,
    ) {
        val messages = deviceTokens.map { deviceToken ->
            Message.builder()
                .setNotification(content.toNotification())
                .setToken(deviceToken)
                .build()
        }

        fcmClient.sendEach(messages)
    }
}
