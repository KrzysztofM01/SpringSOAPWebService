import clients.SoapClient;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import users.GetUserResponse;
import users.User;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
        SoapClient soapClient = context.getBean(SoapClient.class);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Insert name of user: ");
        GetUserResponse getCountryResponse = soapClient.getUserResponse(scanner.nextLine());
        User user = getCountryResponse.getUser();
        System.out.println("\nName: " + user.getName()
                + "\nAge: " + user.getAge() + "\nBirthday: " + user.getBirthday().getDay() + "." +
                user.getBirthday().getMonth() + "\nFrom: " + user.getFrom()
                + "\nPhone: " + user.getPhone() + "\nType of subscription: " + user.getTypeOfSubscription());
    }
}
