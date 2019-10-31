
package com.darccide.FreshVue.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.Valid;

import lombok.*;

@Entity
@Data
@NoArgsConstructor
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="lineItems")
public class Cart {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartId;
    
    @JsonFormat(pattern = "MM/dd/yyyy")
    @Column(nullable = false)
    private LocalDate cartDate;
    
    @Column(nullable = false)
    private String cartStatus;
    
    @OneToMany(mappedBy = "pk.cart")
    @Valid
    private List<LineItem> lineItems = new ArrayList<>();
    
    @Transient
    public BigDecimal getTotalAmount() {
        double total = 0D;
        List<LineItem> lineItems = getLineItems();
        for (LineItem li : lineItems) {
            total += li.getTotalPrice();
        }
        String totalString = Double.toString(total);
        BigDecimal totalBD = new BigDecimal(totalString);
        totalBD = totalBD.setScale(2, BigDecimal.ROUND_HALF_UP);
        
        return totalBD;
    }
    
    @Transient
    public int getNumberOfItems() {
        return this.lineItems.size();
    }
}