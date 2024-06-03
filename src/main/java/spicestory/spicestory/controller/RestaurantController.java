package spicestory.spicestory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spicestory.spicestory.dto.RestaurantDto;
import spicestory.spicestory.model.Restaurant;
import spicestory.spicestory.model.User;
import spicestory.spicestory.request.CreateRestaurantRequest;
import spicestory.spicestory.service.RestaurantService;
import spicestory.spicestory.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/restaurant")
public class RestaurantController {

        @Autowired
        private RestaurantService restaurantService;

        @Autowired
        private UserService userService;
        @GetMapping("/search")
        public ResponseEntity<List<Restaurant>>searchRestaurant(
                @RequestParam String keyword,
                @RequestHeader("Authorization") String jwt
        )throws Exception{
            User user=userService.findUserbyJwtToken(jwt);
           List< Restaurant >restaurant=restaurantService.searchRestaurant(keyword);

            return new ResponseEntity<>(restaurant, HttpStatus.OK);
        }

    @GetMapping()
    public ResponseEntity<List<Restaurant>>getAllRestaurant(
            @RequestHeader("Authorization") String jwt
    )throws Exception{
        User user=userService.findUserbyJwtToken(jwt);
        List< Restaurant >restaurant=restaurantService.getAllRestaurant();

        return new ResponseEntity<>(restaurant, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Restaurant>findRestaurantById(
            @RequestHeader("Authorization") String jwt,
            @PathVariable Long id
    )throws Exception{
        User user=userService.findUserbyJwtToken(jwt);
        Restaurant restaurant=restaurantService.findRestaurantById(id);

        return new ResponseEntity<>(restaurant, HttpStatus.OK);
    }


    @PutMapping("/{id}/add-favorites")
    public ResponseEntity<RestaurantDto>addToFavorites(
            @RequestHeader("Authorization") String jwt,
            @PathVariable Long id
    )throws Exception{
        User user=userService.findUserbyJwtToken(jwt);
        RestaurantDto restaurant=restaurantService.addToFavorites(id,user);

        return new ResponseEntity<>(restaurant, HttpStatus.OK);
    }

}
