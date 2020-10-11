package com.silver.springbootsoapdemo.endpoint;

import com.silver.springbootsoapdemo.loaneligibility.Acknowledgement;
import com.silver.springbootsoapdemo.loaneligibility.CustomerRequest;
import com.silver.springbootsoapdemo.service.LoanEligibilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;



@Endpoint
public class LoanEligibilityIndicatorEndpoint {

    private static final String NAMESPACE = "http://www.silver.com/springbootsoapdemo/loanEligibility";
    @Autowired
    private LoanEligibilityService service;

    @PayloadRoot(namespace = NAMESPACE, localPart = "CustomerRequest")
    @ResponsePayload
    public Acknowledgement getLoanStatus(@RequestPayload CustomerRequest request) {
        return service.checkLoanEligibility(request);
    }

}
