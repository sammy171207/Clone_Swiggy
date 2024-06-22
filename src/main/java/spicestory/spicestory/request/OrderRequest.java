package spicestory.spicestory.request;

import lombok.Data;
import spicestory.spicestory.model.Address;

@Data
public class OrderRequest {

    private Long restaurantId;

    private Address deliveryAddress;
}
