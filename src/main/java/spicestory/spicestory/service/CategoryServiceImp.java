package spicestory.spicestory.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spicestory.spicestory.model.Category;
import spicestory.spicestory.model.Restaurant;
import spicestory.spicestory.repository.CartRepository;
import spicestory.spicestory.repository.CategoryRespository;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImp implements CategoryService{
   @Autowired
   private  RestaurantService restaurantService;

   @Autowired
  private CategoryRespository categoryRespository;

    @Override
    public Category createCategory(String name, Long userId) throws Exception {
        Restaurant restaurant=restaurantService.getRestaurantByUserId(userId);
        Category category=new Category();
        category.setName(name);
        category.setRestaurant(restaurant);

        return categoryRespository.save(category);
    }

    @Override
    public List<Category> findCategoryByRestaurant(Long id) throws Exception {
        Restaurant restaurant=restaurantService.getRestaurantByUserId(id);
        return categoryRespository.findByRestaurantId(restaurant.getId());
    }

    @Override
    public Category findbyCategory(Long id) throws Exception {
        Optional<Category>optionalCategory=categoryRespository.findById(id);
        if(optionalCategory.isEmpty()){
            throw new Exception("category not found");
        }
        return optionalCategory.get();
    }
}
