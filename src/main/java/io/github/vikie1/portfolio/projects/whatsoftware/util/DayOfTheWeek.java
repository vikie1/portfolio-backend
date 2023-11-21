package io.github.vikie1.portfolio.projects.whatsoftware.util;

import java.util.Calendar;

public class DayOfTheWeek {
    static public String getDayById(int dayNumber) {
        return switch (dayNumber) {
            case Calendar.SUNDAY -> "Sunday";
            case Calendar.MONDAY -> "Monday";
            case Calendar.TUESDAY -> "Tuesday";
            case Calendar.WEDNESDAY -> "Wednesday";
            case Calendar.THURSDAY -> "Thursday";
            case Calendar.FRIDAY -> "Friday";
            case Calendar.SATURDAY -> "Saturday";
            default -> throw new DayNotFoundException("Expected 1 <= " + dayNumber + " <= 7 ");
        };
    }

    static public int getIdByDay(String dayOfTheWeek){
        return switch (dayOfTheWeek.toLowerCase()) {
            case "sunday" -> Calendar.SUNDAY;
            case "monday" -> Calendar.MONDAY;
            case "tuesday" -> Calendar.TUESDAY;
            case "wednesday" -> Calendar.WEDNESDAY;
            case "thursday" -> Calendar.THURSDAY;
            case "friday" -> Calendar.FRIDAY;
            case "saturday" -> Calendar.SATURDAY;
            default -> throw new DayNotFoundException("Expected English Days Monday - Sunday");
        };
    }

    static class DayNotFoundException extends Error{
        DayNotFoundException(String exceptionMessage){ super(exceptionMessage); }
    }
}
