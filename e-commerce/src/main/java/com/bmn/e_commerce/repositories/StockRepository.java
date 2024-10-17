package com.bmn.e_commerce.repositories;

import com.bmn.e_commerce.models.Stock;
import com.bmn.e_commerce.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {
}
