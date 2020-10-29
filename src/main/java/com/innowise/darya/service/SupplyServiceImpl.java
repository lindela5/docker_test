package com.innowise.darya.service;

import com.innowise.darya.dto.SupplyDTO;
import com.innowise.darya.entity.Supply;
import com.innowise.darya.repositoty.SupplyRepository;
import com.innowise.darya.transformer.SupplyDTOTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class SupplyServiceImpl implements SupplyService {
    @Autowired
    private SupplyRepository supplyRepository;


    @Override
    public SupplyDTO getSupplyById(long id) {
        Optional<Supply> supplyOptional = Optional.ofNullable(supplyRepository.findBySupplyId(id));
        if (!supplyOptional.isPresent()) {
            return null;
        }
        Supply supply = supplyOptional.get();
        SupplyDTO supplyDTO = SupplyDTOTransformer.SUPPLY_DTO_TRANSFORMER.supplyToSupplyDTO(supply);
        return supplyDTO;
    }

}
