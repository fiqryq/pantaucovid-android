package com.sunflower.pantaucovid19.utils;

import android.text.format.DateFormat;

import java.util.Calendar;
import java.util.Date;

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
            Date date = Calendar.getInstance().getTime();
            String tanggal = (String) DateFormat.format("d", date); // 20
            String monthNumber = (String) DateFormat.format("M", date); // 06
            String year = (String) DateFormat.format("yyyy", date); // 2013

            int month = Integer.parseInt(monthNumber);
            String bulan = null;

            if (month == 1) {
                bulan = "Januari";
            } else if (month == 2) {
                bulan = "Februari";
            } else if (month == 3) {
                bulan = "Maret";
            } else if (month == 4) {
                bulan = "April";
            } else if (month == 5) {
                bulan = "Mei";
            } else if (month == 6) {
                bulan = "Juni";
            } else if (month == 7) {
                bulan = "Juli";
            } else if (month == 8) {
                bulan = "Agustus";
            } else if (month == 9) {
                bulan = "September";
            } else if (month == 10) {
                bulan = "Oktober";
            } else if (month == 11) {
                bulan = "November";
            } else if (month == 12) {
                bulan = "Desember";
            }
            return getNameDay() + ", " + tanggal + " " + bulan + " " + year;
        }

        public static String getGithubUrl(String username){
            return "https://github.com/";
        }

    }

}
