package fr.thomas.ohce;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

public class Main {
    private static final String LANGUAGE_FR = "fr";

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        if(getCurrentHour() < 18){
            System.out.println((getSystemLanguage().equals(LANGUAGE_FR)) ? "Bonjour" : "Hello");
        }
        else{
            System.out.println((getSystemLanguage().equals(LANGUAGE_FR)) ? "Bonsoir" : "Good evening");
        }

        String word = scanner.nextLine();
        String reverseWord = revertWord(word);

        System.out.println(reverseWord);

        if(word.equals(reverseWord)){
            System.out.println((getSystemLanguage().equals(LANGUAGE_FR)) ? "Bien dit !" : "Well said !");
        }

        if(getCurrentHour() < 18){
            System.out.println((getSystemLanguage().equals(LANGUAGE_FR)) ? "Bonne journée" : "Have a good day");
        }
        else {
            System.out.println((getSystemLanguage().equals(LANGUAGE_FR)) ? "Bonne soirée" : "Have a good evening");
        }
    }

    public static int getCurrentHour(){
        Instant instant = Instant.now();
        LocalDateTime ldt = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        return ldt.getHour();
    }

    public static String getSystemLanguage(){
        return Locale.getDefault().getLanguage();
    }

    public static String revertWord(String word){
        String[] splitWord = word.split("");
        Collections.reverse(Arrays.asList(splitWord));
        return String.join("", splitWord);
    }
}
