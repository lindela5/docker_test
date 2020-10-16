package com.innowise.darya.service;

import com.innowise.darya.entity.Sale;
import com.innowise.darya.repositoty.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class SaleService {
    private SaleRepository saleRepository;

    @Autowired
    public SaleService(SaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }


    public Sale getSaleStats(Long saleId) {
        Sale sale = saleRepository.findBySaleId(saleId);
        /*if (publisher == null) {
            throw new ThereIsNoSuchBookException();
        }
*/
        return sale;
    }
}
