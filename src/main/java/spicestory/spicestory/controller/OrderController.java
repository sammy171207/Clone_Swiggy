package spicestory.spicestory.controller;

import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spicestory.spicestory.model.CartItem;
import spicestory.spicestory.model.Order;
import spicestory.spicestory.model.User;
import spicestory.spicestory.request.AddCartItemRequest;
import spicestory.spicestory.request.OrderRequest;
import spicestory.spicestory.service.OrderService;
import spicestory.spicestory.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;

    @PutMapping("/order")
    public ResponseEntity<Order> createOrder(@RequestBody OrderRequest request, @RequestHeader("Authorization")String jwt)throws Exception{
        User user=userService.findUserbyJwtToken(jwt);
        Order order=orderService.createOrder(request,user);

        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @GetMapping("/order/user")
    public ResponseEntity<List<Order>>getOrderHistory(@RequestBody OrderRequest request, @RequestHeader("Authorization")String jwt)throws Exception{
        User user=userService.findUserbyJwtToken(jwt);
        List<Order> orders=orderService.getUsersOrder(user.getId());

        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

}
