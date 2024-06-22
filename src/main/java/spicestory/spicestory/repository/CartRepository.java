package spicestory.spicestory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spicestory.spicestory.model.Cart;

public interface CartRepository extends JpaRepository<Cart,Long> {

    public Cart findByCustomerId(Long userId);



}
