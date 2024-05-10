package com.cibezim.swiftdrive.service;

import com.cibezim.swiftdrive.model.PaymentInfo;
import com.cibezim.swiftdrive.repository.PaymentInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentInfoService {

    @Autowired
    private PaymentInfoRepository paymentInfoRepository;

    public PaymentInfo addPaymentInfo(PaymentInfo paymentInfo) {
        return paymentInfoRepository.save(paymentInfo);
    }

    public PaymentInfo getPaymentInfoById(Long paymentInfoId) {
        return paymentInfoRepository.findById(paymentInfoId)
                .orElseThrow(() -> new RuntimeException("Payment info not found"));
    }

    public void deletePaymentInfo(Long paymentInfoId) {
        PaymentInfo paymentInfoToDelete = paymentInfoRepository.findById(paymentInfoId)
                .orElseThrow(() -> new RuntimeException("Payment info not found"));

        paymentInfoRepository.delete(paymentInfoToDelete);
    }
}
