package com.innowise.darya.service;

import com.innowise.darya.dto.SupplyDTO;
import com.innowise.darya.entity.Supply;
import com.innowise.darya.exception.ThereIsNoSuchException;
import com.innowise.darya.repositoty.SupplyRepository;
import com.innowise.darya.transformer.SupplyDTOTransformer;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class SupplyServiceImpl implements SupplyService {

    private SupplyRepository supplyRepository;

    public SupplyServiceImpl(SupplyRepository supplyRepository) {
        this.supplyRepository = supplyRepository;
    }


    @Override
    public SupplyDTO getSupplyById(long id) {
        Optional<Supply> supply = Optional.ofNullable(supplyRepository.findBySupplyId(id));
        if (!supply.isPresent()) {
            throw new ThereIsNoSuchException("supplier");
        }
       SupplyDTO supplyDTO = SupplyDTOTransformer.SUPPLY_DTO_TRANSFORMER.supplyToSupplyDTO(supply.get());
        return supplyDTO;
    }

    @Override
    public SupplyDTO saveSupply(SupplyDTO supplyDto) {
        Supply savedSupply = supplyRepository.save(SupplyDTOTransformer.SUPPLY_DTO_TRANSFORMER.supplyDTOToSupply(supplyDto));
        return SupplyDTOTransformer.SUPPLY_DTO_TRANSFORMER.supplyToSupplyDTO(savedSupply);
    }

    @Override
    public void deleteSupply(long supplyId) {
        supplyRepository.deleteById(String.valueOf(supplyId));
    }

}
