package com.jigowatts.soap_client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.jigowatts.soap_client.wsdl.GetCountryRequest;
import com.jigowatts.soap_client.wsdl.GetCountryResponse;

public class CountryClient extends WebServiceGatewaySupport {

  private static final Logger log = LoggerFactory.getLogger(CountryClient.class);

  public GetCountryResponse getCountry(String country) {

    GetCountryRequest request = new GetCountryRequest();
    request.setName(country);

    log.info("Requesting location for {}", country);

    return (GetCountryResponse) getWebServiceTemplate().marshalSendAndReceive("http://localhost:8080/ws/countries",
        request, new SoapActionCallback("http://jigowatts.com/soap_server/GetCountryRequest"));
  }

}