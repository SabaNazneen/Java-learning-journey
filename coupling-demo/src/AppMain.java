import loose.EmailNotification;
import loose.NotificationService;
import tight.UserService;

public class AppMain {
    static void main() {
        NotificationService emailService = new EmailNotification();
        UserService userService = new UserService();
        userService.notifyUser("Hello World");
        loose.UserService userService1 =new loose.UserService(emailService);
        userService1.notifyUser("Order process");

    }
}
