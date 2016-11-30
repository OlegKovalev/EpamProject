package service;

import org.apache.commons.validator.routines.EmailValidator;

import static service.ErrorEnum.*;

public class CheckInputValue {
   
    private static final EmailValidator emailValidator = EmailValidator.getInstance();

    private static final String FULL_NAME_REGEX = "([А-ЯЁ][а-яё]+[\\-\\s]?){3,}";

    public static ErrorEnum validateLogin(String email, String password) {
        
        if (!validateEmail(email)) {
            return EMAIL_ERROR;
        }
        if (!validatePassword(password)) {
            return PASSWORD_LENGTH_ERROR;
        }
        return SUCCESS;
    }


    /*public static String validateRegistration(String email, String firstName, String lastName, String password, String repeatPassword) {
        MessageProvider loginResult = validateLogin(email, password);
        if (loginResult != VALID) {
            return loginResult;
        }

        if (!validateFullname(firstName)) {
            return FIRSTNAME_INVALID_ERROR;
        }

        if (!validateFullname(lastName)) {
            return LASTNAME_INVALID_ERROR;
        }

        if (!validatePassword(repeatPassword)) {
            return PASSWORD_INVALID_ERROR;
        }

        if (!repeatPassword.equals(password)) {
            return REPEAT_PASSWORD_INVALID_ERROR;
        }

        return VALID;
    }*/


    public static boolean validateEmail(String email) {
        return emailValidator.isValid(email);
    }

    public static boolean validateFullname(String name) {
        return name != null && !name.isEmpty() && name.length() <= 100 && name.matches(FULL_NAME_REGEX);
    }

    public static boolean validatePassword(String password) {
        return password != null && !password.isEmpty() && password.length() <= 10 && password.length() >= 6;
    }
}
