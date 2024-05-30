package spicestory.spicestory.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spicestory.spicestory.config.JwtProvider;
import spicestory.spicestory.model.User;
import spicestory.spicestory.repository.UserRepository;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private  UserRepository userRepository;
    @Autowired
    private JwtProvider jwtProvider;
    @Override
    public User findUserbyJwtToken(String jwt) throws Exception {
        String email=jwtProvider.getEmailFromJwtToken(jwt);
        User user=findUserbyEmail(email);
        return user;
    }

    @Override
    public User findUserbyEmail(String email) throws Exception {
        User user=userRepository.findByEmail(email);
        if(user==null){
            throw new Exception("user not found");
        }
        return user;
    }
}
