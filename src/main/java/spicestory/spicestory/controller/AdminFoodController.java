package spicestory.spicestory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spicestory.spicestory.model.Food;
import spicestory.spicestory.model.Restaurant;
import spicestory.spicestory.model.User;
import spicestory.spicestory.request.CreateFoodRequest;
import spicestory.spicestory.response.MessageResponse;
import spicestory.spicestory.service.FoodService;
import spicestory.spicestory.service.RestaurantService;
import spicestory.spicestory.service.UserService;

@RestController
@RequestMapping("/api/admin/food")
public class AdminFoodController {

    @Autowired
    private FoodService foodService;

    @Autowired
    private UserService userService;
    @Autowired
    private RestaurantService restaurantService;


    @PostMapping
    public ResponseEntity<Food>createFood(@RequestBody CreateFoodRequest req, @RequestHeader("Authorization")String jwt) throws Exception{
        User user=userService.findUserbyJwtToken(jwt);
        Restaurant restaurant=restaurantService.findRestaurantById(req.getRestaurantId());
        Food food=foodService.createFood(req,req.getCategory(),restaurant);
        return new ResponseEntity<>(food, HttpStatus.CREATED);
    }

   @DeleteMapping("/{id}")
    public ResponseEntity<MessageResponse>deleteFood(@PathVariable Long id, @RequestHeader("Authorization")String jwt)throws  Exception{
        User user=userService.findUserbyJwtToken(jwt);
        foodService.deleteFood(id);
        MessageResponse res=new MessageResponse();
        res.setMessage("food deleted");
        return new ResponseEntity<>(res,HttpStatus.OK);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Food>updateFoodAvaibilityStatus(@PathVariable Long id, @RequestHeader("Authorization")String jwt) throws Exception{
         User user=userService.findUserbyJwtToken(jwt);
       Food food=  foodService.updateAvailibitityStatus(id);

        return new ResponseEntity<>(food,HttpStatus.OK);
    }

}
