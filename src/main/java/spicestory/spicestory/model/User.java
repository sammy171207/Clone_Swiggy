package spicestory.spicestory.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import spicestory.spicestory.dto.RestaurantDto;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private  String fullname;
    private  String email;
    private  String password;
    private USER_ROLE role=USER_ROLE.ROLE_CUSTOMER;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "customer")
    private List <Order> orders =new ArrayList<>();
    @ElementCollection
     private List <RestaurantDto> favorites=new ArrayList<>();

     @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
     private List <Address> address=new ArrayList<>();
    

}
