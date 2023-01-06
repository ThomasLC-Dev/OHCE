package fr.thomas.ohce;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        DetectionPalindrome detectionPalindrome = new DetectionPalindrome(getSystemLanguage(), getCurrentHour());
        System.out.println(detectionPalindrome.traiter(scanner.nextLine()));
    }

    public static int getCurrentHour(){
        Instant instant = Instant.now();
        LocalDateTime ldt = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        return ldt.getHour();
    }

    public static String getSystemLanguage(){
        return Locale.getDefault().getLanguage();
    }

}
