package ua.com.owu.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.owu.entity.Product;

/**
 * Created by User on 25.06.2017.
 */
public interface ProductDAO extends JpaRepository<Product , Integer> {
}
