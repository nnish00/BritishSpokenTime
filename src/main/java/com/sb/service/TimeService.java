package com.sb.service;

import com.sb.constants.AppConstants;
import org.springframework.stereotype.Service;

/**
 * Service class responsible for converting time to words.
 */
@Service
public class TimeService {

    /**
     * Converts the given time to words.
     * @param time The time in the format "HH:mm".
     * @return The time in words.
     */
    public String convertTimeToWords(String time){
        // Splitting the time into hours and minutes
        var timeParts = time.split(AppConstants.COLON);
        var hours = Integer.parseInt(timeParts[0]);
        var mins = Integer.parseInt(timeParts[1]);
        return getTimeName(hours, mins);
    }

    /**
     * Gets the time name based on the hours and minutes.
     * @param hours The hour component of the time.
     * @param mins The minute component of the time.
     * @return The time in words.
     */
    private String getTimeName(int hours, int mins) {
        var timeName = getSpecialTimes(hours, mins);
        if(timeName == null){
            timeName = getOtherTime(hours, mins);
        }
        return timeName;
    }

    /**
     * Gets the special time names like midnight or noon.
     * @param hours The hour component of the time.
     * @param mins The minute component of the time.
     * @return The special time name, or null if not a special time.
     */
    private String getSpecialTimes(int hours, int mins) {
        if(hours == 0 && mins == 0){
            return AppConstants.MIDNIGHT;
        }
        if(hours == 12 && mins == 0){
            return AppConstants.NOON;
        }
        return null;
    }

    /**
     * Gets the time name for other cases.
     * @param hours The hour component of the time.
     * @param mins The minute component of the time.
     * @return The time in words.
     */
    private String getOtherTime(int hours, int mins) {
        if(mins == 0){
            return hoursToWords(hours) + AppConstants.SPACE + AppConstants.O_CLOCK;
        } else if(mins == 30){
            return AppConstants.HALF_PAST + AppConstants.SPACE + hoursToWords(hours);
        } else if(mins < 30){
            return minsToWords(mins) + AppConstants.SPACE + AppConstants.PAST + AppConstants.SPACE + hoursToWords(hours);
        } else {
            hours = (hours + 1) % 24;
            return minsToWords(60 - mins) + AppConstants.SPACE + AppConstants.TO + AppConstants.SPACE + hoursToWords(hours);
        }
    }

    /**
     * Converts the hour component of time to words.
     * @param hours The hour component of the time.
     * @return The hour in words.
     */
    private String hoursToWords(int hours) {
        return switch(hours){
            case 0, 12 -> AppConstants.TWELVE;
            case 1, 13 -> AppConstants.ONE;
            case 2, 14 -> AppConstants.TWO;
            case 3, 15 -> AppConstants.THREE;
            case 4, 16 -> AppConstants.FOUR;
            case 5, 17 -> AppConstants.FIVE;
            case 6, 18 -> AppConstants.SIX;
            case 7, 19 -> AppConstants.SEVEN;
            case 8, 20 -> AppConstants.EIGHT;
            case 9, 21 -> AppConstants.NINE;
            case 10, 22 -> AppConstants.TEN;
            case 11, 23 -> AppConstants.ELEVEN;
            default -> throw new IllegalStateException("Unexpected Value: " + hours);
        };
    }

    /**
     * Converts the minute component of time to words.
     * @param mins The minute component of the time.
     * @return The minute in words.
     */
    private String minsToWords(int mins) {
        return switch(mins){
            case 1, 59 -> AppConstants.ONE;
            case 2, 58 -> AppConstants.TWO;
            case 3, 57 -> AppConstants.THREE;
            case 4, 56 -> AppConstants.FOUR;
            case 5, 55 -> AppConstants.FIVE;
            case 6, 54 -> AppConstants.SIX;
            case 7, 53 -> AppConstants.SEVEN;
            case 8, 52 -> AppConstants.EIGHT;
            case 9, 51 -> AppConstants.NINE;
            case 10, 50 -> AppConstants.TEN;
            case 11, 49 -> AppConstants.ELEVEN;
            case 12, 48 -> AppConstants.TWELVE;
            case 13, 47 -> AppConstants.THIRTEEN;
            case 14, 46 -> AppConstants.FOUR + AppConstants.TEEN;
            case 15, 45 -> AppConstants.QUARTER;
            case 16, 44 -> AppConstants.SIX + AppConstants.TEEN;
            case 17, 43 -> AppConstants.SEVEN + AppConstants.TEEN;
            case 18, 42 -> AppConstants.EIGHT + AppConstants.TEEN;
            case 19, 41 -> AppConstants.NINE + AppConstants.TEEN;
            case 20, 40 -> AppConstants.TWENTY;
            case 21, 39 -> AppConstants.TWENTY + AppConstants.SPACE + AppConstants.ONE;
            case 22, 38 -> AppConstants.TWENTY + AppConstants.SPACE + AppConstants.TWO;
            case 23, 37 -> AppConstants.TWENTY + AppConstants.SPACE + AppConstants.THREE;
            case 24, 36 -> AppConstants.TWENTY + AppConstants.SPACE + AppConstants.FOUR;
            case 25, 35 -> AppConstants.TWENTY + AppConstants.SPACE + AppConstants.FIVE;
            case 26, 34 -> AppConstants.TWENTY + AppConstants.SPACE + AppConstants.SIX;
            case 27, 33 -> AppConstants.TWENTY + AppConstants.SPACE + AppConstants.SEVEN;
            case 28, 32 -> AppConstants.TWENTY + AppConstants.SPACE + AppConstants.EIGHT;
            case 29, 31 -> AppConstants.TWENTY + AppConstants.SPACE + AppConstants.NINE;
            default -> throw new IllegalStateException("Unexpected Value: " + mins);
        };
    }
}
