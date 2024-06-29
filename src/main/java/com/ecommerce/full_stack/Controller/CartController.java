package com.ecommerce.full_stack.Controller;

import com.ecommerce.full_stack.Entity.CartItem;
import com.ecommerce.full_stack.Service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
//@CrossOrigin(origins = "http://localhost:3000")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("/add")
    public List<CartItem> addCartItem(@RequestBody CartItem item) {
        return cartService.addCartItem(item);
    }

    @PutMapping("/{id}")
    public List<CartItem> updateCartItem(@PathVariable int id, @RequestBody CartItem updatedItem) {
        return cartService.updateCartItem(id, updatedItem);
    }

    @DeleteMapping("/{id}")
    public List<CartItem> removeCartItem(@PathVariable int id) {
        return cartService.removeCartItem(id);
    }

    @GetMapping
    public List<CartItem> getCart() {
        return cartService.getCart();
    }
}
