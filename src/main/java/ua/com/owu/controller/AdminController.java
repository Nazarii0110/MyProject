package ua.com.owu.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ua.com.owu.entity.Category;
import ua.com.owu.entity.Product;
import ua.com.owu.service.CategoryService;

import ua.com.owu.service.ProductService;
import ua.com.owu.service.UserService;
import ua.com.owu.service.editors.CategoryEditor;
import ua.com.owu.validators.ProductValidator;

import java.io.File;
import java.io.IOException;

/**
 * Created by User on 24.06.2017.
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private CategoryService categoryService;
    @Autowired
    private UserService userService;
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryEditor categoryEditor;
    @Autowired
    private ProductValidator productValidator;

    @PostMapping("/toAdminPage")
    public String toAdminPage(Model model) {
        model.addAttribute("categories", categoryService.findAllCategory());
        return "adminPage";
    }

    //Без цього не відкриває всіх юзерів??чого??????
    @ModelAttribute("emptyProduct")
    public Product emptyProduct() {
        return new Product();
    }


    @PostMapping("/saveCategory")
    public String saveCategory(@RequestParam String catname,
                               @RequestParam String description){

//         @RequestParam("picture") MultipartFile multipartFile) throws IOException {
//           String realPath = System.getProperty("user.home") + File.separator + "images" + File.separator;
//           multipartFile.transferTo(new File(realPath + multipartFile.getOriginalFilename()));


        Category category= Category
                .builder()
                .catname(catname)
                .description(description)
                //.picture ("/picture/" + multipartFile.getOriginalFilename())
                .build();

        categoryService.save(category);
        return "adminPage";
    }


    @PostMapping("/saveProduct")
    public String saveProd(@ModelAttribute("emptyProduct") @Validated Product product,
                           @RequestParam String prodname,
                           @RequestParam String proddescription,
                           @RequestParam int prodprice,
                           @RequestParam ("prodpicture") MultipartFile multipartFile,
                           BindingResult bindingResult ) throws IOException {
        String realPath = System.getProperty("user.home") + File.separator + "images" + File.separator;
        multipartFile.transferTo(new File(realPath + multipartFile.getOriginalFilename()));

        if (bindingResult.hasErrors()) {
            return "adminPage";
        }
        product = Product
                .builder()
                .prodname(prodname)
                .proddescription(proddescription)
                .prodprice(prodprice)
                .prodpicture ("/picture/" + multipartFile.getOriginalFilename())
                .build();
        productService.save(product);
        return "redirect:/admin/toAdminPage";

    }

    @InitBinder("emptyProduct")
    public void binder(WebDataBinder dataBinder) {
        dataBinder.registerCustomEditor(Category.class, categoryEditor);
        dataBinder.addValidators(productValidator);
    }

    @GetMapping("/usersList")
    public String usersList(Model model) {
        model.addAttribute("users", userService.findAllUsers());
        return "adminPage";
    }


    @GetMapping("/deleteCategory")
    public String delCategory(@RequestParam String catname) {
        System.out.println(catname + "!!!");
        Category category = categoryService.findCategoryByCatname(catname);
        System.out.println(category);
        categoryService.deleteCatById(category.getId());
        return "adminPage";
    }


}
