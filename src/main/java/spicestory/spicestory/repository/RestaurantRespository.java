package spicestory.spicestory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import spicestory.spicestory.model.Restaurant;

import java.util.List;

public interface RestaurantRespository extends JpaRepository<Restaurant,Long> {
 @Query("SELECT r FROM Restaurant r WHERE lower(r.name)LIKE lower(concat('%',:query,'%'))"
         +"OR lower(r.cusineType) LIKE lower(concat('%',:query,'%')")


    List<Restaurant> findbySearchQuery(String query);
    Restaurant findByOwnerId(Long userId);

}
