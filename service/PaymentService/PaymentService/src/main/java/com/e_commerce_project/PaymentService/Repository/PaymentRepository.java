package com.e_commerce_project.PaymentService.Repository;

import com.e_commerce_project.PaymentService.Entity.Payment;
import com.e_commerce_project.PaymentService.Records.PaymentRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment,Long> {


}
