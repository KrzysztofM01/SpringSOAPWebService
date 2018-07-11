import clients.SoapClient;
import countries.GetCountryResponse;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
        SoapClient soapClient = context.getBean(SoapClient.class);
        GetCountryResponse getCountryResponse = soapClient.getCountryResponse("France");
        System.out.println(getCountryResponse.getCountry().toString());
    }
}
