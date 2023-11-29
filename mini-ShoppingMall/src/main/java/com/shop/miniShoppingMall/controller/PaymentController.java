package com.shop.miniShoppingMall.controller;

import com.shop.miniShoppingMall.service.PaymentService;
import com.siot.IamportRestClient.Iamport;
import com.siot.IamportRestClient.IamportClient;
import com.siot.IamportRestClient.exception.IamportResponseException;
import com.siot.IamportRestClient.response.IamportResponse;
import com.siot.IamportRestClient.response.Payment;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import retrofit2.http.Path;

import java.io.IOException;

@RequiredArgsConstructor
@RestController
public class PaymentController
{
    private final PaymentService paymentService;
    @PostMapping("/validate/{imp_uid}")
    public IamportResponse<Payment> paymentByImpUid(@PathVariable String imp_uid) throws IamportResponseException, IOException {
        return paymentService.paymentByImpUid(imp_uid);
    }

}
