package com.e_commerce_project.orderservice.RestTemplateConfigs;

import com.e_commerce_project.orderservice.Records.PurchaseRequest;
import com.e_commerce_project.orderservice.Records.PurchaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductClient {

    @Value("${application.product-url}")
    private String productUrl;

    private final RestTemplate restTemplate;

    public List<PurchaseResponse> purchaseResponse(List<PurchaseRequest> requestList) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<List<PurchaseRequest>> entity = new HttpEntity<>(requestList, headers);

        ParameterizedTypeReference<List<PurchaseResponse>> responseType =
                new ParameterizedTypeReference<>() {};

        ResponseEntity<List<PurchaseResponse>> responseEntity =
                restTemplate.exchange(productUrl + "/purchaseProduct", HttpMethod.POST, entity, responseType);

        if (responseEntity.getStatusCode().isError()) {
            throw new RuntimeException("Product service is not available. Status: " + responseEntity.getStatusCode());
        }

        return responseEntity.getBody();
    }
}
