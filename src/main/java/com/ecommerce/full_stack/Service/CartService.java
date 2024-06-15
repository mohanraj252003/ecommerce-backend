package com.ecommerce.full_stack.Service;

import com.ecommerce.full_stack.Entity.CartItem;
import com.ecommerce.full_stack.Repository.CartItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {
    @Autowired
    private CartItemRepository cartItemRepository;

    // Add a new cart item to the repository
    public List<CartItem> addCartItem(CartItem item) {
        item.setSub_total(item.getQty() * item.getPrice());
        cartItemRepository.save(item);
        return cartItemRepository.findAll();
    }

    // Update an existing cart item in the repository
    public List<CartItem> updateCartItem(int id, @RequestBody CartItem updatedItem) {
        Optional<CartItem> existingItemOptional = cartItemRepository.findById(id);
        if (existingItemOptional.isPresent()) {
            CartItem existingItem = existingItemOptional.get();
            existingItem.setQty(updatedItem.getQty()); // Update quantity directly
            existingItem.setPrice(updatedItem.getPrice()); // Update price if needed
            existingItem.setSub_total(existingItem.getQty() * existingItem.getPrice()); // Recalculate sub_total
            cartItemRepository.save(existingItem);
        }
        return cartItemRepository.findAll();
    }

    // Remove a cart item from the repository
    public List<CartItem> removeCartItem(int id) {
        cartItemRepository.deleteById(id);
        return cartItemRepository.findAll();
    }

    // Retrieve all cart items from the repository
    public List<CartItem> getCart() {
        return cartItemRepository.findAll();
    }
}
