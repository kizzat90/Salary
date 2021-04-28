package com.salary.app.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {

    private static Regex instance;

    private Regex () {}

    public static Regex getInstance() {
        if (instance == null) {
            instance = new Regex();
        }
        return instance;
    }

    public void validateName(String name) throws Exception {
        String regex = "^[a-zA-Z\\s]{3,}$";
        Pattern pattern = Pattern.compile(regex,Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(name);

        if (!matcher.find()) {
            throw new Exception(name + " is not valid!");
        } else if (name.trim().length() < 3) {
            throw new Exception("Whitespace is not allowed at the start or end of name");
        }
    }

    public void validateWholeNumber(Long number) throws Exception {
        String regex = "\\b([0-9]|[1-9][0-9]|[1-9][0-9][0-9]|[1-9][0-9][0-9][0-9]|[1-9][0-9][0-9][0-9][0-8]|99999)\\b";
        Pattern pattern = Pattern.compile(regex,Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(number.toString());

        if (!matcher.find()) {
            throw new Exception(number + " is not valid!");
        }
    }
}
