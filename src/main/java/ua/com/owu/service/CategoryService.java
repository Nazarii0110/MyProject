package ua.com.owu.service;

import ua.com.owu.entity.Category;

import java.util.List;

/**
 * Created by User on 24.06.2017.
 */
public interface CategoryService {

    void save(String catname, String description );

    void save(Category category);

    void deleteCatById(int id);


    Category findCategoryByCatname(String catname);

    Category findOneById(int id);

    List<Category> findAllCategory();

    Category findCatWithAllProd(int id);

}
