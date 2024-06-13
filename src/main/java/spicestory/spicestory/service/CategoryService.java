package spicestory.spicestory.service;

import spicestory.spicestory.model.Category;

import java.util.List;

public interface CategoryService {
    public Category createCategory(String name,Long userId) throws Exception;
    public List<Category> findCategoryByRestaurant(Long id) throws Exception;
    public  Category findbyCategory(Long id)throws Exception;


}
