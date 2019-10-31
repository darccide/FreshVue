
package com.darccide.FreshVue.dtos;

import com.darccide.FreshVue.entities.Item;

public class LineItemDto {
    
    public Item item;
    public Integer quantity;

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    
    
}
