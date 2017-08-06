package ua.com.owu.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import ua.com.owu.entity.User;
import ua.com.owu.service.UserService;

import java.util.regex.Pattern;

/**
 * Created by User on 25.06.2017.
 */
@Component
public class UserValidator implements Validator {

    private final static Pattern REG = Pattern.compile("^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$");

    private UserService userService;

    public UserValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {

        final User user = (User) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "", "Can`t be empty");
        System.out.println(!REG.matcher(user.getEmail()).matches());
        if (!REG.matcher(user.getEmail()).matches()) {
            errors.rejectValue("email", "", "Email is incorrect ");
        }
    }
}
