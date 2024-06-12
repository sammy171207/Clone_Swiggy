package spicestory.spicestory.request;

import lombok.Data;
import spicestory.spicestory.model.Category;
import spicestory.spicestory.model.IngredientItem;

import java.util.List;

@Data
public class CreateFoodRequest {
    private  String name;
    private String description;
    private Long price;

    private Category category;
    private List<String>images;

    private  Long restaurantId;
    private boolean vegetarin;
    private  boolean seasional;

    private List<IngredientItem>ingredients;

}
