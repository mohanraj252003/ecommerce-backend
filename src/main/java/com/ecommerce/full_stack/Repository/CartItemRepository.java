package com.ecommerce.full_stack.Repository;

import com.ecommerce.full_stack.Entity.CartItem;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CartItemRepository extends MongoRepository<CartItem,Integer> {
}
