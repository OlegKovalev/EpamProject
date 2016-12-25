package service;

import org.apache.commons.validator.routines.EmailValidator;

import static service.ErrorEnum.*;

public class CheckInputValue {

    private static final EmailValidator emailValidator = EmailValidator.getInstance();

    private static final String FULL_NAME_REGEX = "([А-ЯЁA-Z][а-яёa-z]+[\\-\\s]?){3,}";

    public static ErrorEnum validateLogin(String email, String password) {

        if (!validateEmail(email)) {
            return EMAIL_ERROR;
        }
        if (!validatePassword(password)) {
            return PASSWORD_LENGTH_ERROR;
        }
        return SUCCESS;
    }

    public static ErrorEnum validateRegistration(String email, String fullName, String password, String repeatPassword) {

        ErrorEnum validateLoginResult = validateLogin(email, password);

        if (validateLoginResult != SUCCESS) {
            return validateLoginResult;
        }

        if (!validateFullname(fullName)) {
            return FULLNAME_ERROR;
        }

        if (!password.equals(repeatPassword)) {
            return REPEAT_PASSWORD_ERROR;
        }

        return SUCCESS;
    }


    public static ErrorEnum validateDropList(String schoolClass, String lesson, String statement) {
        if (schoolClass == null || schoolClass.equals("") || lesson == null || lesson.equals("") || statement == null || statement.equals("")) {
            return DROPLIST_ERROR;
        }
        return SUCCESS;
    }

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
