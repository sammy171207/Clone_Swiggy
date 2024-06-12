package spicestory.spicestory.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spicestory.spicestory.model.Category;
import spicestory.spicestory.model.Food;
import spicestory.spicestory.model.Restaurant;
import spicestory.spicestory.repository.FoodRepository;
import spicestory.spicestory.request.CreateFoodRequest;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FoodServiceImp implements FoodService {
    @Autowired
    private FoodRepository foodRepository;




    @Override
    public Food createFood(CreateFoodRequest req, Category category, Restaurant restaurant) {
         Food food =new Food();
         food.setFoodCategory(category);
         food.setRestaurant(restaurant);
         food.setDescription(req.getDescription());
         food.setImages(req.getImages());
         food.setName(req.getName());
         food.setPrice(req.getPrice());
         food.setIngredients(req.getIngredients());
         food.setIsSeasonal(req.isSeasional());
         food.setIsVegetarian(req.isVegetarin());
       Food savedFood= foodRepository.save(food);
       restaurant.getFoods().add(savedFood);
       return savedFood;
    }

    @Override
    public void deleteFood(Long foodId) throws Exception {
        Food food=findFoodbyId(foodId);
        food.setRestaurant(null);
        foodRepository.save(food);



    }

    @Override
    public List<Food> getRestaurantFood(Long restaurantId, boolean isVegitarian, boolean isNonveg, boolean isSeasonal, String foodCategory) {

        List<Food>foods=foodRepository.findByRestaurantId(restaurantId);
        if(isVegitarian){
            foods=filterbyVegetarian(foods,isVegitarian);
        }
        if(isNonveg){
            foods=filterbyNonveg(foods,isNonveg);
        }
        if(isSeasonal){
            foods=filterbySeasonal(foods,isSeasonal);
        }
        if(foodCategory!=null && !foodCategory.equals("")){
            foods=filterByCategory(foods,foodCategory);
        }
        return foods;
    }

    private List<Food> filterByCategory(List<Food> foods, String foodCategory) {
        return foods.stream().filter(food -> {
            if(food.getFoodCategory()!=null){
                return food.getFoodCategory().getName().equals(foodCategory);
            }
            return false;
        }).collect(Collectors.toList());
    }

    private List<Food> filterbySeasonal(List<Food> foods, boolean isSeasonal) {
        return  foods.stream().filter(food -> food.isIsSeasonal()==isSeasonal).collect(Collectors.toList());
    }

    private List<Food> filterbyNonveg(List<Food> foods, boolean isNonveg) {
        return  foods.stream().filter(food -> food.isIsVegetarian()==false).collect(Collectors.toList());
    }

    private List<Food> filterbyVegetarian(List<Food> foods, boolean isVegitarian) {
        return  foods.stream().filter(food -> food.isIsVegetarian()==isVegitarian).collect(Collectors.toList());
    }

    @Override
    public List<Food> searchFood(String keyword) {
        return foodRepository.seacrhFood(keyword);
    }

    @Override
    public Food findFoodbyId(Long foodId) throws Exception {
        Optional<Food>optionalFood=foodRepository.findById(foodId);

        if(optionalFood.isEmpty()){
            throw new Exception("food not exist..");
        }
        return optionalFood.get();
    }

    @Override
    public Food updateAvailibitityStatus(Long foodId) throws Exception {
        Food food=findFoodbyId(foodId);
        food.setAvailable(!food.isAvailable());
        return foodRepository.save(food);
    }
}
