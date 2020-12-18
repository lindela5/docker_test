package com.innowise.darya.controller;

import com.innowise.darya.dto.SupplyDTO;
import com.innowise.darya.service.SupplyService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/supply")
@Log
public class SupplyController {
    private SupplyService supplyService;

    @Autowired
    public SupplyController(SupplyService supplyService) {
        this.supplyService = supplyService;
    }


    @GetMapping("/getbyid/{id}")
    public SupplyDTO getSupplyById(@PathVariable long id){
        return supplyService.getSupplyById(id);
    }

    @PostMapping("/save")
    public SupplyDTO saveSupply(@RequestBody SupplyDTO supplyDto) {
        log.info("Handling save users: " + supplyDto);
        return supplyService.saveSupply(supplyDto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteSupply(@PathVariable String id) {
        log.info("Handling delete user request: " + id);
        supplyService.deleteSupply(Long.valueOf(id));
        return ResponseEntity.ok().build();
    }


}

