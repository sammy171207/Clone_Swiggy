package spicestory.spicestory.request;

import lombok.Data;
import spicestory.spicestory.model.Address;
import spicestory.spicestory.model.ContactInformation;

import java.util.List;

@Data
public class CreateRestaurantRequest {

private  Long Id;
private  String name;
private String description;
private String cuisineType;
private Address address;
private ContactInformation contactInformation;
private String openingHours;
private List<String>images;

}
