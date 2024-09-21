import java.util.Scanner;

public class FactoryPatternDemo {
    public static void main(String[] args) {
        NotificationFactory notificationFactory = new NotificationFactory();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the type of notification (sms, email, push): ");
        String input = scanner.nextLine();

        try {
            Notification notification = notificationFactory.createNotification(input);
            notification.notifyUser();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
