
package com.darccide.FreshVue.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.*;

@Embeddable
@Data
@NoArgsConstructor
public class LineItemPK implements Serializable {
    
    @JsonBackReference
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "cartId")
    private Cart cart;
    
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "itemId")
    private Item item;
}
