package spicestory.spicestory.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spicestory.spicestory.dto.RestaurantDto;
import spicestory.spicestory.model.Address;
import spicestory.spicestory.model.Restaurant;
import spicestory.spicestory.model.User;
import spicestory.spicestory.repository.AddressRespository;
import spicestory.spicestory.repository.RestaurantRespository;
import spicestory.spicestory.repository.UserRepository;
import spicestory.spicestory.request.CreateRestaurantRequest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public  class RestaurantServiceImp implements  RestaurantService{

    @Autowired
    private RestaurantRespository restaurantRespository;
     @Autowired
     private AddressRespository addressRespository;
      @Autowired
      private UserRepository userRepository;

    @Override
    public Restaurant createRestaurant(CreateRestaurantRequest req, User user) {
        Address address=addressRespository.save(req.getAddress());
        Restaurant restaurant=new Restaurant();
        restaurant.setAddress(address);
        restaurant.setContactInformation(req.getContactInformation());
        restaurant.setCuisineType(req.getCuisineType());
        restaurant.setDescription(req.getDescription());
        restaurant.setImages(req.getImages());
        restaurant.setName(req.getName());
        restaurant.setOpeningHours(req.getOpeningHours());
        restaurant.setRegistrationDate(LocalDateTime.now());
        restaurant.setOwner(user);


        return restaurantRespository.save(restaurant);
    }

    @Override
    public Restaurant updateRestaurant(Long restaurantId, CreateRestaurantRequest updatedRestaurant) throws Exception {
        Restaurant restaurant=findRestaurantById(restaurantId);
        if(restaurant.getCuisineType()!=null){
            restaurant.setCuisineType(updatedRestaurant.getCuisineType());
        }
        if(restaurant.getDescription()!=null){
            restaurant.setDescription(updatedRestaurant.getDescription());
        }
        if(restaurant.getName()!=null){
            restaurant.setName(updatedRestaurant.getName());
        }


        return  restaurantRespository.save(restaurant);
    }

    @Override
    public void deleteRestaurant(Long restaurantId) throws Exception {
        Restaurant restaurant=findRestaurantById(restaurantId);

        restaurantRespository.delete(restaurant);

    }

    @Override
    public List<Restaurant> getAllRestaurant() {


        return restaurantRespository.findAll();
    }

    @Override
    public List<Restaurant> searchRestaurant(String query) {
        return restaurantRespository.findbySearchQuery(query);
    }

    @Override
    public Restaurant findRestaurantById(Long id) throws Exception {

        Optional<Restaurant>opt =restaurantRespository.findById(id);
        if(opt.isEmpty()){
            throw  new Exception("not found ");
        }
        return opt.get();
    }

    @Override
    public Restaurant getRestaurantByUserId(Long userId) throws Exception {
        Restaurant restaurant=restaurantRespository.findByOwnerId(userId);
        if(restaurant==null){
            throw new Exception("restaurant not found with the owner id");
        }

        return restaurant;
    }

    @Override
    public RestaurantDto addToFavorites(Long restaurantId, User user) throws Exception {
       Restaurant restaurant=findRestaurantById(restaurantId);
       RestaurantDto dto=new RestaurantDto();
       dto.setDescription(restaurant.getDescription());
       dto.setImages(restaurant.getImages());
       dto.setTitle(restaurant.getName());
       dto.setId(restaurantId);
       if(user.getFavorites().contains(dto)){
           user.getFavorites().remove(dto);

       }
 else user.getFavorites().add(dto);
      userRepository.save(user);

        return dto;
    }

    @Override
    public Restaurant updateRestaurantStatus(Long id) throws Exception {

        Restaurant restaurant=findRestaurantById(id);
        restaurant.setOpen(!restaurant.isOpen());
        return restaurantRespository.save(restaurant);
    }
}
