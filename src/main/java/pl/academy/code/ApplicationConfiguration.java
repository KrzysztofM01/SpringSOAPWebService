package pl.academy.code;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@Configuration
@EnableWs
public class ApplicationConfiguration extends WsConfigurerAdapter {
    private static final String NAMESPACE_URL = "http://code.academy.pl/countries/";

    @Bean
    public ServletRegistrationBean messageDispatcherServlet (ApplicationContext applicationContext) {
        MessageDispatcherServlet messageDispatcherServlet = new MessageDispatcherServlet();
        messageDispatcherServlet.setApplicationContext(applicationContext);
        messageDispatcherServlet.setTransformSchemaLocations(true);

        return new ServletRegistrationBean(messageDispatcherServlet, "/ws/*");
    }

    @Bean (name = "countries")
    public DefaultWsdl11Definition defaultWsdl11Definition (XsdSchema countriesSchema) {

        DefaultWsdl11Definition defaultWsdl11Definition = new DefaultWsdl11Definition();
        defaultWsdl11Definition.setPortTypeName("CountriesPort");
        defaultWsdl11Definition.setLocationUri("/ws");
        defaultWsdl11Definition.setTargetNamespace(NAMESPACE_URL);
        defaultWsdl11Definition.setSchema(countriesSchema);

        return defaultWsdl11Definition;
    }

    @Bean
    XsdSchema countriesSchema() {
        return new SimpleXsdSchema(new ClassPathResource("static/country.xsd"));
    }

}
