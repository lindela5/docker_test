package com.innowise.darya.dto;

import com.innowise.darya.entity.Book;
import com.innowise.darya.entity.Supplier;
import com.innowise.darya.entity.Supply;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SupplyDTO {

    private Long supplyId;
 /*   private Set<BookDTO> bookSupply;// = new HashSet<>();
    public Set<SupplyDTO> getSupplyDTOSet(Set<Supply> supplyBook) {
        Set<SupplyDTO> supplyDTOSet = new HashSet<>();
        for (Supply supply : supplyBook) {
            bookSupply = new HashSet<>();
            SupplyDTO supplyDTO = new SupplyDTO();
            supplyDTO.setSupplyId(supply.getSupplyId());
            supplyDTO.setSupplier(supply.getSupplier());
            supplyDTO.setSupplyDate(supply.getSupplyDate());
            supplyDTO.setSupplierPrice(supply.getSupplierPrice());
            for (Book book : supply.getBookSupply()) {
                BookDTO bookDTO = new BookDTO();
                bookDTO.setBookId(book.getBookId());
                bookDTO.setBookTitle(book.getTitle());
                bookDTO.setIsbn(book.getIsbn());
                bookDTO.setSection(book.getSection());
                bookDTO.setYearOfIssue(book.getYearOfIssue());
                bookDTO.setPublishingHouse(book.getPublishingHouse());
                bookDTO.setPrice(book.getPrice());
                bookDTO.setStockBalances(book.getStockBalances());
                bookSupply.add(bookDTO);
            }
            supplyDTO.setBookSupply(bookSupply);
            supplyDTOSet.add(supplyDTO);
        }
        return supplyDTOSet;
    }
*/
    private Supplier supplier;
    private LocalDate supplyDate;
    private BigDecimal supplierPrice;

}