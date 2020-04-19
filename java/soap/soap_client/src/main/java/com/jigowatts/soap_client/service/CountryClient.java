package com.jigowatts.soap_client.service;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import lombok.extern.slf4j.Slf4j;

import com.jigowatts.soap_client.wsdl.GetCountryRequest;
import com.jigowatts.soap_client.wsdl.GetCountryResponse;

@Slf4j
public class CountryClient extends WebServiceGatewaySupport {

  public GetCountryResponse getCountry(String country) {

    GetCountryRequest request = new GetCountryRequest();
    request.setName(country);

    log.info("Requesting location for {}", country);

    return (GetCountryResponse) getWebServiceTemplate().marshalSendAndReceive("http://localhost:8080/ws/countries",
        request, new SoapActionCallback("http://jigowatts.com/soap_server/GetCountryRequest"));
  }

}