package com.innowise.darya.controller;

import com.innowise.darya.dto.SupplyDTO;
import com.innowise.darya.entity.Supply;
import com.innowise.darya.repositoty.SupplyRepository;
import com.innowise.darya.service.SupplyService;
import com.innowise.darya.transformer.SupplyDTOTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping(path = "/supply")
public class SupplyController {
    private SupplyService supplyService;

    @Autowired
    public SupplyController(SupplyService supplyService) {
        this.supplyService = supplyService;
    }


    @GetMapping(value = "{supplyId}", produces = MediaType.APPLICATION_JSON_VALUE)


   public ResponseEntity<SupplyDTO> getSupplyStats(@PathVariable final Long supplyId) {
        Supply supply = supplyService.getSupplyStats(supplyId);
        SupplyDTO supplyDTO = SupplyDTOTransformer.SUPPLY_DTO_TRANSFORMER.supplyToSupplyDTO(supply);
        return ResponseEntity.ok(supplyDTO);
    }

}

