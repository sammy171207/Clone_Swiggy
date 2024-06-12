package spicestory.spicestory.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spicestory.spicestory.model.Food;
import spicestory.spicestory.model.Restaurant;
import spicestory.spicestory.model.User;
import spicestory.spicestory.request.CreateFoodRequest;
import spicestory.spicestory.service.FoodService;
import spicestory.spicestory.service.RestaurantService;
import spicestory.spicestory.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/food")
public class FoodController {

    @Autowired
    private FoodService foodService;

    @Autowired
    private UserService userService;
    @Autowired
    private RestaurantService restaurantService;


    @GetMapping("/search")
    public ResponseEntity<List<Food>>searchFood(@RequestParam String name,
            @RequestHeader("Authorization")String jwt) throws Exception{
        User user=userService.findUserbyJwtToken(jwt);
        List<Food>foods =foodService.searchFood(name);
        return new ResponseEntity<>(foods,HttpStatus.CREATED);
    }


    @GetMapping("/restaurant/{restaurantId}")
    public ResponseEntity<List<Food>>getRestaurantFood(@RequestParam boolean vegetarian,
                                                       @RequestParam boolean seasonal,
                                                       @RequestParam boolean nonveg,
                                                       @RequestParam(required = false)String food_category,
                                                       @PathVariable Long restaurantId,
                                                @RequestHeader("Authorization")String jwt) throws Exception{
        User user=userService.findUserbyJwtToken(jwt);
        List<Food>foods =foodService.getRestaurantFood(restaurantId,vegetarian,nonveg,seasonal,food_category);
        return new ResponseEntity<>(foods,HttpStatus.CREATED);
    }

}
