package com.jigowatts.soap_client.config;



import com.jigowatts.soap_client.service.CountryClient;
import com.jigowatts.soap_client.service.UserClient;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

@Configuration
public class SoapConfiguration {

    @Bean
    public Jaxb2Marshaller marshaller() {
        var marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("com.jigowatts.soap_client.wsdl");
        return marshaller;
    }

    @Bean
    public CountryClient countryClient(Jaxb2Marshaller marshaller) {
        var client = new CountryClient();
        init(client,marshaller);
        return client;
    }
    
    @Bean
    public UserClient userClient(Jaxb2Marshaller marshaller) {
        var client = new UserClient();
        init(client, marshaller);
        return client;
    }

    private void init(WebServiceGatewaySupport client, Jaxb2Marshaller marshaller){
        client.setDefaultUri("uri");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
    }
}