package com.darccide.FreshVue.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;


import lombok.*;

@Entity
@Data
@NoArgsConstructor
public class LineItem {
    
    @EmbeddedId
    @JsonIgnore
    private LineItemPK pk;
    
    @Column(nullable = false)
    private Integer quantity;
    
    
    public LineItem(Cart cart, Item item, Integer quantity) {
        pk = new LineItemPK();
        pk.setCart(cart);
        pk.setItem(item);
        this.quantity = quantity;
    }
    
    @Transient
    public Item getItem() {
        return this.pk.getItem();
    }
    
    @Transient
    public Double getTotalPrice() {
        return getItem().getPrice() * getQuantity();
    }
}

