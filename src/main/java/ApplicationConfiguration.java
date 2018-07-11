import clients.SoapClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public Jaxb2Marshaller usersMarshaller() {
        Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();
        jaxb2Marshaller.setContextPath("users");

        return jaxb2Marshaller;
    }

    @Bean
    public SoapClient soapClient (Jaxb2Marshaller usersMarshaller) {
        SoapClient soapClient = new SoapClient();
        soapClient.setDefaultUri("http://localhost:8080/ws/");
        soapClient.setMarshaller(usersMarshaller);
        soapClient.setUnmarshaller(usersMarshaller);

        return soapClient;
    }
}
