package qac.preassessment.cinema;

import java.util.Calendar;
import java.time.LocalDateTime;

public class CDate {
    private int day;
    private int month;
    private int year;
    private String dayName ;
    private Calendar visit;
    private String[] strDaysOfWeek = {"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
    private boolean format;
    private boolean complete;

    CDate(){
        visit = Calendar.getInstance();
        format = false;
        complete = false;
    }

    public void enterDate(String inputDate){
        char ch = '/';
        if ((inputDate.length() == 10) && (inputDate.charAt(2) == ch) && (inputDate.charAt(5) == ch)) {
            try {
                day = Integer.parseInt(inputDate.substring(0, 2));
                month = Integer.parseInt(inputDate.substring(3, 5));
                year = Integer.parseInt(inputDate.substring(6, 10));

                if (chkDay(day) && chkMon(month) && chkYear(year)) {

                    getStrDayName(day, month, year);
                    format = true;
                }
                else {
                    System.out.println("You cannot select a date in the past. Try again.");
                }

            } catch (Exception e) {
                System.out.println("Sorry, the format was incorrect. Try again.");
                format = false;
            }
        }
        else{
            System.out.println("Sorry, the format was incorrect. Try again.");
        }
    }

    private boolean chkDay(int day) {
        int d = visit.get(Calendar.DAY_OF_MONTH);
        return d <= day;
    }

    private boolean chkMon(int mon) {
        int m = visit.get(Calendar.MONTH) + 1;
        return m <= mon;
    }

    private boolean chkYear(int yr) {
        int y = visit.get(Calendar.YEAR);
        return y <= yr;
    }

    public boolean getFormat(){
        return format;
    }

    private void getStrDayName(int day, int month, int year) {
        visit.set(year, month - 1, day);
        int day_of_week = visit.get(Calendar.DAY_OF_WEEK);
        dayName = strDaysOfWeek[day_of_week - 1];
    }

    public void checkDateSelected() {
        System.out.println("You have chosen " + dayName + " " + day + "/" + month + "/" + year);
        String s = InputHelper.getInput("To continue enter C, or any other key to choose another date ");

        if (s.toUpperCase().equals("C")) {
            complete = true;
        }
        else {
            format = false;
        }
    }

    public Boolean chosen(){
        return complete;
    }

    public String getDayName(){
        return dayName;
    }

    public int getDay(){
        return this.day;
    }

    public int getMonth(){
        return this.month;
    }

    public int getYear(){
        return this.year;
    }
}
