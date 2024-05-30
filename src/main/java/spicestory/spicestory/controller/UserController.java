package spicestory.spicestory.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spicestory.spicestory.model.User;
import spicestory.spicestory.service.UserService;

@RestController
@RequestMapping("api/users")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/profile")
    public ResponseEntity<User>findUserbyJwtToken(@RequestHeader("Authorization")String jwt) throws Exception {
        User user=userService.findUserbyJwtToken(jwt);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
