package com.innowise.darya.repositoty;

import com.innowise.darya.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepository extends JpaRepository<Sale, String> {
    Sale findBySaleId(Long saleId);
}
