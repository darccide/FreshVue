
package com.darccide.FreshVue.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.*;

@Entity
@Data
@RequiredArgsConstructor
public class Item {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemId;
    
    @NotBlank(message = "Item name must not be blank.")
    @Size(max = 40, message = "Item name must be less than 40 characters.")
    private String itemName;
    
    @Column(nullable = false)
    private Double price;
    
    @Min(1)
    @Max(250)
    @Column(nullable = false)
    private int inventory;
    
    @Size(max = 1000, message = "Image must be less than 1000 characters.")
    private String image;
    
    @Size(max = 3000, 
            message = "Item description must be less than 3000 characters.")
    private String itemDescription;
}
