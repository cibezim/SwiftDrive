package com.cibezim.swiftdrive.repository;

import com.cibezim.swiftdrive.model.PaymentInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentInfoRepository extends JpaRepository<PaymentInfo, Long> {

}
