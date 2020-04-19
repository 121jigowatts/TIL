package com.jigowatts.soap_client.service;

import com.jigowatts.soap_client.wsdl.GetUserRequest;
import com.jigowatts.soap_client.wsdl.GetUserResponse;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserClient extends WebServiceGatewaySupport {

    public GetUserResponse getUser(int id) {

        GetUserRequest request = new GetUserRequest();
        request.setId(id);

        log.info("Requesting User ID for {}", Integer.toString(id));
        return (GetUserResponse) getWebServiceTemplate().marshalSendAndReceive("http://localhost:8080/ws/users",
                request);
    }
}