package com.cuprumz.multidatasource.web;

import com.cuprumz.multidatasource.dao.db2.ProductRepository;
import com.cuprumz.multidatasource.dao.db1.UserRepository;
import com.cuprumz.multidatasource.model.db1.User;
import com.cuprumz.multidatasource.model.db2.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class HelloController {
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;
    
    @Autowired
    private Random random;

    @GetMapping("/saveu")
    public User saveUser() {
        User u = new User();
        u.setEmail(random.nextInt(1000) + "test@test.com");
        u.setAge(random.nextInt(100));
        u.setName("test");

        return userRepository.save(u);
    }

    @GetMapping("/savep")
    public Product saveProduct() {
        Product p = new Product();
        p.setName("p_name"+random.nextInt(10));
        p.setPrice(random.nextInt(999));

        return productRepository.save(p);
    }
}
