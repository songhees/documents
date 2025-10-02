package org.example;

public enum Dept {
    CENTER_1234("1234", "1"),
    CENTER_4567("4567", "2"),
    CENTER_7890("4567", "4"),
    DEFAULT("7890", "6");

    private final String code;
    private final String account;

    Dept(String code, String account) {
        this.code = code;
        this.account = account;
    }

    public String getCode() {
        return code;
    }

    public String getAccount() {
        return account;
    }

    public static Dept valueOfDefault(String value) {
        try {
            return Dept.valueOf(value);
        } catch (IllegalArgumentException e) {
            return DEFAULT;
        }
    }
}