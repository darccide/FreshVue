
package com.darccide.FreshVue.dtos;

import com.darccide.FreshVue.entities.Item;
import javax.persistence.Entity;
import lombok.*;

@Data
@NoArgsConstructor
public class LineItemDto {
    
    private Item item;
    private Integer quantity;
    
}
