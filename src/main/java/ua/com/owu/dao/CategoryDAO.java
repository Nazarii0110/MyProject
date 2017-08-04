package ua.com.owu.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.com.owu.entity.Category;

/**
 * Created by User on 24.06.2017.
 */
public interface CategoryDAO extends JpaRepository<Category ,Integer> {

    @Query("from Category c join fetch c.products where c.id =:idC")
    Category findOneCatWithAllProd(@Param("idC") int id);

    @Query("from Category c where c.catname =:catname")
    Category findCategoryByCatname(@Param("catname") String catname);

}
