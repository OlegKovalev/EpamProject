package service;

public enum ErrorEnum {
    EMAIL_ERROR("input.error.email"),
    EMAIL_EXIST_ERROR("input.error.email_exist"),
    EMAIL_OR_PASSWORD_ERROR("input.error.email_or_pass"),
    PASSWORD_LENGTH_ERROR("input.error.password.length"),
    REPEAT_PASSWORD_ERROR("input.error.repeat_password"),
    FULLNAME_ERROR("input.error.fullname"),
    SUCCESS("input.error.success");

    private final String errorPath;

    ErrorEnum(String errorPath) {
        this.errorPath = errorPath;
    }

    public String getErrorPath() {
        return errorPath;
    }
}
