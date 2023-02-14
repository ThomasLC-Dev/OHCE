package fr.thomas.ohce;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Collections;
import java.util.Locale;

public class DetectionPalindrome {
    public static final String LANGUAGE_FR = "fr";
    private String language;
    private int hour;

    public DetectionPalindrome(String language, int hour){
        this.language = language;
        this.hour = hour;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public String traiter(String word){
        String result = "";
        String reverseWord = revertWord(word);
        result += sayHello();
        result += reverseWord;
        result += (word.equals(reverseWord)) ? sayIsPalindrome() : "";
        result += sayBye();
        return result;
    }

    // Inverser le mot
    public String revertWord(String word){
        String[] splitWord = word.split("");
        Collections.reverse(Arrays.asList(splitWord));
        return String.join("", splitWord);
    }

    // Retourner Bonjour en fonction du temps et de la langue
    public String sayHello(){
        if(this.hour < 18){
            return (this.language.equals(LANGUAGE_FR)) ? "Bonjour" : "Hello";
        }
        else{
            return (this.language.equals(LANGUAGE_FR)) ? "Bonsoir" : "Good evening";
        }
    }

    // Retourner Au revoir en fonction du temps et de la langue
    public String sayBye(){
        if(this.hour < 18){
            return (this.language.equals(LANGUAGE_FR)) ? "Bonne journée" : "Have a good day";
        }
        else {
            return (this.language.equals(LANGUAGE_FR)) ? "Bonne soirée" : "Have a good evening";
        }
    }

    // Retourner Bien dit en fonction de la langue
    public String sayIsPalindrome(){
        return (this.language.equals(LANGUAGE_FR)) ? "Bien dit !" : "Well said !";
    }
}
