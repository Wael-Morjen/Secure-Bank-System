package com.project.banksystem.utils;

import java.time.Year;

public class AccountUtils {
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
