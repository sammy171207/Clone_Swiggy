package spicestory.spicestory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spicestory.spicestory.model.Category;
import spicestory.spicestory.model.User;
import spicestory.spicestory.service.CategoryService;
import spicestory.spicestory.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private UserService userService;

    @PostMapping("/admin/category")
    public ResponseEntity<Category> createCategory(@RequestBody Category category, @RequestHeader("Authorization")String jwt) throws Exception{
        User user=userService.findUserbyJwtToken(jwt);
        Category createdCategory=categoryService.createCategory(category.getName(),user.getId());
        return  new ResponseEntity<>(createdCategory,HttpStatus.CREATED);
    }
    @GetMapping("/category/restaurant")
    public ResponseEntity<List<Category>> getRestaurantCategory( @RequestHeader("Authorization")String jwt) throws Exception{
        User user=userService.findUserbyJwtToken(jwt);
        List<Category> categories=categoryService.findCategoryByRestaurant(user.getId());
        return  new ResponseEntity<>(categories,HttpStatus.CREATED);
    }
}
