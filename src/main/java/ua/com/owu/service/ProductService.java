package ua.com.owu.service;

import ua.com.owu.entity.Product;

import java.util.List;


/**
 * Created by User on 25.06.2017.
 */
public interface ProductService {

    void save( String prodname,String proddescription, int prodprice , String prodpicture);

    void save(Product product);

    Product findOne(int id);

    List<Product> findAll();
}
