package spicestory.spicestory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spicestory.spicestory.model.IngredientCategory;
import spicestory.spicestory.model.IngredientItem;
import spicestory.spicestory.request.IngredientCategoryRequest;
import spicestory.spicestory.request.IngredientRequest;
import spicestory.spicestory.service.IngredientsService;

import java.util.List;

@RestController
@RequestMapping("/api/admin/ingredients")
public class IngredientController {
    @Autowired
    private IngredientsService ingredientsService;
   @PostMapping("/category")
    public ResponseEntity<IngredientCategory>createIngredientCategory(@RequestBody IngredientCategoryRequest req)throws Exception{
        IngredientCategory item=ingredientsService.createIngredientCategory(req.getName(), req.getRestaurantId());
        return  new ResponseEntity<>(item, HttpStatus.CREATED);
    }

    @PostMapping("")
    public ResponseEntity<IngredientItem>createIngredientItem(@RequestBody IngredientRequest req )throws Exception{
        IngredientItem item=ingredientsService.createIngredientItem(req.getRestaurantId(), req.getName(), req.getCategoryId());
        return  new ResponseEntity<>(item, HttpStatus.CREATED);
    }

    @PutMapping("/{id}/stock")
    public ResponseEntity<IngredientItem>updateIngredientStock(@PathVariable Long id )throws Exception{
        IngredientItem item=ingredientsService.updateStock(id);
        return new ResponseEntity<>(item,HttpStatus.OK);
    }

    @GetMapping("/restaurant/{id}")
    public ResponseEntity<List<IngredientItem>>getrestaurantIngredient(@PathVariable Long id )throws Exception{
        List<IngredientItem> item=ingredientsService.findRestaurantIngredients(id);
        return new ResponseEntity<>(item,HttpStatus.OK);
    }

    @GetMapping("/restaurant/{id}/category")
    public ResponseEntity<List<IngredientCategory>>getrestaurantIngredientCategory(@PathVariable Long id )throws Exception{
        List<IngredientCategory> item=ingredientsService.findIngredientCategoryByRestaurantId(id);
        return new ResponseEntity<>(item,HttpStatus.OK);
    }
}
