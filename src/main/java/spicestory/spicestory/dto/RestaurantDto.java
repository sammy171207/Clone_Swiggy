package spicestory.spicestory.dto;

import java.util.List;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class RestaurantDto {
     private String title;
     private List<String> images; 

     private String description;
     private Long id;
}
