package spicestory.spicestory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spicestory.spicestory.model.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem,Long> {

}
