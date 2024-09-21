import java.util.logging.Logger;

public class NotificationFactory {
    private static final Logger logger = Logger.getLogger(NotificationFactory.class.getName());

    public Notification createNotification(String channel) {
        logger.info("NotificationFactory: Creating notification for channel - " + channel);
        
        if (channel == null || channel.isEmpty()) {
            throw new IllegalArgumentException("Notification channel cannot be null or empty");
        }

        switch (channel.toLowerCase()) {
            case "sms":
                return new SMSNotification();
            case "email":
                return new EmailNotification();
            case "push":
                return new PushNotification();
            default:
                throw new IllegalArgumentException("Unknown notification channel: " + channel);
        }
    }
}
