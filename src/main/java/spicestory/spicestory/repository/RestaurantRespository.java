package spicestory.spicestory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import spicestory.spicestory.model.Restaurant;

import java.util.List;
@Repository
public interface RestaurantRespository extends JpaRepository<Restaurant,Long> {
    @Query("SELECT r FROM Restaurant r WHERE lower(r.name) LIKE lower(concat('%', :query, '%')) OR lower(r.cuisineType) LIKE lower(concat('%', :query, '%'))")
    List<Restaurant> findbySearchQuery(@Param("query") String query);

    Restaurant findByOwnerId(Long userId);

}
