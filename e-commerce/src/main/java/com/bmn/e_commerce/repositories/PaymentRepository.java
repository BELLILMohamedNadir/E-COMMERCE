package com.bmn.e_commerce.repositories;

import com.bmn.e_commerce.models.Payment;
import com.bmn.e_commerce.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
