package com.shop.miniShoppingMall.service;

import com.siot.IamportRestClient.IamportClient;
import com.siot.IamportRestClient.exception.IamportResponseException;
import com.siot.IamportRestClient.response.IamportResponse;
import com.siot.IamportRestClient.response.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class PaymentService {
    private IamportClient api;

    public PaymentService() {
        this.api = new IamportClient("3115700882811884", "NM6GhDNvzDPhrrVXbf1wE2NFDOCDnIg6WvR7HLIa3yNy6MYGY9xRLJ6KuYKl4ZM6OaZMOl3vWFtAWdKC");
    }

    public IamportResponse<Payment> paymentByImpUid(String imp_uid) throws IamportResponseException, IOException {
        return api.paymentByImpUid(imp_uid);
    }

}
