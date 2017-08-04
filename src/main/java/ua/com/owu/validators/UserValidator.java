package ua.com.owu.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import ua.com.owu.entity.User;
import ua.com.owu.service.UserService;

import java.util.regex.Pattern;

/**
 * Created by User on 25.06.2017.
 */
public class UserValidator implements Validator {

    private final static Pattern REG = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$");

    private UserService userService;

    public UserValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return  User.class.equals(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {

    final User user = (User) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "", "Can`t be empty");

        if(!REG.matcher(user.getEmail()).matches()){
            errors.rejectValue("email", "", "Email is incorrect ");
        }
    }
}
