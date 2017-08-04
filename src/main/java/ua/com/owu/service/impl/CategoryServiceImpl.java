package ua.com.owu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.owu.dao.CategoryDAO;
import ua.com.owu.entity.Category;
import ua.com.owu.service.CategoryService;

import java.util.List;

/**
 * Created by User on 24.06.2017.
 */

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private  CategoryDAO categoryDAO;

    @Override
    public void save(String catname, String description) {

        if(catname != null && !catname.isEmpty()){
            Category category = Category.builder().catname(catname).description(description).build();
            categoryDAO.save(category);

        }else{
            System.out.println("ERROR!");
        }

    }

    @Override
    public void save(Category category) {

        categoryDAO.save(category);
    }

    @Override
    public void deleteCatById(int id) {

        categoryDAO.delete(id);

    }

    @Override
    public Category findCategoryByCatname(String catname) {
        return categoryDAO.findCategoryByCatname(catname);
    }


    @Override
    public Category findOneById(int id) {
        if(id > 0){
    return categoryDAO.findOne(id);
        }else {
            return null;
        }
    }

    @Override
    public List<Category> findAllCategory() {
        return categoryDAO.findAll();
    }

    @Override
    public Category findCatWithAllProd(int id) {
        return categoryDAO.findOneCatWithAllProd(id);
    }
}
