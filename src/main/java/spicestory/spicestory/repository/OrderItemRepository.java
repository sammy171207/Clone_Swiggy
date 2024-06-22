package spicestory.spicestory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spicestory.spicestory.model.OrderItems;

public interface OrderItemRepository extends JpaRepository<OrderItems,Long> {

}
