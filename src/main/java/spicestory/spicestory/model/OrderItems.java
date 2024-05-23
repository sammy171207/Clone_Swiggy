package spicestory.spicestory.model;


import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class OrderItems {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long Id;
@ManyToOne
private Food food;

private int quantity;

private Long totalPrice;
private List<String> ingredient;

}
