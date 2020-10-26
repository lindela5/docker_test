package com.innowise.darya.service;

import com.innowise.darya.entity.Supply;
import com.innowise.darya.exception.ThereIsNoSuchException;
import com.innowise.darya.repositoty.SupplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class SupplyService {
    private SupplyRepository supplyRepository;

    @Autowired
    public SupplyService(SupplyRepository supplyRepository) {
        this.supplyRepository = supplyRepository;
    }


    public Supply getSupplyStats(Long supplyId) {
        Supply supply = supplyRepository.findBySupplyId(supplyId);
        if (supply == null) {
            throw new ThereIsNoSuchException();
        }
        return supply;
    }
}
