
package com.darccide.FreshVue.services;

import com.darccide.FreshVue.entities.LineItem;
import com.darccide.FreshVue.repositories.LineItemRepository;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LineItemService {
    
    private final LineItemRepository lineItemRepository;
    
    public LineItem save(LineItem lineItem) {
        return lineItemRepository.save(lineItem);
    }
}
