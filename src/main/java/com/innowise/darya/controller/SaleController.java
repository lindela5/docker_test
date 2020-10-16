package com.innowise.darya.controller;

import com.innowise.darya.dto.SaleDTO;
import com.innowise.darya.entity.Sale;
import com.innowise.darya.service.SaleService;
import com.innowise.darya.transformer.SaleDTOTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/sale")
public class SaleController {
    private SaleService saleService;

    @Autowired
    public SaleController(SaleService saleService) {
        this.saleService = saleService;
    }

    @GetMapping(value = "{saleId}", produces = MediaType.APPLICATION_JSON_VALUE)


    public ResponseEntity<SaleDTO> getSaleStats(@PathVariable final Long saleId) {
        Sale sale = saleService.getSaleStats(saleId);
        SaleDTO saleDTO = SaleDTOTransformer.SALE_DTO_TRANSFORMER.saleToSaleDTO(sale);
        return ResponseEntity.ok(saleDTO);
    }
}
