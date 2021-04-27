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
        String regex = "^[\\p{L} .'-]+$";
        Pattern pattern = Pattern.compile(regex,Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(name);

        if (!matcher.find()) {
            throw new Exception(name + " is not valid!");
        }
    }
}
