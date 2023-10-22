package com.project.banksystem.utils;

import java.time.Year;

public class AccountUtils {
    public static final String ACCOUNT_EXISTS_CODE = "001";
    public static final String ACCOUNT_EXIST_MESSAGE = "This user already has an account created";
    public static final String ACCOUNT_CREATION_SUCCESS = "002";
    public static final String ACCOUNT_CREATION_MESSAGE = "Account has been successfully created";
    public static  final String ACCOUNT_NOT_EXIST_CODE = "003";
    public static final String ACCOUNT_NOT_EXIST_MESSAGE= "Account does not exist. please try again with valid credentials.";
    public static final String ACCOUNT_FOUND_CODE = "004";
    public static final String ACCOUNT_FOUND_MESSAGE = "User account found";
    public static final String ACCOUNT_CREDIT_SUCCESS_CODE= "005";
    public static final String ACCOUNT_CREDIT_SUCCESS_MESSAGE= "User account found";

    public static String generateAccountNumber() {
        /**
         * 2023 + randomSixDigits
         */
        Year currentYear = Year.now();
        int min = 100000;
        int max = 999999;

        // generate a random number between min and max
        int randNumber = (int) Math.floor(Math.random() * (max - min + 1) + min);

        // convert the current and randNumber to strings then concatenate them together
        String year = String.valueOf(currentYear);
        String randomNumber = String.valueOf(randNumber);

        return year + randomNumber;
    }

}
