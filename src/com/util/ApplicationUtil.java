package com.util;

import com.exception.InvalidBookException;

import java.text.SimpleDateFormat;
import java.util.*;

public class ApplicationUtil {
    public static List<String> extractDetails(String[] books) {
        List<String> bookList = new ArrayList<String>();
        // Write code

        for (String book:books) {
            String[] temp = book.split(":");

            try {
                if (validateBook(temp[1])) {
                    bookList.add(book);
                }
            } catch (InvalidBookException e) {

            }
        }

        return bookList;
    }

    public static boolean validateBook(String department) throws InvalidBookException {

        // Write code
        boolean result = false;

        if (department.equalsIgnoreCase("CSE") || department.equalsIgnoreCase("EEE") || (department.equalsIgnoreCase("CIVIL") || (department.equalsIgnoreCase("MECH")))) {
            result = true;
        } else {
            throw new InvalidBookException(department + " is an invalid department");
        }

        return result;
    }

    public static java.util.Date stringToDateConverter(String date) {
        // Write code

        java.util.Date utDate = new java.util.Date();

        try {
            utDate = new SimpleDateFormat("yyyy-MM-dd").parse(date);
        } catch (Exception e) {

        }

        return utDate;
    }

    public static java.sql.Date utilToSqlDateConverter(java.util.Date utDate) {
        // Write code

        java.sql.Date sqlDate = new java.sql.Date(utDate.getTime());

        return sqlDate;
    }

    public static java.util.Date sqlToUtilDateConverter(java.sql.Date sDate) {
        // Write code

        java.util.Date utDate = new java.util.Date(sDate.getTime());

        return utDate;
    }
}
