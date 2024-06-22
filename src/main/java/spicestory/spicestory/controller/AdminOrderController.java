package spicestory.spicestory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spicestory.spicestory.model.Order;
import spicestory.spicestory.model.User;
import spicestory.spicestory.request.OrderRequest;
import spicestory.spicestory.service.OrderService;
import spicestory.spicestory.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminOrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;



    @GetMapping("/order/restaurant/{id}")
    public ResponseEntity<List<Order>>getOrderHistory(@PathVariable Long id,@RequestParam(required = false)String order_status,@RequestBody OrderRequest request, @RequestHeader("Authorization")String jwt)throws Exception{
        User user=userService.findUserbyJwtToken(jwt);
        List<Order> orders=orderService.getRestaurantOrder(id,order_status);

        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @PutMapping("/order/{orderId}/{orderStatus}")
    public ResponseEntity<Order>updateOrderStatus(@PathVariable Long id,@PathVariable String orderStatus,@RequestParam(required = false)String order_status,@RequestBody OrderRequest request, @RequestHeader("Authorization")String jwt)throws Exception{
        User user=userService.findUserbyJwtToken(jwt);
        Order orders=orderService.updateOrder(id,orderStatus);

        return new ResponseEntity<>(orders, HttpStatus.OK);
    }
}
