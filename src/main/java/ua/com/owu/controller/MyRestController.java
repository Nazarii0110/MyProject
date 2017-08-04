package ua.com.owu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import ua.com.owu.entity.Product;
import ua.com.owu.entity.User;
import ua.com.owu.service.ProductService;
import ua.com.owu.service.UserService;

import java.util.List;

/**
 * Created by User on 30.06.2017.
 */
@RestController
public class MyRestController {


    @Autowired
    private ProductService productService;
    @Autowired
    private UserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/findAllProd")
    public List<Product> findAllProd() {
        //System.out.println(productService.findAll());
        return productService.findAll();
    }

    @PostMapping("/saveUserRest")
    public void saveUserRest(@RequestBody User jsonObj) {
        jsonObj.setPassword(passwordEncoder.encode(jsonObj.getPassword()));
        userService.save(jsonObj);
    }

}
