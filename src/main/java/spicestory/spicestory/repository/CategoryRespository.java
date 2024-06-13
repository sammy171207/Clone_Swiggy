package spicestory.spicestory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spicestory.spicestory.model.Category;

import java.util.List;

public interface CategoryRespository extends JpaRepository<Category,Long> {
public List<Category>findByRestaurantId(Long id);



}
