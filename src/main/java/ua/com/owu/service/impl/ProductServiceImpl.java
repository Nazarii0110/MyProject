package ua.com.owu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.owu.dao.ProductDAO;
import ua.com.owu.entity.Category;
import ua.com.owu.entity.Product;
import ua.com.owu.service.ProductService;

import java.util.List;

/**
 * Created by User on 25.06.2017.
 */
@Service
@Transactional
public class ProductServiceImpl implements ProductService {


    @Autowired
    private ProductDAO productDAO;

    @Override
    public void save(String prodname, String proddescription, int prodprice, String prodpicture) {
        if(prodname != null && !prodname.isEmpty()){
            Product product = Product.builder().prodname(prodname).proddescription(proddescription).prodprice(prodprice).prodpicture(prodpicture) .build();
            productDAO.save(product);

        }else{
            System.out.println("ERROR!");
        }
    }

    @Override
    public void save(Product product) {
        productDAO.save(product);
    }

    @Override
    public Product findOne(int id) {
        return productDAO.findOne(id);
    }

    @Override
    public List<Product> findAll() {
        return productDAO.findAll();
    }
}
