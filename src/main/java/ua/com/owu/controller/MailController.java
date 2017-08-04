package ua.com.owu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.com.owu.entity.Product;
import ua.com.owu.service.MailService;

@Controller
public class MailController {

    @Autowired
    private MailService mailService;

    @ModelAttribute("emptyProduct")
    public Product emptyProduct() {
        return new Product();
    }
    @PostMapping("/sendEmail")
    public String sendEmail(@RequestParam("email") String email) {

        mailService.sendMail(email);
        return "adminPage";
    }
}
