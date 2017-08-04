package ua.com.owu.service.editors;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.com.owu.entity.Category;
import ua.com.owu.service.CategoryService;

import java.beans.PropertyEditorSupport;

@Component
public class CategoryEditor extends PropertyEditorSupport {
    @Autowired
    private CategoryService categoryService;

    @Override
    public void setAsText(String id) throws IllegalArgumentException {

        int idCategory = Integer.parseInt(id);
        Category category = categoryService.findOneById(idCategory);
        setValue(category);
    }
}
