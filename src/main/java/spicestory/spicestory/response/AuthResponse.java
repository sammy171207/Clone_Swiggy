package spicestory.spicestory.response;

import lombok.Data;
import spicestory.spicestory.model.USER_ROLE;
@Data
public class AuthResponse {
    private  String jwt;
    private String message;
    private USER_ROLE role;

}
