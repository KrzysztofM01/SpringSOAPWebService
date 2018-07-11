import clients.SoapClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public Jaxb2Marshaller countriesMarshaller () {
        Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();
        jaxb2Marshaller.setContextPath("countries");

        return jaxb2Marshaller;
    }

    @Bean
    public SoapClient soapClient (Jaxb2Marshaller countriesMarshaller) {
        SoapClient soapClient = new SoapClient();
        soapClient.setDefaultUri("http://localhost:8080/ws/");
        soapClient.setMarshaller(countriesMarshaller);
        soapClient.setUnmarshaller(countriesMarshaller);

        return soapClient;
    }
}
