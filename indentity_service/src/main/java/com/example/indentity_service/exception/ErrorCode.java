package com.example.indentity_service.exception;

public enum ErrorCode {

    Error_Uncategorized(9999, "Uncategorized"),
    Enum_Invalid(1000, "Not find enum"),
    Error_Existed(1001, "User Existed"),
    User_Invalid(1002, "Username must be at least 3 character"),
    Password_Invalid(1003, "Password must be at least 6 character")

    ;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    private int code;
    private String message;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
