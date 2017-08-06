package ua.com.owu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import ua.com.owu.entity.Category;
import ua.com.owu.entity.Product;
import ua.com.owu.entity.User;
import ua.com.owu.service.CategoryService;
import ua.com.owu.service.UserService;
//import ua.com.owu.service.editors.UserEditor;
import ua.com.owu.validators.ProductValidator;
import ua.com.owu.validators.UserValidator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Controller
public class MainController {

    @Autowired
    private UserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private UserValidator userValidator;

    @ModelAttribute("emptyUser")
    public User emptyUser() {
        return new User();
    }


    @Autowired
    private ProductValidator productValidator;

    @GetMapping("/")
    public String index() {

        return "index";
    }


    @ModelAttribute("emptyProduct")
    public Product emptyProduct() {
        return new Product();
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login";
    }


    @GetMapping("/admin/toAdminPage")
    public String adminPage(Model model) {
        model.addAttribute("categories", categoryService.findAllCategory());
        return "adminPage";
    }

    @InitBinder("emptyUser")
    public void binder(WebDataBinder dataBinder) {
//        dataBinder.registerCustomEditor(User.class, userEditor);
        dataBinder.addValidators(userValidator);
    }

    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("emptyUser") @Validated User emptyUser, BindingResult result) {
        if (result.hasErrors()) {
            return "index";
        }
        userService.save(emptyUser);
        return "index";
    }

    @GetMapping("/seeAllCat")
    public String seeAllCat(Model model) {
        model.addAttribute("categories", categoryService.findAllCategory());
        return "categoriesList";
    }

    @GetMapping("/seeAllCatWithProd-{xxx}")
    public String seeCatWithProd(@PathVariable("xxx") int id, Model model) {
        Category oneById = categoryService.findCatWithAllProd(id);
        model.addAttribute("category", oneById);

        return "index";
    }
}

