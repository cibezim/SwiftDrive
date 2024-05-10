package com.cibezim.swiftdrive.controller;

import com.cibezim.swiftdrive.model.PaymentInfo;
import com.cibezim.swiftdrive.service.PaymentInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payment")
public class PaymentInfoController {

    @Autowired
    private PaymentInfoService paymentInfoService;

    @PostMapping("/add")
    public ResponseEntity<PaymentInfo> addPaymentInfo(@RequestBody PaymentInfo paymentInfo) {
        PaymentInfo newPaymentInfo = paymentInfoService.addPaymentInfo(paymentInfo);
        return new ResponseEntity<>(newPaymentInfo, HttpStatus.CREATED);
    }

    @GetMapping("/{paymentInfoId}")
    public ResponseEntity<PaymentInfo> getPaymentInfoById(@PathVariable Long paymentInfoId) {
        PaymentInfo paymentInfo = paymentInfoService.getPaymentInfoById(paymentInfoId);
        return new ResponseEntity<>(paymentInfo, HttpStatus.OK);
    }

    @DeleteMapping("/{paymentInfoId}")
    public ResponseEntity<Void> deletePaymentInfo(@PathVariable Long paymentInfoId) {
        paymentInfoService.deletePaymentInfo(paymentInfoId);
        return ResponseEntity.noContent().build();
    }
}
