package com.innowise.darya.service;

import com.innowise.darya.dto.SupplyDTO;
import com.innowise.darya.entity.Supply;
import com.innowise.darya.exception.ThereIsNoSuchException;
import com.innowise.darya.repositoty.BookRepository;
import com.innowise.darya.repositoty.SupplyRepository;
import com.innowise.darya.transformer.SupplyDTOTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class SupplyService {
    private SupplyRepository supplyRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    public SupplyService(SupplyRepository supplyRepository) {
        this.supplyRepository = supplyRepository;
    }

    public Supply getSupplyStats(Long supplyId) {
        Supply supply = supplyRepository.findBySupplyId(supplyId);
        if (supply == null) {
            throw new ThereIsNoSuchException("supply");
        }
        return supply;
    }

    public SupplyDTO getSupplyById(long id) {
        Optional<Supply> supplyOptional = Optional.ofNullable(supplyRepository.findBySupplyId(id));
        if (!supplyOptional.isPresent()){
            return null;
        }
        Supply supply = supplyOptional.get();
        SupplyDTO supplyDTO = SupplyDTOTransformer.SUPPLY_DTO_TRANSFORMER.supplyToSupplyDTO(supply);
        return supplyDTO;
    }


}
