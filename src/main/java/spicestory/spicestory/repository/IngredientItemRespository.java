package spicestory.spicestory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spicestory.spicestory.model.IngredientItem;

import java.util.List;
@Repository
public interface IngredientItemRespository extends JpaRepository<IngredientItem,Long> {
  List<IngredientItem>findByRestaurantId(Long id);
}
