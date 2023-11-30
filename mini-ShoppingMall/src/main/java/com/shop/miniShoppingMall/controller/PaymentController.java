package com.shop.miniShoppingMall.controller;

import com.shop.miniShoppingMall.dto.PaymentDTO;
import com.shop.miniShoppingMall.model.PrePaymentEntity;
import com.shop.miniShoppingMall.service.PaymentService;
import com.siot.IamportRestClient.Iamport;
import com.siot.IamportRestClient.IamportClient;
import com.siot.IamportRestClient.exception.IamportResponseException;
import com.siot.IamportRestClient.request.PrepareData;
import com.siot.IamportRestClient.response.IamportResponse;
import com.siot.IamportRestClient.response.Payment;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import retrofit2.http.Path;

import java.io.IOException;
import java.math.BigDecimal;

@RequiredArgsConstructor
@RestController
public class PaymentController
{
    private final PaymentService paymentService;

    @PostMapping("/payment/prepare")
    public void preparePayment(@RequestBody PrePaymentEntity request) throws IamportResponseException, IOException {
        paymentService.postPrepare(request);
    }

    @PostMapping("/payment/validate")
    public Payment validatePayment(@RequestBody PaymentDTO request) throws IamportResponseException, IOException {
        return paymentService.validatePayment(request);
    }

}
