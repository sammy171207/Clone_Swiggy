package spicestory.spicestory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spicestory.spicestory.model.Order;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order,Long> {

    public List<Order> findByCustomerId(Long userId);

    public List<Order>findByRestaurantId(Long restaurantId);


}
