package spicestory.spicestory.service;

import spicestory.spicestory.model.User;

public interface UserService {

    public User findUserbyJwtToken(String jwt) throws Exception;
    public User findUserbyEmail(String email) throws Exception;


}
