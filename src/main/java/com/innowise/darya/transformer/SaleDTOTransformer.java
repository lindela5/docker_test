package com.innowise.darya.transformer;

import com.innowise.darya.dto.SaleDTO;
import com.innowise.darya.entity.Sale;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Mapper
public interface SaleDTOTransformer {
    SaleDTOTransformer SALE_DTO_TRANSFORMER = Mappers.getMapper(SaleDTOTransformer.class);

    @Mappings({
            @Mapping(target = "saleId", source = "entity.saleId"),
            @Mapping(target = "bookEntity", source = "entity.bookEntity"),
            @Mapping(target = "customer", source = "entity.customer"),
            @Mapping(target = "saleDate", source = "entity.saleDate"),
            @Mapping(target = "quantity", source = "entity.quantity"),
            @Mapping(target = "amount", source = "entity.amount")
    })
    SaleDTO saleToSaleDTO(Sale entity);

    @InheritInverseConfiguration
        //Аннотация определяет, что обратное отображение @InheritInverseConfiguration должно быть выполнено.
    Sale SaleDTOToSale(SaleDTO dto);
}
