package com.shop.miniShoppingMall.service;

import com.shop.miniShoppingMall.dto.PaymentDTO;
import com.shop.miniShoppingMall.model.PrePaymentEntity;
import com.shop.miniShoppingMall.repository.PrePaymentRepository;
import com.siot.IamportRestClient.IamportClient;
import com.siot.IamportRestClient.exception.IamportResponseException;
import com.siot.IamportRestClient.request.CancelData;
import com.siot.IamportRestClient.request.PrepareData;
import com.siot.IamportRestClient.response.IamportResponse;
import com.siot.IamportRestClient.response.Payment;
import com.siot.IamportRestClient.response.Prepare;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;

@Service
public class PaymentService {
    private IamportClient api;

    @Autowired
    private PrePaymentRepository prePaymentRepository;

    public PaymentService() {
        this.api = new IamportClient("3115700882811884", "NM6GhDNvzDPhrrVXbf1wE2NFDOCDnIg6WvR7HLIa3yNy6MYGY9xRLJ6KuYKl4ZM6OaZMOl3vWFtAWdKC");
    }

    public void postPrepare(PrePaymentEntity request) throws IamportResponseException, IOException {
        PrepareData prepareData = new PrepareData(request.getMerchant_uid(), request.getAmount());
        api.postPrepare(prepareData);

        prePaymentRepository.save(request);
    }

    public Payment validatePayment(PaymentDTO request) throws IamportResponseException, IOException {
        PrePaymentEntity prePayment = prePaymentRepository.findById(request.getMerchant_uid()).orElseThrow();
        BigDecimal preAmount = prePayment.getAmount();
        IamportResponse<Payment> iamportResponse = api.paymentByImpUid(request.getImp_uid());
        BigDecimal paidAmount = iamportResponse.getResponse().getAmount(); // 사용자가 결제한 금액

        if (!preAmount.equals(paidAmount)) {
            CancelData cancelData = cancelPayment(iamportResponse);
            api.cancelPaymentByImpUid(cancelData);
        }

        return iamportResponse.getResponse();
    }

`    public CancelData cancelPayment(IamportResponse<Payment> response) {
        return new CancelData(response.getResponse().getImpUid(), true);
    }`

}
