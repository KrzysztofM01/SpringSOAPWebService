package com.insane;

import com.insane.repositories.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.xml.datatype.DatatypeConfigurationException;

@SpringBootApplication
public class ApiSoapApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiSoapApplication.class, args);
    }
}
