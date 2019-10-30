
package com.darccide.FreshVue.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.Valid;

import lombok.*;

@Entity
@Data
@NoArgsConstructor
public class Cart {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartId;
    
    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column(nullable = false)
    private LocalDate cartDate;
    
    @Column(nullable = false)
    private String cartStatus;
    
    @JsonManagedReference
    @OneToMany(mappedBy = "pk.cart")
    @Valid
    private List<LineItem> lineItems = new ArrayList<>();
    
    @Transient
    public Double getTotalOrderPrice() {
        double total = 0D;
        List<LineItem> lineItems = getLineItems();
        for (LineItem li : lineItems) {
            total += li.getTotalPrice();
        }
        return total;
    }
    
    @Transient
    public int getNumberOfItems() {
        return this.lineItems.size();
    }
}