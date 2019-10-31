
package com.darccide.FreshVue.controllers;

import com.darccide.FreshVue.dtos.LineItemDto;
import com.darccide.FreshVue.entities.Cart;
import com.darccide.FreshVue.entities.CartStatus;
import com.darccide.FreshVue.entities.LineItem;
import com.darccide.FreshVue.exceptions.ResourceNotFoundException;
import com.darccide.FreshVue.services.CartService;
import com.darccide.FreshVue.services.ItemService;
import com.darccide.FreshVue.services.LineItemService;
import java.util.ArrayList;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import javax.validation.constraints.NotNull;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/carts")
public class CartController {
    
    ItemService itemService;
    CartService cartService;
    LineItemService lineItemService;
    
    public CartController(ItemService itemService, CartService cartService, LineItemService lineItemService) {
        this.itemService = itemService;
        this.cartService = cartService;
        this.lineItemService = lineItemService;
    }
    
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public @NotNull Iterable<Cart> list() {
        return this.cartService.findAll();
    }
    
    @PostMapping
    public ResponseEntity<Cart> create(@RequestBody CartForm form) {
        List<LineItemDto> formDtos = form.getLineItems();
        validateItemsExistence(formDtos);
        Cart cart = new Cart();
        cart.setCartStatus(CartStatus.PAID.name());
        cart = this.cartService.create(cart);
        
        List<LineItem> lineItems = new ArrayList<>();
        for (LineItemDto dto : formDtos) {
            lineItems.add(lineItemService
                    .save(new LineItem(cart, 
                            itemService.findById(dto
                                    .getItem()
                                    .getItemId()), dto.getQuantity())));
        }
        
        cart.setLineItems(lineItems);
        
        this.cartService.update(cart);
        
        String uri = ServletUriComponentsBuilder
                .fromCurrentServletMapping()
                .path("/cart/{cartId}")
                .buildAndExpand(cart.getCartId())
                .toString();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", uri);
        
        return new ResponseEntity<>(cart, headers, HttpStatus.CREATED);
    }
    
    private void validateItemsExistence(List<LineItemDto> lineItems) {
        List<LineItemDto> list = lineItems
                .stream()
                .filter(li -> Objects.isNull(itemService.findById(li
                        .getItem()
                        .getItemId())))
                .collect(Collectors.toList());
        if (!CollectionUtils.isEmpty(list)) {
            new ResourceNotFoundException("Item not found");
        }
    }
    
    public static class CartForm {
        private List<LineItemDto> lineItems;

        public List<LineItemDto> getLineItems() {
            return lineItems;
        }

        public void setLineItems(List<LineItemDto> lineItems) {
            this.lineItems = lineItems;
        }
    }
}
