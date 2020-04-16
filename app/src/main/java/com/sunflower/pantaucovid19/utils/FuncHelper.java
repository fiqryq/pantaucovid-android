package com.sunflower.pantaucovid19.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Faisal Amir
 * FrogoBox Inc License
 * =========================================
 * Pantau-Covid19
 * Copyright (C) 12/04/2020.
 * All rights reserved
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * LinkedIn : linkedin.com/in/faisalamircs
 * -----------------------------------------
 * FrogoBox Software Industries
 * com.sunflower.pantaucovid19.utils
 */
public class FuncHelper {

    public static class Func {

        public static String getNameDay() {
            Date dateNow = Calendar.getInstance().getTime();
            String day = (String) android.text.format.DateFormat.format("EEEE", dateNow);
            if (day.equalsIgnoreCase("sunday")) {
                return "minggu";
            } else if (day.equalsIgnoreCase("monday")) {
                return "senin";
            } else if (day.equalsIgnoreCase("tuesday")) {
                return "selasa";
            } else if (day.equalsIgnoreCase("wednesday")) {
                return "rabu";
            } else if (day.equalsIgnoreCase("thursday")) {
                return "kamis";
            } else if (day.equalsIgnoreCase("friday")) {
                return "jumat";
            } else if (day.equalsIgnoreCase("saturday")) {
                return "sabtu";
            } else {
                return "error";
            }

        }

        public static String getTimeNow() {
            Locale id = new Locale("in", "ID");
            String pattern = "EEEE, dd MMMM yyyy";
            Date today = new Date();

            // Gets formatted date specify by the given pattern for
            // Indonesian Locale no changes for default date format
            // is applied here.
            SimpleDateFormat sdf = new SimpleDateFormat(pattern, id);
            return sdf.format(today);
        }

        public static String getGithubUrl(String username){
            return "https://github.com/"+username;
        }

    }

}
