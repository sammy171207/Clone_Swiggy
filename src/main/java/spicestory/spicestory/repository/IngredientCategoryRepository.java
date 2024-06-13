package spicestory.spicestory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spicestory.spicestory.model.IngredientCategory;

import java.util.List;
@Repository
public interface IngredientCategoryRepository extends JpaRepository<IngredientCategory,Long> {

    List<IngredientCategory>findByRestaurantId(Long id);

}
