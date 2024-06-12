package spicestory.spicestory.service;

import spicestory.spicestory.model.Category;
import spicestory.spicestory.model.Food;
import spicestory.spicestory.model.Restaurant;
import spicestory.spicestory.request.CreateFoodRequest;

import java.util.List;

public interface FoodService {

    public Food createFood(CreateFoodRequest req, Category category, Restaurant restaurant);

    void deleteFood(Long foodId)throws Exception;

    public List<Food>getRestaurantFood(Long restaurantId,boolean isVegitarian,
                                       boolean isNonveg,
                                       boolean isSeasonal
                                       ,String foodCategory);

    public  List<Food>searchFood(String keyword);

    public Food findFoodbyId(Long foodId)throws  Exception;

    public  Food updateAvailibitityStatus(Long foodId)throws Exception;


}
