package com.optum.fs.rest.service.util.amazon.company.preparation.easy;

public class DaysBetweenDates {
    private final int[] months = {0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334, 365};

    private int betweenDates(String date1, String date2) {
        int d1 = getDays(date1);
        int d2 = getDays(date2);
        return d1 - d2;
    }

    private int getDays(String date1) {
        String[] ss = date1.split("-");
        int year = Integer.parseInt(ss[0]);
        int month = Integer.parseInt(ss[1]);
        int date = Integer.parseInt(ss[2]);

        int yDelta = year - 1900 - 1;//1 for current year exclusion;
        int dy = yDelta * 365 + yDelta / 4;// cause every 4 year starting from 1900 is leap year.
        int dm = months[month - 1];
        if (isLeapYear(year) && month - 1 >= 2) {
            dm++;
        }
        return dy + dm + date;
    }

    private boolean isLeapYear(int year) {
        return ((year % 100 != 0 && year % 4 == 0) || (year % 100 == 0 && year % 400 == 0));
    }

    public static void main(String[] args) {
        DaysBetweenDates daysBetweenDates = new DaysBetweenDates();
        String date1 = "2020-03-18";
        String date2 = "2000-04-18";
        System.out.println(" Number of days between " + date1 + " and " + date2 + " is = " + daysBetweenDates.betweenDates(date1, date2));
    }
}
